import java.util.*;
import java.io.*;

public class CF539825G {
	
	static int MOD = 998244353;
	static int MAX_N = (int)1e6+1;
	static long inverse[] = new long[MAX_N];
	static int t, n, xorCnt;
	static String a, b;
	static coefficients[] dp;
	static BufferedReader in;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<MAX_N; i++) {
			inverse[i] = modInverse(i);
		}
		
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			n = Integer.parseInt(in.readLine());
			
			dp = new coefficients[n+1];
			
			dp[n] = new coefficients(1, 0);
			dp[n-1] = new coefficients(1, -1);
			
			for(int k=n-2; k>=0; k--) {
				long a = dp[k+2].xterm;
				long b = dp[k+2].cterm;
				long c = dp[k+1].xterm;
				long d = dp[k+1].cterm;
				long xcoef = (long)n*c%MOD+MOD-(long)(n-k-1)*a%MOD;
				xcoef %= MOD;
				long constant = (long)n*d%MOD+MOD-(long)(n-k-1)*b%MOD;
				constant -= n;
				constant %= MOD;
				xcoef = (xcoef*inverse[k+1])%MOD;
				constant = (constant*inverse[k+1])%MOD;
				dp[k] = new coefficients(xcoef, constant);
			}
			
			//System.out.println(Arrays.toString(dp));
			
			
			long x = ((MOD-dp[0].cterm)*modInverse(dp[0].xterm))%MOD;
			
			a = in.readLine();
			b = in.readLine();
			xorCnt=0;
			for(int i=0; i<n; i++) {
				if(a.charAt(i)!=b.charAt(i)) xorCnt++;
			}
			//System.out.println(xorCnt);
			
			long ans = ((dp[xorCnt].xterm*x)+dp[xorCnt].cterm)%MOD;
			//while(ans<0) ans += MOD;
			System.out.println(ans);
			
		}
	}
	
	static class coefficients {
		long xterm, cterm;
		public coefficients(long a, long b) {
			this.xterm = a;
			this.cterm = b;
		}
		public String toString() {
			return xterm+" "+cterm;
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
