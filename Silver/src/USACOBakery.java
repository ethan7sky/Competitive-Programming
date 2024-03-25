import java.util.*;
import java.io.*;

public class USACOBakery {
	
	static int t, n;
	static long tc, tm, a[], b[], c[], ans;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			init();
			solve();
		}
		System.out.print(sb);
	}
	static void init() throws IOException {
		
		in.readLine();
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		tc = Long.parseLong(st.nextToken());
		tm = Long.parseLong(st.nextToken());
		
		a = new long[n];
		b = new long[n];
		c = new long[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = Long.parseLong(st.nextToken());
			b[i] = Long.parseLong(st.nextToken());
			c[i] = Long.parseLong(st.nextToken());
		}
	}
	static void solve() {
		
		//binary search
		
		long low = 0;
		long high = tc;
		long mid;
		
		while(low<=high) {
			
			mid = (low+high)/2;
			
			if(check(mid)) {
				high = mid-1;
			}
			else low = mid+1;
		}
		sb.append(ans).append("\n");
	}
	static boolean check(long cookiemooney) {
		
		long maxmuffinmoney = 0;
		
		for(int i=0; i<n; i++) {
			
			long remaining = c[i]-cookiemooney;
			long muffinmoney = tm - remaining/b[i];
			if(muffinmoney>0) maxmuffinmoney = Math.max(maxmuffinmoney, muffinmoney);			
		}
		
		if(maxmuffinmoney+cookiemooney < ans) {
			ans = maxmuffinmoney+cookiemooney;
			return true;
		}
		return false;
	}
}
