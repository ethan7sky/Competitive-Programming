import java.util.*;
import java.io.*;

public class USACOCereal2 {
	
	static int n, m;
	static boolean v[];
	static BufferedReader in;
	static StringTokenizer st;
	static ArrayList<cow>[] adj;
	static ArrayList<Integer> ans;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[m+1];
		for(int i=1; i<=m; i++) adj[i] = new ArrayList<cow>();
		v = new boolean[m+1];
		ans = new ArrayList<Integer>();
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(new cow(i, a, b, a));
			adj[b].add(new cow(i, b, a, a));
		}
		
		for(int i=1; i<=m; i++) {
			if(v[i]) continue;
			dfs(i, null);
		}
		
		System.out.println(n-ans.size());
		for(int i: ans) System.out.println(i);
	}
	
	static void dfs(int curr, cow prevEdge) {
		System.out.println(curr+" "+prevEdge+"   "+v[curr]);
		if(v[curr]) return;
		v[curr] = true;
		for(cow next: adj[curr]) {
			if(prevEdge==null || next.id != prevEdge.id) {
				dfs(next.to, next);
			}
		}
	}
	
	
	
	static class cow {
		
		private int id, from, to, favorite;
		
		public cow(int a, int b, int c, int d) {
			this.id = a;
			this.from = b;
			this.to = c;
			this.favorite = d;
		}
		public String toString() {
			return id+" "+from+" "+to+" "+favorite;
		}
		
		
	}
	
}
