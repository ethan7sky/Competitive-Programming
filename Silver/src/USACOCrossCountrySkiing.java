import java.util.*;
import java.io.*;

public class USACOCrossCountrySkiing {
	
	static int m, n, min, max, low, mid, high, a[][], ans;
	static int x1, y1;
	static ArrayList<coordinates> waypoints;
	static boolean v[][];
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("ccski.in"));
		out = new PrintWriter("ccski.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		a = new int[m][n];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, a[i][j]);
				max = Math.max(max, a[i][j]);
			}
		}
		waypoints = new ArrayList<coordinates>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				if(st.nextToken().equals("1")) waypoints.add(new coordinates(i, j));
			}
		}
		x1 = waypoints.get(0).x;
		y1 = waypoints.get(0).y;
		
		
	}
	static void solve() {
		
		low = 0;
		high = max-min;
		
		while(low<=high) {
			mid = (low+high)/2;
			
			if(ski(mid)) {
				ans = mid;
				high = mid-1;
			}
			else low = mid+1;
		}
		
		out.println(ans);
	}
	
	static boolean ski(int elevation) {
		
		v = new boolean[m][n];
		floodfill(x1, y1, elevation, a[x1][y1]);
		
		for(coordinates c: waypoints) {
			if(!v[c.x][c.y]) return false;
		}
		return true;
	}
	
	static void floodfill(int x, int y, int elevation, int prev) {
		
		if(x<0 || y<0 || x>=m || y>=n) return;
		if(v[x][y]) return;
		if(Math.abs(a[x][y]-prev)>elevation) return;
		
		v[x][y] = true;

		floodfill(x+1, y, elevation, a[x][y]);
		floodfill(x-1, y, elevation, a[x][y]);
		floodfill(x, y+1, elevation, a[x][y]);
		floodfill(x, y-1, elevation, a[x][y]);
		
	}
	
	static class coordinates {
		
		int x, y;
		coordinates(int a, int b){
			x = a;
			y = b;
		}
		
	}
	
}
