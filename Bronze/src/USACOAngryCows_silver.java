
import java.io.*;
import java.util.*;

public class USACOAngryCows_silver {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, k;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("angry.in"));
		out = new PrintWriter("angry.out");
		
		init();
		solve();
		
		in.close();
		out.close();
		
	}
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(a);
	} 
	
	static void solve() {
		
	}
}