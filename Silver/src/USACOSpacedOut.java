import java.util.*;
import java.io.*;

public class USACOSpacedOut {
	
	static int n, a[][], ans;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		a = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int hsum = 0;
		for(int i=0; i<n; i++) {
			
			int t = 0;
			int f = 0;
			
			for(int j=0; j<n; j++) {
				if(j%2==0) t+=a[i][j];
				else f+=a[i][j];
			}
			hsum += Math.max(t, f);
		}
		
		int vsum = 0;
		for(int j=0; j<n; j++) {
			
			int t = 0;
			int f = 0;
			
			for(int i=0; i<n; i++) {
				if(i%2==0) t+=a[i][j];
				else f+=a[i][j];
			}
			vsum += Math.max(t, f);
		}
		
		ans = Math.max(hsum, vsum);
		
		System.out.println(ans);
		
	}
	
}
