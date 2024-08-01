import java.util.*;
import java.io.*;

public class Slimes {
	
	static int n, a[];
	static long dp[][][];
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
		dp = new long[n][n][2];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dp[i][j][1] = Long.MAX_VALUE;
			}
		}
		for(int len=0; len<n; len++) {
			for(int l=0; l+len<n; l++) {
				if(len==0) {
					dp[l][l][0] = a[l];
					dp[l][l][1] = 0;
				}
				else {
					int r = l+len;
					
					
					for(int mid=l; mid<r; mid++) {
						long totalcost = dp[l][mid][0]+dp[mid+1][r][0]+dp[l][mid][1]+dp[mid+1][r][1];
						if(totalcost < dp[l][r][1]) {
							dp[l][r][0] = dp[l][mid][0]+dp[mid+1][r][0];
							dp[l][r][1] = totalcost;
						}
					}
				}
				//print();
			}
		}
		
		System.out.println(dp[0][n-1][1]);
	}
	static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(dp[i][j][0]==Long.MAX_VALUE? -1+" ":dp[i][j][0]+" ");
			}System.out.println();
		}System.out.println();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(dp[i][j][1]==Long.MAX_VALUE? -1+" ":dp[i][j][1]+" ");
			}System.out.println();
		}System.out.println();
		System.out.println();
	}
}
