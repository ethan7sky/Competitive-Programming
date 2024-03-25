import java.util.*;
import java.io.*;

public class CF1365D2 {
	
	static int n, m, t, dx[] = {0,0,-1,1}, dy[] = {-1, 1, 0, 0};
	static char a[][];
	static boolean v[][];
	static BufferedReader in;
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		
		while(t-->0) {
			init();
			System.out.println(solve());
		}
		
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new char[n][m];
		for(int i=0; i<n; i++) {
			a[i] = in.readLine().toCharArray();
		}
		v = new boolean[n][m];
	}
	static String solve() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]=='B') {
					for(int k=0; k<4; k++) {
						int ni = i+dx[k];
						int nj = j+dy[k];
						
						if(ni<0||nj<0||ni>=n||nj>=m) continue;
						if(a[ni][nj]=='G') return "No";
						if(a[ni][nj]=='.') a[ni][nj]='#';
					}
				}
			}
		}
		//check G
		if(a[n-1][m-1] != '#') {
			ff(n-1, m-1);
		}
		
		//a[][] : v[][]
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j] == 'G' && !v[i][j]) return "No";
			}
		}
		return "Yes";
	}
	static void ff(int i, int j) {
		
		if(i<0||j<0||i>=n||j>=m||v[i][j]||a[i][j]=='#') return;
		
		v[i][j] = true;
		ff(i+1, j);
		ff(i-1, j);
		ff(i, j+1);
		ff(i, j-1);
	}
}
