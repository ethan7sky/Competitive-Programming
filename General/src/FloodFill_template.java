import java.util.*;
import java.io.*;

public class FloodFill_template {
	
	static int n, m, a[][], ans;	
	static boolean v[][];
	static BufferedReader in;
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n][m];
		for(int i=0; i<n; i++) {
			a[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		v = new boolean[n][m];
	}
	static void solve() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!v[i][j]) {
					ff(i, j, a[i][j]);
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	static void ff(int i, int j, int c) {
		
		if(i<0||j<0||i>=n||j>=m||v[i][j]||c!=a[i][j]) return;
		
		v[i][j] = true;
		ff(i+1, j, c);
		ff(i-1, j, c);
		ff(i, j+1, c);
		ff(i, j-1, c);
	}
}
