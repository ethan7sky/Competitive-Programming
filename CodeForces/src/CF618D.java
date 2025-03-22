import java.util.*;
import java.io.*;

public class CF618D {
	
	static BufferedReader in;
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	static long cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		
		if(x>y) {
			int[] deg = new int[n];
			for(int i=1; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				deg[Integer.parseInt(st.nextToken())-1]++;
				deg[Integer.parseInt(st.nextToken())-1]++;
			}
			boolean isStar = false;
			for(int i=0; i<n; i++) {
				if(deg[i] == n-1) isStar = true;
			}
			if(isStar) {
				System.out.println(y*(n-2)+x);
			}else {
				System.out.println(y*(n-1));
			}
		}
		else {
			adj = new ArrayList[n];
			for(int i=0; i<n; i++) adj[i] = new ArrayList<Integer>();
			for(int i=1; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken())-1; 
				int b = Integer.parseInt(st.nextToken())-1;
				adj[a].add(b);
				adj[b].add(a);
			}
			cnt=0;
			dfs(0, -1);
			System.out.println(y*(n-1-cnt)+x*cnt);
		}
	}
	
	static boolean dfs(int node, int parent) {
		int rem=2;
		for(int child : adj[node]) {
			if(child == parent) continue;
			boolean available = dfs(child, node);
			if(available && rem>0) {
				cnt++;
				rem--;
			}
		}
		return rem>0;
	}
	
}
