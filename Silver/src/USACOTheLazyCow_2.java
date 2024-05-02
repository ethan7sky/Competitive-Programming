import java.util.*;
import java.io.*;

public class USACOTheLazyCow_2 {
	
	static int n, k, max;
	static int[][] a, p;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("lazy.in"));
		out = new PrintWriter("lazy.out");
		//in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new int[n][n];
		p = new int[2*n][2*n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				p[n-1-j+i  +1][i+j  +1] = a[i][j];
			}
		}
		for(int i=1; i<2*n; i++) {
			for(int j=1; j<2*n; j++) {
				p[i][j] = p[i][j] + p[i-1][j] + p[i][j-1] - p[i-1][j-1];
			}
		}
		
		max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int x = n-1-j+i+1;
				int y = i+j+1;
				
				int x1 = guaranteeInRange(x-k);
				int y1 = guaranteeInRange(y-k);
				int x2 = guaranteeInRange(x+k);
				int y2 = guaranteeInRange(y+k);
				
				int sum = calcSum(x1, y1, x2, y2);
				
				max = Math.max(max, sum);
			}
		}
		out.println(max);
		
		in.close();
		out.close();
	}
	static int calcSum(int x1, int y1, int x2, int y2) {
		return p[x2][y2] - p[x1-1][y2] - p[x2][y1-1] + p[x1-1][y1-1];
	}
	static int guaranteeInRange(int x) {
		if(x<1) return 1;
		if(x>=2*n) return 2*n-1;
		return x;
	}
}
