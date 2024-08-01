import java.util.*;
import java.io.*;

public class CF539597I {
	
	static int t, n;
	static int MAX_N = (int)1e6+1 , MOD = (int)1e9+7;
	static long[] ans = new long[MAX_N];
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		precompute();
		
		t = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		while(t-->0) {
			int n = Integer.parseInt(in.readLine());
			sb.append(ans[n]).append("\n");
		}
		System.out.print(sb);
		
	}
		
	
	static void precompute() {
		
		ans[1] = 1;
		
		for(int i=2; i<MAX_N; i++) {
			ans[i] = (ans[i-1] + (i-2)*modInverse((long)i*(i-1))%MOD)%MOD;
		}		
	}
	
	static long modInverse(long a) {
		long m = MOD;
		long y = 0, x = 1;
		
		long q, t;
		while(a>1) {
			q = a/m;
			t = m;
			m = a%m;
			a=t;
			t=y;
			
			y = x-q*y;
			x=t;
		}
		if(x<0) x += MOD;
		
		return x;
	}
}
