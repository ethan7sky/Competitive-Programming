import java.util.*;
import java.io.*;

public class USACOTargetPracticeII_2{
	
	static int t, n, x1;
	static int[] slopes;
	static ArrayList<yints> intercepts;
	static ArrayList<pair> targets;
	static ArrayList<Integer> negslopes, posslopes;
	static BufferedReader in;
	static StringTokenizer st;
	static long ans;
	static int[] yintcheckcnt;
	static int[] pointusingslope;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		
		while(t-->0) {
			
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			x1 = Integer.parseInt(st.nextToken());
			
			targets = new ArrayList<pair>();
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				int y1 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());

				targets.add(new pair(x1, y1));
				targets.add(new pair(x1, y2));
				targets.add(new pair(x2, y1));
				targets.add(new pair(x2, y2));
			}

			negslopes = new ArrayList<Integer>();
			posslopes = new ArrayList<Integer>();
			
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<n*4; i++) {
				int x = Integer.parseInt(st.nextToken());
				if(x<0)negslopes.add(x);
				else posslopes.add(x);
			}
			
			intercepts = new ArrayList<yints>();
			
			int slopeid=-1;
			for(int i: negslopes) {
				slopeid++;
				int pointid=-1;
				for(pair j: targets) {
					pointid++;
					intercepts.add(new yints(calcYIntercept(i, j.x, j.y), slopeid, pointid));
				}
			}
			Collections.sort(intercepts);
//			System.out.println(intercepts);
//			
			yintcheckcnt = new int[n*4];
			pointusingslope = new int[n*4];
			Arrays.fill(pointusingslope, -1);
			int[] slope = new int[n*4];
			
			for(int i=0; i<intercepts.size(); i++) {
				yints curr = intercepts.get(i);
				
				if(pointusingslope[curr.slopeid]!=-1) {
					if(yintcheckcnt[pointusingslope[curr.slopeid]]==negslopes.size()) {
						yintcheckcnt[curr.pointid]++;
						continue;
					}
					else {
						yintcheckcnt[curr.pointid]++;
						pointusingslope[curr.slopeid] = curr.pointid;
						slope[curr.pointid] =  curr.slopeid;
					}
				}
				else if(yintcheckcnt[curr.pointid]>0) {
					yintcheckcnt[curr.pointid]++;
					slope[curr.pointid] = curr.slopeid;
				}
				else {
					yintcheckcnt[curr.pointid]++;
					slope[curr.pointid] = curr.slopeid;
					pointusingslope[curr.slopeid] = curr.pointid; 
				}
				
			}
			System.out.println(Arrays.toString(slope));
			
		}
	}
	static Long calcYIntercept(int m, int x, int y) {
		return (long)-1*m*x+y;
	}
	
	
	static class yints implements Comparable<yints>{
		
		long yint;
		int slopeid, pointid;
		yints(long a, int b, int c){
			this.yint = a;
			this.slopeid = b;
			this.pointid = c;
		}
		public String toString() {
			return yint+" "+slopeid+" "+pointid;
		}
		
		@Override
		public int compareTo(yints that) {
			if(this.yint-that.yint>0) return -1;
			else if(this.yint-that.yint==0) return 0;
			return 1;
		}
		
	}
	static class pair {
		
		int x, y;
		pair(int a, int b){
			this.x = a;
			this.y = b;
		}
		public String toString() {
			return x+","+y;
		}
	}
}
