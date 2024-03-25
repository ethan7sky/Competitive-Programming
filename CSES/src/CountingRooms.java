import java.util.*;
import java.io.*;

public class CountingRooms {
	
	static Scanner in;
	static int n, m, a[][], ans;
	static int[] chngx = {-1, 1, 0, 0};
	static int[] chngy = {0, 0, 1, -1};
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		solve();
	}
	static void init() {
		n = in.nextInt(); 
		m = in.nextInt();
		
		a = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) 
				a[i][j] = in.nextInt();
		}
		q = new LinkedList<Integer>();
		
		
	}
	static void solve() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
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
			a[x][y] = 0;
			
			
			for(int e=0; e<4; e++) {
				int nx = x + chngx[e];
				int ny = y + chngy[e];
				if(nx<0 || ny<0 || nx >=n || ny >=m || a[nx][ny] == 0) continue;
	                
	            q.add(nx); q.add(ny);     
			}
		}
	}
}

/*
5 5
1 0 0 1 1
1 0 0 0 0
0 0 1 1 1
1 1 1 0 0
0 0 0 1 1


4*/