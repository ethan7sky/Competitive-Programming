import java.util.*;
import java.io.*;
public class Knapsack1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int weights[] = new int[n];
		int vals[] = new int[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			vals[i] = Integer.parseInt(st.nextToken());
		}
		
		long[][] dp = new long[n+1][w+1];
		
		for(int i=0; i<=n; i++) {
			dp[i][0] = 0;
			dp[0][i] = 0;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=w; j++) {
				long a = dp[i-1][j];
				long b = 0;
				int weight = weights[i-1];
				if(j>=weight) {
					b = (long)vals[i-1];
					int newWeight = j-weight;
					b += (long)dp[i-1][newWeight];
				}
				dp[i][j] = Math.max(a, b);
			}
		}
		System.out.println(dp[n][w]);
	}
}
