import java.util.*;
import java.io.*;

public class USACOIcyPerimeter {
	
	static boolean a[][], v[][];
	static int n, area, perimeter, ares, pres;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new FileReader("perimeter.in"));
		out = new PrintWriter("perimeter.out");
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		a = new boolean[n][n];
		v = new boolean [n][n];
		
		for(int i=0; i<n; i++) {
			String s = in.next();
			for(int j=0;j<n;j++) a[i][j] = s.charAt(j)=='#';
		}
	}
	static void solve() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] && !v[i][j]) {
					area=0; perimeter=0;
					fill(i, j);
					
					if(area>ares) {
						ares = area;
						pres = perimeter;
					}
					else if(area==ares) {
						pres = Math.min(pres, perimeter);
					}
				}
			}
		}
		out.println(ares+" "+pres);
	}
	static void fill(int x, int y) {
		
		if(x<0 || y<0 || x>=n || y>=n || !a[x][y]) {
			perimeter++; return;
		}if(v[x][y]) return;
		v[x][y] = true;
		area++;
		
		fill(x+1, y);
		fill(x-1, y);
		fill(x, y+1);
		fill(x, y-1);
	}
}
