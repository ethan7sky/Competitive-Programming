import java.util.*;
import java.io.*;

public class PackingUnderRangeRegulations {
	
	static int t, n;
	static ball[] balls;
	static TreeSet<Integer> boxes;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		
		testcases:
		while(t-->0) {
			n = Integer.parseInt(in.readLine());
			balls = new ball[n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				balls[i] = new ball(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(balls);
			
			
			boxes = new TreeSet<Integer>();
			boxes.add(0);
			boxes.add(Integer.MAX_VALUE);
			
			for(ball b: balls) {
				int lowestIdx = boxes.ceiling(b.l);
				int floorIdx = boxes.lower(lowestIdx);
				System.out.println(floorIdx);
				if(floorIdx<b.l-1) {
					boxes.add(b.l);
				}
				else if(floorIdx>=b.l-1 && floorIdx<=b.r-1) {
					boxes.add(floorIdx+1);
				}
				else {
					System.out.println("No");
					continue testcases;
				}
				System.out.println(boxes);
			}
			System.out.println("Yes");
		}
		
	}
	
	static class ball implements Comparable<ball> {
		int l, r;
		public ball(int a, int b) {
			this.l = a;
			this.r = b;
		}
		@Override
		public int compareTo(ball that) {
			if(this.r==that.r) {
				return this.l-that.l;
			}
			return this.r-that.r;
		}
		public String toString() {
			return l+" "+r;
		}
	}
}
