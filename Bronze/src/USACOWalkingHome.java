import java.util.*;
import java.io.*;

public class USACOWalkingHome {
	
	static int t, k, n, cnt;
	static boolean a[][];
	static Scanner in;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
	}
	static void init() {
		t = in.nextInt();
		
		for(int i=0; i<t; i++) {
			
			cnt=0;
			n = in.nextInt();
			k=in.nextInt();
			
			a = new boolean[n][n];
			for(int j=0; j<n; j++) {
				String line = in.next();
				for(int k=0; k<n; k++) {
					a[j][k] = line.charAt(k) == 'H';
				}
			}
			
			solve(1, 0, 'r', 0);
			solve(0, 1, 'd', 0);
			
			System.out.println(cnt);
		}
	}
	
	static void solve(int x, int y, char dir, int log) {
		
		if(x>=n || y>=n || a[x][y] || log > k) return;
		if(x==n-1 && y==n-1) {
			cnt++;
		}
		else {
			if(dir=='r') {
				solve(x+1, y, 'r', log);
				solve(x, y+1, 'd', log+1);
			}
			else if(dir == 'd') {
				solve(x+1, y, 'r', log+1);
				solve(x, y+1, 'd', log);
			}
		}
	}
}
