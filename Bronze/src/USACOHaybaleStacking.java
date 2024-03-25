import java.util.*;
import java.io.*;

public class USACOHaybaleStacking {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, k, a[], p[];
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new int[n+2];
		p = new int[n+2];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			a[s]++;
			a[e+1]--;
		}
		
		for(int i=1; i<n+2; i++) {
			p[i] = p[i-1]+a[i];
		}
		
		Arrays.sort(p);
		System.out.println(p[n/2+1]);
	}
	static void solve() {
		
	}
}
