import java.util.*;
import java.io.*;

public class submit {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, ans;
	static int M = 200100;
	static int[] head = new int[M];
	static int[] next = new int[M];
	static int[] to = new int[M];
	static int[] res = new int[M];
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=2; i<=n; i++) {
			addEdge(Integer.parseInt(st.nextToken()), i, i);
		}
		dfs(1);
		sb = new StringBuilder();
		for(int i=1; i<n; i++) {
			sb.append(res[i]-1).append(" ");
		}sb.append(res[n]-1);
		System.out.println(sb);
	}
	
	static void dfs(int node) {
		res[node] = 1;
		for(int i=head[node]; i!=0; i=next[i]) {
			dfs(to[i]);
			res[node] += res[to[i]];
		}
	}
	 
	static void addEdge(int u, int v, int id) {
		next[id] = head[u];
		head[u] = id;
		to[id] = v;
	}
	
}
