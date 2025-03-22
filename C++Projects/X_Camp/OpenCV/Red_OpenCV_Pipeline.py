import cv2
import numpy as np

def isVertical(angle):
    return 60 < angle < 120

def is_mostly_red(contour, mask, threshold=0.45):
    x, y, w, h = cv2.boundingRect(contour)  # Get bounding box
    roi = mask[y:y+h, x:x+w]  # Extract region of interest from the mask

    red_pixels = cv2.countNonZero(roi)  # Count red pixels
    total_pixels = w * h  # Total pixels in bounding box

    return (red_pixels / total_pixels) >= threshold

def watershed_separation(mask):
    kernel = np.ones((3, 3), np.uint8)
    mask = cv2.erode(mask, kernel, iterations=2)
    opening = cv2.morphologyEx(mask, cv2.MORPH_OPEN, kernel, iterations=3)
    
    # Sure background (dilated mask)
    sure_bg = cv2.dilate(opening, kernel, iterations=5)
    
    # Sure foreground (distance transform)
    dist_transform = cv2.distanceTransform(opening, cv2.DIST_L2, 5)
    _, sure_fg = cv2.threshold(dist_transform, 0.5 * dist_transform.max(), 255, 0)
    
    # Unknown region (subtracting foreground from background)
    sure_fg = np.uint8(sure_fg)
    unknown = cv2.subtract(sure_bg, sure_fg)
    
    # Marker labeling
    _, markers = cv2.connectedComponents(sure_fg)
    markers = markers + 1
    markers[unknown == 255] = 0  # Mark unknown regions as 0
    
    # Apply Watershed
    markers = cv2.watershed(cv2.cvtColor(mask, cv2.COLOR_GRAY2BGR), markers)
    
    return markers

def runPipeline(image, llrobot):
    hsv = cv2.cvtColor(image, cv2.COLOR_BGR2HSV)
    
    # Define range of red color in HSV
    lower_red1 = np.array([0, 100, 100])
    upper_red1 = np.array([10, 255, 255])
    lower_red2 = np.array([160, 100, 100])
    upper_red2 = np.array([180, 255, 255])
    
    mask1 = cv2.inRange(hsv, lower_red1, upper_red1)
    mask2 = cv2.inRange(hsv, lower_red2, upper_red2)
    mask = cv2.bitwise_or(mask1, mask2)

    
    # Apply morphological operations
    kernel = np.ones((5, 5), np.uint8)
    mask = cv2.morphologyEx(mask, cv2.MORPH_OPEN, kernel, iterations=1)
    mask = cv2.morphologyEx(mask, cv2.MORPH_CLOSE, kernel, iterations=1)

    # Apply Watershed Algorithm to separate touching prisms
    markers = watershed_separation(mask)
    
    # Create new mask where individual objects are better separated
    mask[markers == -1] = 0  # Remove watershed boundary pixels

    mask = cv2.erode(mask, kernel, iterations = 3)
    mask = cv2.dilate(mask, kernel, iterations = 3)

    # Edge detection
    edges = cv2.Canny(mask, 20, 100)

    kernel = np.ones((3, 3), np.uint8)
    dilated_edges = cv2.dilate(edges, kernel, iterations=1)

    # image = dilated_edges 

    # Find contours
    contours, _ = cv2.findContours(dilated_edges, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)
    
    valid_contours = []
    centers = []
    orientations = []
    
    for contour in contours:
        area = cv2.contourArea(contour)
        if area > 750 and is_mostly_red(contour, mask):
            rect = cv2.minAreaRect(contour)
            box = cv2.boxPoints(rect)
            box = np.int0(box)
            
            width, height = rect[1]
            aspect_ratio = max(width, height) / min(width, height)
            angle = rect[2]
            if width < height:
                angle += 90
            angle = 180 - angle
            
            if isVertical(angle) or 1.6 < aspect_ratio < 4.0:
                valid_contours.append(box)
                centers.append(rect[0])
                orientations.append(angle)

    # image = edges

    for i, box in enumerate(valid_contours):
       cv2.drawContours(image, [box], 0, (0, 255, 0), 2)
       center = tuple(map(int, centers[i]))
       cv2.circle(image, center, 5, (255, 0, 0), -1)
       cv2.putText(image, f"{orientations[i]:.1f}", (center[0]+10, center[1]+10),
                   cv2.FONT_HERSHEY_SIMPLEX, 0.5, (255, 255, 0), 2)

    llpython = [len(valid_contours)]
    for i in range(len(valid_contours)):
        llpython.append(centers[i][0])
        llpython.append(centers[i][1])
        llpython.append(orientations[i])
    if len(llpython) < 8:
        llpython += [0] * (8 - len(llpython))
    
    return np.array([]), image, llpython