import java.util.*;
import java.io.*;

public class USACOTargetPracticeII {
	
	static int t, n, x1;
	static int[] slopes;
	static ArrayList<pair> targets;
	static BufferedReader in;
	static StringTokenizer st;
	static long ans;
	
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

				targets.add(new pair(x1, y1, false, false));
				targets.add(new pair(x1, y2, false, false));
				targets.add(new pair(x2, y1, true, false));
				targets.add(new pair(x2, y2, false, true));
			}
			slopes = new int[n*4];
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<n*4; i++) {
				slopes[i] = Integer.parseInt(st.nextToken());
			}
//			
//			System.out.println(Arrays.toString(slopes));
//			System.out.println(targets);
			
			ans = Long.MAX_VALUE;
			bruteforce(0, Long.MAX_VALUE, Long.MIN_VALUE, targets);
			
			if(ans == Long.MAX_VALUE) ans = -1;
			System.out.println(ans);
						
		}
	}
	static void bruteforce(int currslopeidx, long min, long max, ArrayList<pair> targetsremaining) {
		if(targetsremaining.size()==0) {
			ans = Math.min(ans, max-min);
			return;
		}
		int slope = slopes[currslopeidx];
		for(int i=0; i<targetsremaining.size(); i++) {
			
			pair currtarget = targetsremaining.get(i);
			
			if(slope>0 && currtarget.tr) continue;
			if(slope<0 && currtarget.br) continue;
					
			long yInt = calcYIntercept(slope, currtarget.x, currtarget.y);
			ArrayList<pair> newtargets = (ArrayList) targetsremaining.clone();
			newtargets.remove(i);
			bruteforce(currslopeidx+1, Math.min(min, yInt), Math.max(max, yInt), newtargets);
		}
	}
	static Long calcYIntercept(int m, int x, int y) {
		return (long)-1*m*x+y;
	}
	
	
	static class pair {
		
		int x, y;
		boolean br, tr;
		pair(int a, int b, boolean c, boolean d){
			this.x = a;
			this.y = b;
			this.br = c;
			this.tr = d;
		}
		public String toString() {
			return x+","+y;
		}
	}
	
}
