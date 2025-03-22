import java.util.*;
import java.io.*;

public class CF280C {
	
	static double ans = 0.0;
	static ArrayList<Integer> adj[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) adj[i] = new ArrayList<Integer>();
		
		for(int i=1; i<n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		
		dfs(-1, 1, 1);
		
		System.out.println(ans);
	}
	static void dfs(int p, int c, int d) {
		ans += (double)1.0/d;
		for(int i: adj[c]) {
			if(i==p) continue;
			dfs(c, i, d+1);
		}
	}
}
