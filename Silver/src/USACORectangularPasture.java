import java.util.*;
import java.io.*;

public class USACORectangularPasture {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, x[], y[], p[][];
	static long ans;
	static TreeMap<Integer, Integer> xmap, ymap;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
	}
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());
		
		xmap = new TreeMap<Integer, Integer>();
		ymap = new TreeMap<Integer, Integer>();
		x = new int[n];
		y = new int[n];
		p = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(in.readLine());
			xmap.put(Integer.parseInt(st.nextToken()), i);
			ymap.put(Integer.parseInt(st.nextToken()), i);
		}
		int cnt = 1;
		for(int val: xmap.values()) x[val-1]=cnt++;
		cnt=1;
		for(int val: ymap.values())	y[val-1]=cnt++;
		
		System.out.println(Arrays.toString(x));
		System.out.println(Arrays.toString(y));
		
		for(int i=0; i<n; i++) p[x[i]][y[i]]++;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				p[i][j] = p[i][j]+ p[i-1][j] + p[i][j-1] - p[i-1][j-1]; 
			}
		}
	}
	static void solve() {
		
		ans=n+1;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				
				int x1 = x[i];
				int y1 = y[i];
				int x2 = x[j];
				int y2 = y[j];
				
				long upper = count(1, Math.min(y1, y2), Math.min(x1, x2), Math.max(y1, y2));
				long lower = count(Math.max(x1, x2), Math.min(y1, y2), n, Math.max(y1, y2));
				
				ans += upper*lower;
			}
		}
		System.out.println(ans);
	}
	static long count(int x1, int y1, int x2, int y2) {
		return p[x2][y2] - p[x1-1][y2] - p[x2][y1-1] + p[x1-1][y1-1];		
	}
}
