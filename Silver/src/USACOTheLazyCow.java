import java.util.*;
import java.io.*;

public class USACOTheLazyCow {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, n2, k, a[][];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		n2 = 2*n-1;
		a = new int[n2][n2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				a[i+j][n-i+j-1] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(a[i][j]+" ");
			}System.out.println();
		}
		
		
	}
}
