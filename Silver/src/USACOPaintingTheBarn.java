import java.util.*;
import java.io.*;

public class USACOPaintingTheBarn {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, k, a[][];
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("paintbarn.in"));
		out = new PrintWriter("paintbarn.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new int[1001][1001];
		for(int j=0; j<n; j++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int i=x1; i<x2; i++) {
				a[i][y1]++;
				a[i][y2]--;
			}
		}
	}
	
	static void solve() {
		
		int ans = 0;
		
		for(int i=0; i<1000; i++) {
			for(int j=0; j<1000; j++) {
				if(a[i][j]==k) ans++;
				a[i][j+1]+=a[i][j];
			}
		}
		out.println(ans);
	}
}
