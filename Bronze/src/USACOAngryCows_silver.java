import java.util.*;
import java.io.*;

public class USACOAngryCows_silver {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st; 
	static int n, k, a[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("angry.in"));
		out = new PrintWriter("angry.out");
		//in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
		out.close();
		
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(a);
	}
	static void solve() {
		
		int low = 0;
		int high = 500000000;
		int mid = 0, ans = 0;
		
		while(low <= high) {
			
			mid = (low+high)/2;
			if(check(mid)) {
				ans = mid;
				high = mid-1;
			}
			else low = mid+1;
		}
		out.println(ans);
	}
	static boolean check(int r) {
		
		int cowcnt = 1;
		int start = a[0];
		for(int i=0; i<n; i++) {
			if(a[i]-start>r*2) {
				cowcnt++;
				start = a[i];
			}
		}
		return cowcnt <= k;
	}
	
}