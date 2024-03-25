import java.util.*;
import java.io.*;

public class BaekJoon1260 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m, v;
	static TreeSet<Integer>[] a;
	static Queue<Integer> q;
	static boolean[] visited; 
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		System.out.println(sb);
	}
	static void solve() {
		
		visited = new boolean[n];
		dfs(v);
		sb.append("\n");
		visited = new boolean[n];
		bfs(v);
		
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken())-1;
		
		a = new TreeSet[m];
		for(int i=0; i<m; i++) {
			a[i] = new TreeSet<Integer>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			a[x].add(y);
			a[y].add(x);
		}
		q = new LinkedList<Integer>();
		
		sb = new StringBuilder();
	}
	static void dfs(int i) {
		
		visited[i] = true;
		sb.append(i+1).append(" ");
		
		for(int j: a[i]) {	
			if(!visited[j]) dfs(j);
		}
	}
	static void bfs(int i) {
		
		q.add(i);
		visited[i] = true;
		sb.append(i+1).append(" ");
		
		while(!q.isEmpty()) {
			
			int n = q.poll();
			for(int j: a[n]) {	
				if(!visited[j]) {
					sb.append(j+1).append(" ");;
					q.add(j);
					visited[j] = true;
				}
			}
		}
	}
	
}
