import java.util.*;
import java.io.*;

public class CF539825E {

	static long MOD = 998244353;
	static int MAX_N = (int)1e5+1;
	static long[] factorial, inverseFactorial;
	
	static BufferedReader in;
	static StringBuilder sb;
	static int t, n;
	static long[] ans;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		precompute();
		sb = new StringBuilder(); 
		
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			n = Integer.parseInt(in.readLine());
			
			ans = new long[n];
			for(int i=2; i<=(n-1)/2+1; i++) {
				ans[i-1] = (choose(n-(i+1),i-2)*factorial[2*(i-1)]%MOD)*factorial[n-2*(i-1)+1]%MOD;
			}
			for(long i: ans) sb.append(i).append(" ");
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static long choose(int n, int k) {
		return (factorial[n]*inverseFactorial[k]%MOD)*inverseFactorial[n-k]%MOD;
	}
	static void precompute() {
		factorial = new long[MAX_N];
		inverseFactorial = new long[MAX_N];
		factorial[0] = 1;
		inverseFactorial[0] = 1;
		for(int i=1; i<MAX_N; i++) {
			factorial[i] = factorial[i-1]*i%MOD;
			inverseFactorial[i] = modInverse(factorial[i])%MOD;
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
