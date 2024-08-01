import java.util.*;
import java.io.*;

public class Knapsack2 {
	
	static int n, w;
	static int weights[], vals[];
	static long[] dp;
	static long M = (long)1e18;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		int maxVal = 0;
		weights = new int[n];
		vals = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			vals[i] = Integer.parseInt(st.nextToken());
			maxVal = Math.max(maxVal, vals[i]);
		}
		
		int max = maxVal*n;
		
		dp = new long[max+1];
		
		int ans = 0;
		
		Arrays.fill(dp, M);
		dp[0] = 0;
		for(int j=0; j<n; j++) {
			int val = vals[j];
			for(int i=max; i>=1; i--) {
				if(i-val<0) continue;
				if(dp[i-val]+weights[j]>w) continue;
				dp[i] = Math.min(dp[i], dp[i-vals[j]]+weights[j]);
			}
		}
		for(int i=0; i<=max; i++) {
			if(dp[i]!=M) ans=i;
		}
		
		System.out.println(ans);
		
		
		
		
	}
}
