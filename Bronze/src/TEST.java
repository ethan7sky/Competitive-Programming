import java.util.*;
import java.io.*;

public class TEST {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static PrintWriter out;
	static int n, q, haybales[], a, b;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("haybales.in"));
		out = new PrintWriter("haybales.out");
		
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
			
			a = Arrays.binarySearch(haybales, a);
			b = Arrays.binarySearch(haybales, b);
			if(a<0) a = Math.abs(a)-1;
			if(b<0) b = Math.abs(b)-2; //oops
			sb.append(b-a+1).append("\n");
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