import java.util.*;
import java.io.*;

public class USACOFencePlanning {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m, minx, miny, maxx, maxy, ans;
	static int x[], y[];
	static ArrayList<Integer>[] a;
	static boolean v[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("fenceplan.in"));
		out = new PrintWriter("fenceplan.out");
		
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
		x = new int[n];
		y = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = new ArrayList<Integer>();
			st = new StringTokenizer(in.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int cow1 = Integer.parseInt(st.nextToken())-1;
			int cow2 = Integer.parseInt(st.nextToken())-1;
			
			a[cow1].add(cow2);
			a[cow2].add(cow1);
		}
		v = new boolean[n];
		ans = 400000001;
	}
	static void solve() {
		
		for(int i=0; i<n; i++) {
			
			if(!v[i]) {
				maxx = -1;
				maxy = -1;
				minx = 100000001;
				miny = 100000001;
				dfs(i);
				int perim = 2*(maxx-minx) + 2*(maxy-miny);
				ans = Math.min(ans, perim);
			}
		}
		out.println(ans);
	}
	static void dfs(int i) {
		
		v[i] = true;
		maxx = Math.max(maxx, x[i]);
		minx = Math.min(minx, x[i]);
		maxy = Math.max(maxy, y[i]);
		miny = Math.min(miny, y[i]);
		
		for(int n: a[i]) {
			
			if(v[n]) continue;
			dfs(n);
			
		}
	}
}
