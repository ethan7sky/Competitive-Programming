import java.util.*;
import java.io.*;

public class USACOSocialDistancing_silver {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m;
	static long low, high, mid, ans;
	static Pair[] intervals;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("socdist.in"));
		out = new PrintWriter("socdist.out");
		//in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		
		in.close();
		out.close();
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		intervals = new Pair[m];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			intervals[i] = new Pair(Long.parseLong(st.nextToken()),
					Long.parseLong(st.nextToken()));
		}
		Arrays.sort(intervals);
	}
	static void solve() {
		
		low = 1;
		high = 1000000000000000000L; //10^18
		
		while(low <= high) {
			mid = (low+high)/2;
			if(check(mid)) {
				ans = mid;
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		out.println(ans);
	}
	
	static boolean check(long dist) {
		
		long cowcnt = 0;
		long curridx = Long.MIN_VALUE;
		
		for(int i=0; i<m; i++) {
			//for each of the intervals
			
			Pair range = intervals[i];
			
			long s = range.s;
			long e = range.e;
			
			while(true) {
				long tempidx = Math.max(curridx+dist, s);
				if(tempidx > e) break;
				curridx = tempidx;
				cowcnt++;				
			}
		}
		
		return cowcnt >= n;		
	}
	
	static class Pair implements Comparable<Pair> {
		
		long s, e;
		Pair(long a, long b){
			s = a; e = b;
		}
		public String toString() {
			return s+" "+e;
		}
		@Override
		public int compareTo(USACOSocialDistancing_silver.Pair o) {
			if(this.s<o.s)return -1;
			else return 1;
		}		
	}
}
