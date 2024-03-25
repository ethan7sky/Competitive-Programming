import java.util.*;
import java.io.*;

public class USACOCountingHaybales_silver {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static PrintWriter out;
	static int n, q, haybales[], a, b;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("haybales.in"));
		out = new PrintWriter("haybales.out");		
		//in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	static void solve() throws IOException {
		
		sb = new StringBuilder();
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			int aidx = Arrays.binarySearch(haybales, a);
			int bidx = Arrays.binarySearch(haybales, b);
			if(aidx<0) aidx = -aidx-1;
			if(bidx<0) bidx = -bidx-2;
			
			sb.append(bidx-aidx+1).append("\n");
		}
		out.print(sb);
		
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		haybales = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++)
			haybales[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(haybales);
	}
}