import java.util.*;
import java.io.*;

public class USACOClosingTheFarm {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, m, cnt;
	static boolean v[], c[];
	static ArrayList<Integer>[] a;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("closing.in"));
		out = new PrintWriter("closing.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
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
		c = new boolean[n];
	}
	static void solve() throws IOException {
		
		for(int i=0; i<n; i++) {
			v = c.clone();
			int start=0;
			while(v[start]) start++;
			
			cnt=0;
			dfs(start);
			
			if(cnt==n-i) out.println("YES");
			else out.println("NO");
			
			c[Integer.parseInt(in.readLine())-1] = true;
		}
	}
	static void dfs(int i) {
		
		cnt++;
		v[i] = true;
		
		for(int n: a[i]) {
			if(!v[n]) dfs(n);
		}
	}
}
