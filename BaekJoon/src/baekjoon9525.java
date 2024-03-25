import java.util.*;
import java.io.*;

public class baekjoon9525 {
	
	static Scanner in;
	static StringTokenizer st;
	static String s;
	static int n, row[][], col[][], rook[], r, c;
	static char m[][];
	static ArrayList<Integer>[] a;
	static boolean v[];
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	static void init() throws IOException{
		
		n = in.nextInt();
		m = new char[n][];
		for(int i=0; i<n; i++) 
			m[i] = in.next().toCharArray();
		
		row = new int[n][n];
		col = new int[n][n];
		
		r=1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(m[i][j]=='.') {
					row[i][j] = r;
					if(j==n-1 || j<n&&m[i][j+1]=='X') r++;
				}
			}
		}
		c=1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(m[j][i]=='.') {
					col[j][i] = c;
					if(j==n-1 || j<n&&m[j+1][i]=='X') c++;
				}
			}
		}
		int max = Math.max(c, r);
		a = new ArrayList[max+1];
		Arrays.setAll(a, i->new ArrayList<Integer>());
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(m[i][j]=='.') a[row[i][j]].add(col[i][j]);
			}
		}
	}
	
	static void print(int[][] a) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(a[i][j]);;
			}
			System.out.println();;;
		}
	}
	static void solve() {
		
		rook = new int[10000];
		Arrays.fill(rook, -1);
		v = new boolean[10000];
		int cnt=0;
		for(int i=1; i<=r; i++) {
			Arrays.fill(v,  false);
			if(dfs(i)) cnt++;
		}
		
		System.out.println(cnt);
	}
	static boolean dfs(int i) {
		
		v[i] = true;
		for(int next: a[i]) {
			if(rook[next]==-1 || !v[rook[next]] && dfs(rook[next])) {
				rook[next] = i;
				return true;
			}
		}
		
		return false;
	}
	
}
