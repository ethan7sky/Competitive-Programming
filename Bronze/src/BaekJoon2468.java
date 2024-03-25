import java.util.*;
import java.io.*;

public class BaekJoon2468 {
	
	static Scanner in;
	static int n, a[][], b[][], ans, max;
	static int[] chngx = {-1, 1, 0, 0};
	static int[] chngy = {0, 0, 1, -1};
	static Queue<Integer> q;
	static HashSet<Integer> rain;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		solve();
	}
	static void init() {
		n = in.nextInt(); 	
		
		a = new int[n][n];
		b = new int[n][n];
		rain = new HashSet<Integer>(); 
		rain.add(0);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				a[i][j] = in.nextInt();
				rain.add(a[i][j]);
			}
		}
		q = new LinkedList<Integer>();
	}
	static void solve() {
		
		for(int r: rain) {
			int cnt=0;
			reset_b(r);
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(b[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
	static void bfs(int i, int j) {
		
		q.add(i); q.add(j);
		b[i][j] = 0;
		
		while(!q.isEmpty()) {
			
			int x = q.poll();
			int y = q.poll();
			
			
			for(int e=0; e<4; e++) {
				int nx = x + chngx[e];
				int ny = y + chngy[e];
				if(nx<0 || ny<0 || nx >=n || ny >=n || b[nx][ny] == 0) continue;
	                
	            q.add(nx); q.add(ny);  
				b[nx][ny] = 0;   
			}
		}
	}
	static void reset_b(int k) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				b[i][j] = a[i][j]>k? 1:0;
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