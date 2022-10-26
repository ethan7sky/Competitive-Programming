import java.io.*;
import java.util.*;

public class USACOAngryCows_silver {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, k, a[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("angry.in"));
		out = new PrintWriter("angry.out");
		
		init();
		solve();
		
		in.close();
		out.close();
		
	}
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(a);
	} 
	
	static void solve() {
		
		int low = 0; //first, we set a lowest possible value for the power
		int high = 500000000; //this is the highest possible value for the power
		int mid = 0, ans = 0;
		
		while(low <= high){
			
			mid = (low+high)/2;
			
			if(check(mid)) {
				ans = mid;
				high = mid-1;
			}
			else {
				
				low = mid+1;
			}
		}
		out.println(ans);
	}
	static boolean check(int m) {
		
		int cow = 1;
		int start = a[0];
		for(int i = 0; i <n; i++) {
			if(a[i]-start > m*2) {
				cow++;
				start = a[i];
			}
		}
		return cow <= k;
	}
}