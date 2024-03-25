import java.util.*;
import java.io.*;

public class TEST {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, a[], bit[], j;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("sleepy.in"));
		out = new PrintWriter("sleepy.out");
		
		n = Integer.parseInt(in.readLine());
		a = new int[n+1];
		bit = new int[n+1];
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++) 
			a[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) if(a[i+1]<a[i]) j=i;
		out.println(j);
		
		for(int i=j+1; i<=n; i++) update(a[i]);

		for(int i=1; i<j; i++) {
			out.print(j-i+sum(a[i]-1)+" ");
			update(a[i]);
		}
		out.println(sum(a[j]-1));
		
		in.close();
		out.close();
	}
	static void update(int i) {
		while(i<=n) {
			bit[i]++;
			i += i&-i;
		}
	}
	static int sum(int i) {
		int ans = 0;
		while(i>0) {
			ans+=bit[i];
			i -= i&-i;
		}
		return ans;
	}
}
