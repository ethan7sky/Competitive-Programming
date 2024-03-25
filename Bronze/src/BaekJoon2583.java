import java.util.*;
import java.io.*;

public class BaekJoon2583 {
	
	static int m, n, k, a[][], cnt;
	static Queue<Integer> q;
	static ArrayList<Integer> ans;
	static int[] chngx = {-1, 1, 0, 0};
	static int[] chngy = {0, 0, 1, -1};
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
	}
	static void solve() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j] == 1) {
					cnt=1;			
					bfs(i, j);
					ans.add(cnt);
				}
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i: ans) System.out.print(i+" ");
	}
	static void bfs(int i, int j) {
		
		q.add(i); q.add(j);
		a[i][j] = 0;
		
		while(!q.isEmpty()) {
			
			int x = q.poll();
			int y = q.poll();
			
			
			for(int e=0; e<4; e++) {
				int nx = x + chngx[e];
				int ny = y + chngy[e];
				if(nx<0 || ny<0 || nx >=n || ny >=m || a[nx][ny] == 0) continue;
	                
	            q.add(nx); q.add(ny);  
				a[nx][ny] = 0; 
				cnt++;
			}
		}
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new int[n][m];
		for(int i=0; i<n; i++) Arrays.fill(a[i], 1);
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2= Integer.parseInt(st.nextToken());
			for(int j=x1; j<x2; j++) {
				for(int k=y1; k<y2; k++) a[j][k] = 0;
			}
		}
		ans = new ArrayList<Integer>();
		q = new LinkedList<Integer>();
	}
}
