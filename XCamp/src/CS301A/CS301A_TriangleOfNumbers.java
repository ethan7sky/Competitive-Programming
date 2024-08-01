package CS301A;
import java.util.*;
import java.io.*;

public class CS301A_TriangleOfNumbers {
	
	static int n;
	static int[][] a, s;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		a = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<=i; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r = n-2; r>=0; r--) {
			for(int i=0; i<=r; i++) {
				a[r][i] += Math.max(a[r+1][i], a[r+1][i+1]);
			}
		}
		System.out.println(a[0][0]);
	}
	
	
}
