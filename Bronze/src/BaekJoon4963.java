import java.util.*;
import java.io.*;

public class BaekJoon4963 {
	
	static BufferedReader in;
	static StringTokenizer st;
	
	static int w, h, a[][], ans;
	static int[] chngx = {0, 0, 1, -1, 1, -1, 1, -1};
	static int[] chngy = {1, -1, 0, 0, 1, 1, -1, -1};
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		while(w!=0 && h!=0) {
			init();
			solve();
			st = new StringTokenizer(in.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
	}
	static void init() throws IOException {
		
		a = new int[h][w];
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<w; j++) 
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		q = new LinkedList<Integer>();
		ans=0;
	}
	static void solve() {
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(a[i][j] == 1) {
					bfs(i, j);
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	static void bfs(int i, int j) {
		
		q.add(i); q.add(j);
		a[i][j] = 0;
		
		while(!q.isEmpty()) {
			
			int x = q.poll();
			int y = q.poll();
			
			
			for(int e=0; e<8; e++) {
				int nx = x + chngx[e];
				int ny = y + chngy[e];
				if(nx<0 || ny<0 || nx >=h || ny >=w || a[nx][ny] == 0) continue;
	                
	            q.add(nx); q.add(ny);     
	            a[nx][ny] = 0;
			}
		}
	}
}