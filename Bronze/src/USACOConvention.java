import java.util.*;
import java.io.*;

public class USACOConvention {

	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m, c, cows[], ans;
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("convention.in"));
		out = new PrintWriter("convention.out");
		//in = new Scanner(System.in);
		init();
		solve();
		
		in.close();
		out.close();
		
	}
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		cows = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) cows[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(cows);
		ans=-1;
	}
	static void solve() {
		
		int low = 0;
		int high = (int)Math.pow(10,9);
		int mid = (low+high)/2;
		while(low <= high) {
			if(check(mid)) {
				ans = mid;
				high = mid-1;
			}
			else {
				low = mid+1;
			}
			mid = (low+high)/2;
		}
		out.println(ans);
	}
	static boolean check(int mid) {
		
		int start = cows[0];
		int buscnt = 1;
		int cowcnt = 1;
		
		for(int i=1; i<n; i++) {
			if(cows[i]-start<=mid) cowcnt++;
			if(cows[i]-start>mid || cowcnt > c) {
				buscnt++;
				cowcnt = 1;
				start = cows[i];
			}
		}
		return buscnt<=m;
	}
}
