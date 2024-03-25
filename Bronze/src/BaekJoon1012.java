import java.util.*;
import java.io.*;

public class BaekJoon1012 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int t, n, m, k, cnt;
	static boolean a[][];
	static int[] chngx = {-1, 1, 0, 0};
	static int[] chngy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		for(int i=0; i<t; i++) {
			init();
			solve();
		}
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new boolean[n][m];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x][y] = true;
		}
		cnt=0;
	}
	static void solve() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]) {	
					dfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	static void dfs(int x, int y) {
		
		a[x][y] = false;
			
			
		for(int e=0; e<4; e++) {
			int nx = x + chngx[e];
			int ny = y + chngy[e];
			if(nx<0 || ny<0 || nx >=n || ny >=m || a[nx][ny] == false) continue;
			
			dfs(nx, ny);
		}
	}
}