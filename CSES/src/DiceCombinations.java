import java.util.*;
import java.io.*;

public class DiceCombinations {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] dp = new int[n+1];
		dp[0] = 1;
		
		int mod = (int)Math.pow(10, 9)+7;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=6 && i-j>=0; j++) {
				dp[i] += dp[i-j] ;
				dp[i] %= mod;
			}
		}
		System.out.println(dp[n]);
	}
	
}
