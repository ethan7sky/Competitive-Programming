import java.util.*;
import java.io.*;

public class GRedPandacakes {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int t, n;
	static long a[], p[];
	static long ans, totalSum;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		
		while(t-->0) {
			n = Integer.parseInt(in.readLine());
			a = new long[n];
			p = new long[n+1];
			
			totalSum = 0;
			
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<n; i++) {
				a[i] = Long.parseLong(st.nextToken());
				p[i+1] = p[i]+a[i];
				totalSum += a[i];
			}
			
			
			ans=Long.MAX_VALUE;
			for(int first=0; first<n; first++) {
				
				int half = (int)Math.ceil(n/2.0);
				long rightSum = 0;
				
				rightSum += p[Math.min(n, first+half)];
				rightSum -= p[first];
				if(first+half > n) {
					rightSum += p[first+half-n];
				}
				
				long leftSum = totalSum-rightSum+a[first];
				if(n%2==0) {
					int idx = (first+half)%n;
					leftSum -= a[idx];
				}
				
				System.out.println(rightSum+" "+leftSum);
				
				ans = Math.min(ans, Math.max(rightSum, leftSum));
				
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
