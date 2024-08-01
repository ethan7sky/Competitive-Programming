import java.util.*;
import java.io.*;

public class Deque {
	
	static int n, a[];
	static long dp[][];
	static long sum;
	
	//if n is odd, taro goes last. if n is even, jiro goes last
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			sum += a[i];
		}
		dp = new long[n][n];
		for(int len=0; len<n; len++) {
			for(int l=0; l+len<n; l++) {
				int r = l+len;
				if((n-len)%2==1) {
					//taro's turn
					if(len==0) dp[l][r] = a[l];
					else {
						dp[l][r] = Math.max(dp[l+1][r]+a[l], dp[l][r-1]+a[r]);
					}
				}
				else {
					//jiro's turn
					if(len==0) dp[l][r] = 0;
					else {
						dp[l][r] = Math.min(dp[l+1][r], dp[l][r-1]);
					}
				}
			}
		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(dp[i][j]+" ");
//			}System.out.println();
//		}System.out.println();
//		System.out.println(dp[0][n-1]);
		System.out.println(dp[0][n-1] - (sum-dp[0][n-1]));
	}
	
}
