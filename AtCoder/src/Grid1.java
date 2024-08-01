import java.util.*;
import java.io.*;

public class Grid1 {
	
	static int h, w;
	static long dp[][];
	static char input[][];
	static long MOD = (long)1e9+7;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		dp = new long[h][w];
		input = new char[h][];
		for(int i=0; i<h; i++) {
			input[i] = in.readLine().toCharArray();
		}
		dp[0][0] = 1;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(input[i][j] == '#') continue;
				if(i>0) dp[i][j] += dp[i-1][j];
				if(j>0) dp[i][j] += dp[i][j-1];
				dp[i][j] %= MOD;
			}
		}
//		for(int i=0; i<h; i++) {
//			for(int j=0; j<w; j++) {
//				System.out.print(dp[i][j]);
//			}System.out.println();
//		}System.out.println();
		System.out.println(dp[h-1][w-1]);
		
	}
	
}
