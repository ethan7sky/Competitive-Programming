import java.util.*;
import java.io.*;

public class BaekJoon2805 {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, k, a[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
		
	}
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
	} 
	
	static void solve() {
		
		int low = 0; 
		int high = 1000000000; 
		int mid = 0, ans = 0;
		
		while(low <= high){
			
			mid = (low+high)/2;
			
			if(check(mid)) {
				ans = mid;
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		System.out.println(ans);
	}
	static boolean check(int m) {
		
		long total = 0;
		for(int i = 0; i <n; i++) {
			total += Math.max(0, a[i]-m);
		}
		return total >= k;
	}
}