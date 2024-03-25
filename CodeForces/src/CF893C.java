import java.util.*;
import java.io.*;

public class CF893C {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, min, ans, g[];
	static boolean v[];
	static ArrayList<Integer>[] a;

	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		g = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) g[i] = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[n];
		for(int i=0; i<n; i++) a[i] = new ArrayList<Integer>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			a[x].add(y);
			a[y].add(x);
		}
		
		v = new boolean[n];
		
	}
	static void solve() {
		
		for(int i=0; i<n; i++) {
			if(!v[i]) {
				min = Integer.MAX_VALUE;
				dfs(i);
				ans += min;
			}
		}
		System.out.println(ans);
	}
	static void dfs(int i) {
		
		v[i] = true;
		min = Math.min(min, g[i]);
		
		for(int n: a[i]) {
			if(!v[n]) dfs(n);
		}
	}
}
