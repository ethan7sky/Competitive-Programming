package LevelTest;
import java.util.*;
import java.io.*;

public class B_Territory {
	
	static int n, m, ans=0;
	static char[][] a;
	static boolean[][] v;
	static int[] cx = {1, -1, 0, 0}, cy = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		a = new char[m][];
		for(int i=0; i<m; i++) 
			a[i] = in.next().toCharArray();
		v = new boolean[m][n];
		
		int x=0;
		int y=0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j]=='@') {
					x=i; y=j; i=m; j=n;
				}
			}
		}
		
		ff(x, y);
		System.out.println(ans);
	}
	static void ff(int x, int y) {
		if(x>=m || x<0 || y>=n || y<0) return;
		if(v[x][y]) return;
		if(a[x][y]=='#') return;
		
		ans++; v[x][y] = true;
		for(int i=0; i<4; i++) {
			ff(x+cx[i], y+cy[i]);
		}
	}
}
