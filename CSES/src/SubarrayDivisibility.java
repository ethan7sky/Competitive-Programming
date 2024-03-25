import java.util.*;
import java.io.*;

public class SubarrayDivisibility {
	
	static int n, sum;
	static long p[], ans;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		sum=0;
		ans=0;
		p = new long[n];
		p[0] = 1;
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			int c = Integer.parseInt(st.nextToken());
			sum += c; sum %=n;
			if(sum<0) sum += n;
			
			ans += p[sum];
			p[sum]++;
		}
		System.out.println(ans);
	}
}
