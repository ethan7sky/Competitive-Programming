import java.util.*;
import java.io.*;

public class baekjoon1932 {
	
	static int N;
	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static final int MAX_N = 500;
	static int dp[][] = new int[MAX_N][MAX_N], a[][] = new int[MAX_N][MAX_N];
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=N-1; N-1-j <=i; j--) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], -Integer.MAX_VALUE);
		}
		
		dp[0][N-1] = a[0][N-1];
		for(int i=0; i<N-1; i++) {
			for(int j=N-1; N-1-j <= i; j--) {
				dp[i+1][j-1] = Math.max(dp[i+1][j-1], dp[i][j]+a[i+1][j-1]);
				dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]+a[i+1][j]);
			}
		}
		
		int ans=0;
		for(int i=0; i<N; i++) {
			ans = Math.max(ans, dp[N-1][i]);
		}
		
		System.out.println(ans);
		
	}
	
}
