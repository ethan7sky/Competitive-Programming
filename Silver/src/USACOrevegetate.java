import java.util.*;
import java.io.*;

public class USACOrevegetate {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, m, p[];
	static ArrayList<Integer>[] s, d;
	static boolean no;
	
	public static void main(String[] args) throws IOException {
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("revegetate.in"));
		out = new PrintWriter("revegetate.out");
		init();
		solve();
		
		in.close();
		out.close();
	}
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		s = new ArrayList[n+1];
		d = new ArrayList[n+1];
		Arrays.setAll(s, i->new ArrayList<>());
		Arrays.setAll(d, i->new ArrayList<>());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			char c = st.nextToken().charAt(0);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(c=='S') {
				s[x].add(y);
				s[y].add(x);
			}
			else {
				d[x].add(y);
				d[y].add(x);
			}
		}
		p = new int[n+1];
	}
	static void solve() {
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			if(p[i]==0) {
				dfs(i, 1);
				cnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(no) sb.append(0);
		else {
			sb.append(1);
			for(int i=0; i<cnt; i++) {
				sb.append(0);
			}
		}
		out.println(sb);
	}
	static void dfs(int curr, int seed) {
		p[curr] = seed;
		for(int next:s[curr]) {
			if(p[next]==seed*-1) {
				no=true; return;
			}
			if(p[next]==0) dfs(next,seed);
			
		}
		for(int next:d[curr]) {
			if(p[next]==seed) {
				no = true;
				return;
			}
			if(p[next]==0) dfs(next, seed*-1);
		}
	}
}
