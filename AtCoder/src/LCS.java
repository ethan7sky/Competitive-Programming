import java.util.*;
import java.io.*;

public class LCS {

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
		for(int i=0; i<sLen+1; i++) {
			Arrays.fill(dp[i], -1);
		}
		ans = new String[sLen+1][tLen+1];
		
		int ansLen = lcs(sLen, tLen, "");
		System.out.println(ansLen);
		
		System.out.println(Arrays.deepToString(ans));
		
		for(int i=0; i<=sLen; i++) {
			for(int j=0; j<=tLen; j++) {
				if(ans[i][j]==null) continue;
				if(ans[i][j].length()==ansLen) {
					System.out.println(ans[i][j]);
					return;
				}
			}
		}
		System.out.println("");
	}
	static int lcs(int m, int n, String x) {
		if(m==0 || n==0) return 0;
		if(dp[m][n] != -1) return dp[m][n];
		if(s.charAt(m-1) == t.charAt(n-1)) {
			x = s.charAt(m-1)+x;
			ans[m][n] = x;
			dp[m][n] = 1 + lcs(m-1, n-1, x);
			return dp[m][n];
		}
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
		dp[m][n] = Math.max(lcs(m-1, n, x), lcs(m, n-1, x));
		ans[m][n] = x;
		return dp[m][n];
	}
}
