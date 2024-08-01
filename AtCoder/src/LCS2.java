import java.util.*;
import java.io.*;

public class LCS2 {

	static String s, t;
	static int sLen, tLen;
	static int[][] dp;
	static String[][] ans;
	static int ansLen;
	
	static Scanner in;
	public static void main(String[] args) throws IOException {
		in = new Scanner(System.in);
		s = in.next();
		t = in.next();
		sLen = s.length();
		tLen = t.length();
		dp = new int[sLen+1][tLen+1];
		for(int i=0; i<=sLen; i++) {
			for(int j=0; j<=tLen; j++) {
				if(i==0 || j==0) dp[i][j] = 0;
				else if(s.charAt(i-1)==t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		int idx = dp[sLen][tLen];
		
		String lcs = "";
		int i=sLen;
		int j=tLen;
		
		while(i>0 && j>0) {
			if(s.charAt(i-1) == t.charAt(j-1)) {
				lcs = s.charAt(i-1)+lcs;
				i--;
				j--;
			}
			else if(dp[i-1][j] > dp[i][j-1]) i--;
			else j--;
		}
		
		System.out.println(lcs);
	}
//	static int lcs(int m, int n, String x) {
//		if(m==0 || n==0) return 0;
//		if(dp[m][n] != -1) return dp[m][n];
//		if(s.charAt(m-1) == t.charAt(n-1)) {
//			x = s.charAt(m-1)+x;
//			ans[m][n] = x;
//			dp[m][n] = 1 + lcs(m-1, n-1, x);
//			return dp[m][n];
//		}
//		int a = lcs(m-1, n, x);
//		int b = lcs(m, n-1, x);
//		if(a>b) {
//			dp[m][n] = a;
//			ans[m][n] = x;
//		}
//		else {
//			dp[m][n] = b;
//			ans[m][n] = x;
//		}
//		dp[m][n] = Math.max(lcs(m-1, n, x), lcs(m, n-1, x));
//		ans[m][n] = x;
//		return dp[m][n];
//	}
}
