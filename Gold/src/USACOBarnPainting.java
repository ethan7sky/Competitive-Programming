import java.util.*;
import java.io.*;

public class USACOBarnPainting {
	
	static int M = (int)1e5+1;
	static int MOD = (int)1e9+7;
	static int n, k;
	static ArrayList<Integer> adj[];
	static int[][] dp = new int[M][4];
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static long ans = 0;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("barnpainting.in"));
		out = new PrintWriter("barnpainting.out");
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) adj[i] = new ArrayList<Integer>();
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			int barn = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			dp[barn][0] = color;
		}
		dfs(1, -1);
		for(int i=1; i<=3; i++) {
			ans += dp[1][i];
			ans %= MOD;
		}
		out.println(ans);
		
		in.close();
		out.close();
		
	}
	static void dfs(int node, int parent) {
		//R = idx 1, G = idx 2, B = idx 3
		long R = 1;
		long G = 1;
		long B = 1;
		
		for(int c: adj[node]) {
			if(c!=parent) {
				dfs(c, node);
				R *= dp[c][2]+dp[c][3];
				R %= MOD;
				G *= dp[c][1] + dp[c][3];
				G %= MOD;
				B *= dp[c][1] + dp[c][2];
				B %= MOD;
			}
		}
		if(dp[node][0]!=0) {
			if(dp[node][0]==1) {
				dp[node][1] = (int)R;
				dp[node][2] = 0;
				dp[node][3] = 0;
			}
			else if(dp[node][0]==2) {
				dp[node][2] = (int)G;
				dp[node][1] = 0;
				dp[node][3] = 0;
			}
			else {
				dp[node][3] = (int)B;
				dp[node][1] = 0;
				dp[node][2] = 0;
			}
		}
		else {
			dp[node][1] = (int)R;
			dp[node][2] = (int)G;
			dp[node][3] = (int)B;
		}
	}
}
