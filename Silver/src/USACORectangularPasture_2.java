import java.util.*;
import java.io.*;

public class USACORectangularPasture_2 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, x[], y[];
	static int[][] p;
	static TreeMap<Integer, Integer> sortx, sorty;
	static long ans;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		
		//coordinate compression
		sortx = new TreeMap<Integer, Integer>();
		sorty = new TreeMap<Integer, Integer>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			
			sortx.put(Integer.parseInt(st.nextToken()), i);
			sorty.put(Integer.parseInt(st.nextToken()), i);			
		}
		
		x = new int[n];
		y = new int[n];
		
		int compressed=1;
		for(int i: sortx.values()) {
			x[i] = compressed;
			compressed++;
		}
		compressed=1;
		for(int i: sorty.values()) {
			y[i] = compressed;
			compressed++;
		}
		
		//create 2d prefix sums
		p = new int[n+1][n+1];
		for(int i=0; i<n; i++) {
			p[x[i]][y[i]]++;
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				p[i][j] = p[i][j]+p[i-1][j]+p[i][j-1]-p[i-1][j-1];
			}
		}
		
		//find ans
		ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				
				int x1 = x[i];
				int y1 = y[i];
				int x2 = x[j];
				int y2 = y[j];
				
				int upper = count(1, Math.min(y1, y2), Math.min(x1, x2), Math.max(y1, y2));
				int lower = count(Math.max(x1, x2), Math.min(y1, y2), n, Math.max(y1, y2));
				
				ans += (long)upper*lower;				
			}
		}
		ans += n+1;
		System.out.println(ans);
	}
	static int count(int x1, int y1, int x2, int y2) {
		
		return p[x2][y2]-p[x1-1][y2]-p[x2][y1-1]+p[x1-1][y1-1];
		
	}
}
