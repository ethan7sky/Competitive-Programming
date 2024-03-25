import java.util.*;
import java.io.*;

public class BaekJoon7576 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int a[][];
	static int n, m, ans;
	static boolean v[][];
    static int[] chngx = {-1, 1, 0, 0};
    static int[] chngy = {0, 0, -1, 1};
    static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[m][n];
		v = new boolean[m][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q = new LinkedList<Integer>();
	}
	static void solve() {
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] == 1) bfs(i, j);
			}
		}
		
		ans = -1;
		check:
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j]==0) {
					ans=-1;
					break check;
				}
				if(a[i][j] != -1) {
					ans = Math.max(ans, a[i][j]-1);
				}
			}
		}System.out.println(ans);
	}
	static void bfs(int i, int j) {
		
		q.add(i); q.add(j);
		
		while(!q.isEmpty()) {
			
			int x = q.poll();
			int y = q.poll();
			
			
			for(int e=0; e<4; e++) {
				
				int nx = x + chngx[e];
				int ny = y + chngy[e];
				if(nx<0 || ny<0 || nx >=m || ny >=n) continue;
	            if(a[nx][ny] == -1) continue;
				
	            if(a[nx][ny]!=0 && a[x][y]+1 >= a[nx][ny]) continue;
	            
             	a[nx][ny] = a[x][y]+1;
            	q.add(nx); q.add(ny);
			}
		}
	}
}
