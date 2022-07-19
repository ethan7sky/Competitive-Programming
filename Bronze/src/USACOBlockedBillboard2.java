import java.util.*;
import java.io.*;

public class USACOBlockedBillboard2 {
	
	static Scanner in;
	static PrintWriter out;
	static int x1, y1, x2, y2, bx1, by1, bx2, by2, cnt;
	static boolean a[][];
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new FileReader("billboard.in"));
		out = new PrintWriter("billboard.out");
		
		bx1 = in.nextInt();
		by1 = in.nextInt();
		bx2 = in.nextInt();
		by2 = in.nextInt();
		x1 = in.nextInt();
		y1 = in.nextInt();
		x2 = in.nextInt();
		y2 = in.nextInt();
		
		if((bx1<x1&&by1<y1) || (bx2>x2&&by2>y2) || (by1 < y1 && bx2 > x2) || (bx1 < x1 && by2 > y2) || (bx1<x1&&bx2>x2&&by1>=y1&&by2<=y2) || (by2>y2&&by1<y1&&bx1>=x1&&bx2<=x2)) {
			out.println((bx2-bx1)*(by2-by1));
		}
		else {
			if(bx1>=x1&&by1>=y1&&bx2<=x2&&by2<=y2) {
				out.println(0);
			}
			
			else {
				a = new boolean[2001][2001];
				bx1 += 1000;
				by1 += 1000;
				bx2 += 1000;
				by2 += 1000;
				x1 += 1000;
				y1 += 1000;
				x2 += 1000;
				y2 += 1000;
				
				for(int i = bx1; i < bx2; i++) {
					for(int j = by1; j < by2; j++) {
						a[i][j] = true;
					}
				}
				for(int i = x1; i < x2; i++) {
					for(int j = y1; j < y2; j++) {
						a[i][j] = false;
					}
				}
				for(int i = 0; i < 2001; i++) {
					for(int j = 0; j < 2001; j++) {
						if(a[i][j]) {
							cnt++;
						}
					}
				}
				out.println(cnt);
			}
			
			
			
		}	
		
		in.close();
		out.close();
	}
}
