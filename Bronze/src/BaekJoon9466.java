import java.util.*;
import java.io.*;

public class BaekJoon9466 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int t, n, a[], ans;
	static boolean v[];
	static HashSet<Integer> visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			init();
			solve();
		}
		System.out.print(sb);
	}
	static void init() throws IOException {
		
		
		n = Integer.parseInt(in.readLine());
		v = new boolean[n];
		a = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken())-1;
		
		ans=0;
	}
	static void solve() {
		
		for(int i=0; i<n; i++) {
			if(!v[i]) {
				visited = new HashSet<Integer>();
				dfs(i, i);
			}
		}
		for(boolean i: v) if(!i) ans++;
		sb.append(ans).append("\n");
	}
	static void dfs(int start, int curr) {
		
		if(visited.contains(a[curr]) || v[curr]) return;
		visited.add(a[curr]);
		
		if(a[curr] == start) {
			for(int i: visited) v[i] = true;
		}
		else dfs(start, a[curr]);
	}
}
