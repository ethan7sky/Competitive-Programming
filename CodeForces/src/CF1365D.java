import java.util.*;
import java.io.*;

public class CF1365D {
	
	static int[] cx = {1, -1, 0, 0};
	static int[] cy = {0, 0, 1, -1};
	
	static int t, n, m, good, cnt;
	static char a[][];
	static boolean v[][];
	static ArrayList<coordinates> bad;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			init();
			if(solve()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new char[n][m];
		good = 0;
		bad = new ArrayList<coordinates>();
		for(int i=0; i<n; i++) {
			String s = in.readLine();
			for(int j=0; j<m; j++) {
				a[i][j] = s.charAt(j);
				if(a[i][j]=='G') good++;
				else if(a[i][j]=='B') bad.add(new coordinates(i, j));
			}
		}
		v = new boolean[n][m];
		cnt=0;		
	}
	static boolean solve() {
		
		//trap all bad people
		for(coordinates c: bad) {
			if(!trap(c.x, c.y)) return false;
		}
		
		floodfill(n-1, m-1);
		
		if(good==0 || good==cnt) return true;
		return false;
	}
	static void floodfill(int x, int y) {
		
		if(x<0 || y<0 || x>=n || y>=m) return;
		if(a[x][y] == '#' || v[x][y]) return;
		
		v[x][y] = true;
		if(a[x][y] == 'G') cnt++;
		
		floodfill(x-1, y);
		floodfill(x+1, y);
		floodfill(x, y+1);
		floodfill(x, y-1);
		
	}
	static boolean trap(int x, int y) {
		
		for(int i=0; i<4; i++) {
			if(x+cx[i]<0 || x+cx[i]>=n || y+cy[i]<0 || y+cy[i]>=m) {
				continue;
			}
			if(a[x+cx[i]][y+cy[i]]=='G') return false;
			if(a[x+cx[i]][y+cy[i]]=='.') a[x+cx[i]][y+cy[i]]='#';
		}
		return true;
	}
	
	static class coordinates {
		
		int x, y;
		coordinates(int a, int b){
			x = a;
			y = b;
		}
		public String toString() {
			return x+" "+y;
		}
	}
}
