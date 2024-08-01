import java.util.*;
import java.io.*;

public class Vacation {
	
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int a[][] = new int[n][3];
		for(int i=0; i<n; i++) {
			st =  new StringTokenizer(in.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
			a[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[n][3];
		dp[0][0] = a[0][0];
		dp[0][1] = a[0][1];
		dp[0][2] = a[0][2];
		for(int i=1; i<n; i++) {
			dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]) + a[i][0];
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + a[i][1];
			dp[i][2] = Math.max(dp[i-1][1], dp[i-1][0]) + a[i][2];
		}
		System.out.println(Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2])));
	}
}
