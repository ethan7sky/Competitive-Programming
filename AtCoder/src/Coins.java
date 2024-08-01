import java.util.*;
import java.io.*;

public class Coins {
	
	static int n;
	static double p[];
	static double allTails;
	static double dp[];
	static double fraction;
	static double ans;
	
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		p = new double[n];
		dp = new double[n+1];
		
		st = new StringTokenizer(in.readLine());
		allTails=1.0;
		for(int i=0; i<n; i++) {
			p[i] = Double.parseDouble(st.nextToken());
			allTails*=(1.0-p[i]);
		}
		dp[0] = allTails;
		fraction = 1.0/n;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<n; j++) {
				dp[i] += dp[i-1]/(1.0-p[j])*p[j]*fraction;
			}
		}
		ans = 0.0;
		for(int i=n/2+1; i<=n; i++) {
			ans += dp[i];
		}
		System.out.println(ans);
		
		
	}
	
	
}
