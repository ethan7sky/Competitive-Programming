import java.util.*;
import java.io.*;

public class PackingUnderRangeRegulations2 {
	
	static int t, n;
	static ball[] balls;
	static HashSet<Integer> used;
	static TreeSet<Integer> nextToUse;
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
			
			
			used = new HashSet<Integer>();
			nextToUse = new TreeSet<Integer>();
			
			for(ball b: balls) {
				
				int min = b.l;
				int max = b.r;
				
				if(!used.contains(min)) {
					nextToUse.add(min);
				}
				
				if(nextToUse.contains(min)) {
					used.add(min);
					nextToUse.remove(min);
					if(!used.contains(++min)) {
						nextToUse.add(min);
					}
				}
				else {
					int higher = nextToUse.higher(min);
					if(higher>max) {
						System.out.println("No");
						continue testcases;
					}
					else {
						used.add(higher);
						nextToUse.remove(higher);
						if(!used.contains(++higher)) {
							nextToUse.add(higher);
						}
					}
				}
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
