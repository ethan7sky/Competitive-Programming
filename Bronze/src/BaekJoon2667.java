import java.util.*;
import java.io.*;

public class BaekJoon2667 {
	
	static Scanner in;
	static int n, max, cnt;
	static char a[][];
	static int[] chngx = {-1, 1, 0, 0};
	static int[] chngy = {0, 0, 1, -1};
	static Queue<Integer> q;
	static HashSet<Integer> rain;
	static ArrayList<Integer> ans;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		solve();
	}
	static void init() {
		n = in.nextInt(); in.nextLine();
		
		a = new char[n][];
		
		for(int i=0; i<n; i++) {
			a[i] = in.nextLine().toCharArray();
		}
		q = new LinkedList<Integer>();
		ans = new ArrayList<Integer>();
	}
	static void solve() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] == '1') {
					cnt=1;			
					bfs(i, j);
					ans.add(cnt);
				}
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i: ans) System.out.println(i);
	}
	static void bfs(int i, int j) {
		
		q.add(i); q.add(j);
		a[i][j] = '0';
		
		while(!q.isEmpty()) {
			
			int x = q.poll();
			int y = q.poll();
			
			
			for(int e=0; e<4; e++) {
				int nx = x + chngx[e];
				int ny = y + chngy[e];
				if(nx<0 || ny<0 || nx >=n || ny >=n || a[nx][ny] == '0') continue;
	                
	            q.add(nx); q.add(ny);  
				a[nx][ny] = '0'; 
				cnt++;
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