package CS401H;
import java.util.*;
import java.io.*;

public class CS401H_GameRoutes {
	
	static int MOD = (int)1e9+7;
	static int MAX_N = (int)1e5+1, MAX_M = 2*(int)1e5+1;
	static int n, m;
	static Queue<Integer> nextToAdd;
	static ArrayList<Integer> adj[];
	static int dp[] = new int[MAX_N];
	static int p[] = new int[MAX_N];
	
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) adj[i] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			p[b]++;
		}
		
		nextToAdd = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			if(p[i]==0) {
				nextToAdd.add(i);
			}
		}
		dp[1] = 1;
		
		while(!nextToAdd.isEmpty()) {
			int curr = nextToAdd.poll();
			for(int c: adj[curr]) {
				p[c]--;
				if(p[c]==0) nextToAdd.add(c);
				dp[c] = (dp[c]+dp[curr])%MOD;
			}
		}
		
		
		System.out.println(dp[n]);
	}
	
	
}
