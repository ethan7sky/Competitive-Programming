import java.util.*;
import java.io.*;

public class USACOCowGymnastics {
	
	static BufferedReader in;
	static PrintWriter out;
	static int k, n, ans;
	static int[][] a;
	
	public static void main(String[] args) throws IOException{
		
		//init
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("gymnastics.in"));
		out = new PrintWriter("gymnastics.out");
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		k = Integer.valueOf(st.nextToken());
		n = Integer.valueOf(st.nextToken());
		
		
		a = new int[k][n];
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				
				a[i][Integer.valueOf(st.nextToken())-1] = j+1;
			}
		}
		
		
		
		
		
		//solve
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				
				int win = 0;
				for(int l = 0; l < k; l++) {
					if(a[l][i] < a[l][j]){ win++; }
				}
				
				if(win == 0 || win == k) {
					//System.out.println((i+1)+", "+(j+1));
					ans++;
				}
				
			}
		}
		
		out.println(ans);
		
		in.close();
		out.close();
	}
}
