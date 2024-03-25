import java.util.*;
import java.io.*;

public class GCDonBlackboard {
	
	static int n, a[], pre[], suff[], max;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		a = new int[n];
		pre = new int[n+1];
		suff = new int[n+1];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			pre[i+1] = GCD(pre[i],a[i]);
		}
		for(int i=n-1; i>=0; i--) {
			suff[i] = GCD(suff[i+1],a[i]);
		}
		for(int i=0; i<n; i++) {
			max = Math.max(max, GCD(pre[i], suff[i+1]));
		}
		System.out.println(max);
	}
	static int GCD(int a, int b) {
		return b==0? a:GCD(b, a%b);
	}
	
}
