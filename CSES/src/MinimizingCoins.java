import java.util.*;
import java.io.*;

public class MinimizingCoins {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, target;
	static int[] coins;
	static int[] dp;
	static int MAX = (int)10e6+2;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		coins = new int[n];
		dp = new int[target+1];	
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=target; i++) dp[i] = MAX;
		dp[0] = 0;
		
		for(int i=0; i<n; i++) {
			for(int sum=0; sum<=target; sum++) {
				if(sum-coins[i]>=0) {
					dp[sum] = Math.min(dp[sum], dp[sum-coins[i]]+1);
				}
			}
		}
		if(dp[target]==MAX) System.out.println(-1);
		else System.out.println(dp[target]);
		
		
	}
}
