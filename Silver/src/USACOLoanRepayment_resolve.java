import java.util.*;
import java.io.*;

public class USACOLoanRepayment_resolve {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static long N, K, M;
	
	public static void main(String[] args) throws IOException {
		
//		in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("loan.in"));
		out = new PrintWriter("loan.out");
		st = new StringTokenizer(in.readLine());
		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		long min=1, max=(long)1e18, mid;
		long ans=1;
		
		while(min<=max) {
			mid=(min+max)/2;
			long d = calc(N, mid);
			if(d<=K) {
				ans=mid;
				min=mid+1;
			} else {
				max=mid-1;
			}
		}
		
//		System.out.println(ans);
		
//		System.out.println(calc(N, 2));
		
		
		out.println(ans);
		
		in.close();
		out.close();
	}
	
	static long calc(long n, long X) { 
//		System.out.println(n);
		if(n<=0) return 0;
		long y = n/X;
		if(y<=M) {
			return (long)Math.ceil(n/(double)M);
		} else {
			long skip = (n%X)/y+1;
			return skip + calc(n-y*skip, X);
		}
	}
	
}
