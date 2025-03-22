import java.util.*;
import java.io.*;

public class baekjoon11053 {
	
	static int N;
	static StringTokenizer st;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static final int MAX_N = 1000;
	static int dp[] = new int[MAX_N], a[] = new int[MAX_N];
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(dp, 1);
		int ans=1;
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(a[j] < a[i]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
		
	}
	
}
