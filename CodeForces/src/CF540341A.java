import java.util.*;
import java.io.*;

public class CF540341A {
	
	static int t, n, k;
	static long h[];
	static int MOD = (int)1e9+7;
	static int MAX_K = 2*(int)1e5+1;
	static int MAX_H;
	static long[] INV = new long[MAX_K];
	static long dp[];
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		precompute();
		sb = new StringBuilder();
		
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			st = new StringTokenizer(in.readLine());
			
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			h = new long[n];
			MAX_H = 0;
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<n; i++) {
				h[i] = Long.parseLong(st.nextToken());
				MAX_H = Math.max(MAX_H, (int)h[i]);
			}
			
			dp = new long[MAX_H+1];
			
			for(int i=1; i<=MAX_H; i++) {
				long ans=0;
				int sqrt = (int)Math.sqrt(i);
				for(int j=2; j<=sqrt; j++) {
					ans += dp[i/j];
					ans %= MOD;
				}
				for(int x=1; x<=sqrt; x++) {
					ans += f(i, x)*dp[x];
					ans %= MOD;
				}
				ans+=k;
				ans *= INV[k-1];
				ans %= MOD;
				dp[i] = ans;
			}
			
			long sum=0;
			for(long i: h) {
				sum += dp[(int)i];
			}
			sb.append(sum).append("\n");
		}
		System.out.print(sb);
	}
	static long f(int i, int x) {
		if(Math.ceil(i/(x+1))>k) return 0;
		return Math.min(k,(long)(i/x))-(long)Math.ceil(i/(x+1))+1;
	}
	
	static void precompute() {
		for(int i=1; i<MAX_K; i++) {
			INV[i] = modInverse(i)%MOD;
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
