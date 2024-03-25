import java.util.*;
import java.io.*;

public class USACOBerryPicking {
	
	static int n, k, a[], min;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		
		min = a[n-k];
	}
	static void solve() {
		
		ArrayList<Integer> baskets = new ArrayList<Integer>();
		
		for(int i=n-1; i>=0; i--) {
			
			int curr = a[i];
			int multiples = curr/min;
			int remainder = curr%min;
			
			while(remainder > multiples) {
				baskets.add(curr + remainder/multiples);
				
			}
			
		}
		
	}
	
}
