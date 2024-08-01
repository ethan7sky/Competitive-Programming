import java.util.*;
import java.io.*;

public class CF276C {
	
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
		 
		 d = new int[n+2];
		 for(int i=0; i<q; i++) {
			 st = new StringTokenizer(in.readLine());
			 d[Integer.parseInt(st.nextToken())]++;
			 d[Integer.parseInt(st.nextToken())+1]--;
		 }
		 
		 freq = new long[q+1];
		 
		 int cnt=0;
		 for(int i=1; i<n+2; i++) {
			 cnt += d[i];
			 freq[cnt]++;
		 }
		 
		 sum=0;
		 int idx = n-1;
		 for(int i=q; i>0 && idx>=0; i--) {
			 while(idx >= 0 && freq[i]>0) {
				 sum += (long) i*a[idx];
				 freq[i]--;
				 idx--;
			 }
		 }
		 
		 System.out.println(sum);
	}
}
