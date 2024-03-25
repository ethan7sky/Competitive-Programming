import java.util.*;
import java.io.*;

public class USACOSwitchingOnTheLights {
	
	static int[] cx = {-1, 1, 0, 0};
	static int[] cy = {0, 0, -1, 1};
	static int n, m;
	static boolean a[][], v[][];
	static ArrayList<pair>[][] switches;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		
		in = new BufferedReader(new FileReader("lightson.in"));
		out = new PrintWriter("lightson.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new boolean[n][n];
		v = new boolean[n][n];
		switches = new ArrayList[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				switches[i][j] = new ArrayList<pair>();
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			switches[Integer.parseInt(st.nextToken())-1]
					[Integer.parseInt(st.nextToken())-1]
							.add(new pair(Integer.parseInt(st.nextToken())-1,
							Integer.parseInt(st.nextToken())-1));
		}
	}
	static void solve() {
		
		dfs(0,0);
		
		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) if(a[i][j]) cnt++;
		}
		out.println(cnt);
		
	}
	static void dfs(int x, int y) {
		
		if(x<0 || x>=n || y<0 || y>=n || v[x][y]) return;
		
		a[x][y] = true;
		v[x][y] = true;
		for(pair p: switches[x][y]) {
			a[p.x][p.y] = true; 
			check(p.x, p.y);
		}
		
		for(int i=0; i<4; i++) {
			int nx = x+cx[i];
			int ny = y+cy[i];
			if(nx<0 || nx >=n || ny<0 || ny>=n || !a[nx][ny]) continue;
			dfs(nx, ny);
		}
	}
	static void check(int x, int y) {
		
		boolean works = false;
		for(int i=0; i<4; i++) {
			int nx = x+cx[i];
			int ny = y+cy[i];
			if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
			if(v[nx][ny]) works = true;
		}
		if(works) dfs(x, y);
	}
	
	static class pair {
		
		int x, y;
		pair(int a, int b) {
			x = a;
			y = b;
		}
		
		
	}
}