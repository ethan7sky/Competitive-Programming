import java.util.*;
import java.io.*;

public class Coins2 {
	
	static int n;
	static int MAX_N = 3000;
	static double dp[][] = new double[MAX_N][MAX_N];
	static double p[] = new double[MAX_N];
	static double ans;
	
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++) {
			p[i] = Double.parseDouble(st.nextToken());
		}
		
		dp[0][0] = 1.0;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0) {
					dp[i][j] = dp[i-1][j]*(1.0-p[i]);
				}
				else {
					dp[i][j] = dp[i-1][j-1]*p[i] + dp[i-1][j]*(1.0-p[i]);
				}
			}
		}
		
		ans=0.0;
		for(int i=n/2+1; i<=n; i++) {
			ans += dp[n][i];
		}
		System.out.println(ans);
	}
}
