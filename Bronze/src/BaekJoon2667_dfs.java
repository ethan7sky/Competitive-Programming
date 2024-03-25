import java.util.*;
import java.io.*;

public class BaekJoon2667_dfs {
	
	static Scanner in;
	static int n, max, cnt;
	static char a[][];
	static int[] chngx = {-1, 1, 0, 0};
	static int[] chngy = {0, 0, 1, -1};
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
		ans = new ArrayList<Integer>();
	}
	static void solve() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] == '1') {
					cnt=1;			
					dfs(i, j);
					ans.add(cnt);
				}
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i: ans) System.out.println(i);
	}
	static void dfs(int x, int y) {
		
		a[x][y] = '0';
			
			
		for(int e=0; e<4; e++) {
			int nx = x + chngx[e];
			int ny = y + chngy[e];
			if(nx<0 || ny<0 || nx >=n || ny >=n || a[nx][ny] == '0') continue;
			
			dfs(nx, ny);
			cnt++;
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