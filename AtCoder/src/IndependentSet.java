import java.util.*;
import java.io.*;

public class IndependentSet {
	
	static int n;
	static final int M = 2*(int)10e5+1;
	static ArrayList<Integer>[] adj;
	static long[][] dp = new long[M][2];
	static BufferedReader in;
	static StringTokenizer st;
	static int MOD = (int)1e9+7;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		if(n==1) {
			System.out.println(2);
			return;
		}
		
		adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		dfs(1, -1);
		
//		for(int i=1; i<=n; i++) {
//			System.out.println(i+"   "+dp[i][0]+ " "+dp[i][1]);
//		}
		
		System.out.println((dp[1][0]+dp[1][1])%MOD);
	}
	
	static void dfs(int node, int parent) {
		dp[node][0] = 1;
		dp[node][1] = 1;
		for(int v: adj[node]) {
			if(v!=parent) {
				dfs(v, node);
				dp[node][0] *= (long)dp[v][0]+dp[v][1];
				dp[node][1] *= (long)dp[v][0];
				dp[node][1] %= MOD;
				dp[node][0] %= MOD;
			}
		}
	}
}
