import java.util.*;
import java.io.*;

public class CF538135A {
	
	static int[][] minDp, maxDp;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n, m;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		while(t-->0) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			minDp = new int[n][m];
			maxDp = new int[n][m];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<m; j++) {
					minDp[i][j] = Integer.parseInt(st.nextToken());
					maxDp[i][j] = minDp[i][j];
					minDp[i][j] = min(i, j);
					maxDp[i][j] = max(i, j);
				}
			}

//			for(int i=0; i<n; i++) {
//				for(int j=0; j<n; j++) System.out.print(minDp[i][j]);
//				System.out.println();
//			}System.out.println();
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<n; j++) System.out.print(maxDp[i][j]);
//				System.out.println();
//			}System.out.println();
//			
//			
//			System.out.println(minDp[n-1][m-1]);
//			System.out.println(maxDp[n-1][m-1]);
			
			if(minDp[n-1][m-1] <= 0 && minDp[n-1][m-1] % 2 == 0
					&& maxDp[n-1][m-1] >= 0 & maxDp[n-1][m-1]%2==0){
				sb.append("YES").append("\n");
			}
			else sb.append("NO").append("\n");
		}
		System.out.print(sb);
	}
	static int max(int a, int b) {
		int ans = Integer.MIN_VALUE;
		if(a-1>=0) {
			ans = Math.max(ans, maxDp[a-1][b]+maxDp[a][b]);
		}
		if(b-1>=0) {
			ans = Math.max(ans, maxDp[a][b-1]+maxDp[a][b]);
		}
		if(ans == Integer.MIN_VALUE) {
			ans = maxDp[a][b];
		}
		return ans;
	}
	static int min(int a, int b) {
		int ans = Integer.MAX_VALUE;
		if(a-1>=0) {
			ans = Math.min(ans, minDp[a-1][b]+minDp[a][b]);
		}
		if(b-1>=0) {
			ans = Math.min(ans, minDp[a][b-1]+minDp[a][b]);
		}
		if(ans == Integer.MAX_VALUE) {
			ans = minDp[a][b];
		}
		return ans;
	}
	
}
