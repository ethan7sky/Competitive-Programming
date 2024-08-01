package CS401H;
import java.util.*;
import java.io.*;

public class CS401H_TreeMatching {
	
	static int n;
	static final int M = 2*(int)10e5+1;
	static ArrayList<Integer>[] adj;
	static int[][] dp = new int[M][2];
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
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
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
	static void dfs(int node, int parent) {
		dp[node][0] = 0;
		dp[node][1] = -M;
		for(int v: adj[node]) {
			if(v!=parent) {
				dfs(v, node);
				dp[node][0] += Math.max(dp[v][0], dp[v][1]);
				int temp = Math.min(dp[v][0] - dp[v][1], 0);
				dp[node][1] = Math.max(dp[node][1], temp);
			}
		}
		dp[node][1] += dp[node][0]+1;
	}
}
