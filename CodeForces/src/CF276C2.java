import java.util.*;
import java.io.*;

public class CF276C2 {
	
	static int n, q;
	static int M = 2*(int)1e5;
	static int a[];
	static int d[];
	static long freq[];
	static long sum;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		 in = new BufferedReader(new InputStreamReader(System.in));
		 
		 st = new StringTokenizer(in.readLine());
		 
		 n = Integer.parseInt(st.nextToken());
		 q = Integer.parseInt(st.nextToken());
		 
		 a = new int[n];
		 
		 st = new StringTokenizer(in.readLine());
		 for(int i=0; i<n; i++) {
			 a[i] = Integer.parseInt(st.nextToken());
		 }
		 Arrays.sort(a);
		 
		 d = new int[n+1];
		 for(int i=0; i<q; i++) {
			 st = new StringTokenizer(in.readLine());
			 d[Integer.parseInt(st.nextToken())-1]++;
			 d[Integer.parseInt(st.nextToken())]--;
		 }
		 
		 for(int i=1; i<n+1; i++) {
			 d[i] += d[i-1];
		 }
		 
		 Arrays.sort(d);
		 
		 
		 sum=0;
		 for(int i=n-1; i>=0; i--) {
			 sum += (long)a[i]*d[i+1];
		 }
		 System.out.println(sum);
		 
		
	}
}
