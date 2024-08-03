import java.util.*;
import java.io.*;

public class CF539825C {
	
	static long MOD = (long)1e9+7;
	static int MAX_N = 2000+1;
	static long inv = 500000004;
	static int t, n, m, k;
	static long dp[][];
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			dp = new long[n+1][n+1];
			for(int i=0; i<=n; i++) {
				dp[i][0] = 0;
				dp[i][i] = ((long)i*k)%MOD;
				for(int j=1; j<i; j++) {
					dp[i][j] = (((dp[i-1][j-1]+dp[i-1][j])%MOD)*inv)%MOD;
				}
			}
			
			System.out.println(dp[n][m]);
		}
	}
}
