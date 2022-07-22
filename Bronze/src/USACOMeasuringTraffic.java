import java.util.*;
import java.io.*;

public class USACOMeasuringTraffic {
	
	static Scanner in;
	static PrintWriter out;
	static int n, a[], b[];
	static String[] c;
	
	public static void main(String[] args) throws IOException{
		
		in = new Scanner(new FileReader("traffic.in"));
		out = new PrintWriter("traffic.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		
		n = in.nextInt();
		a = new int[n];
		b = new int[n];
		c = new String[n];

		for(int i = 0; i < n; i++) {
			c[i] = in.next();
			a[i] = in.nextInt();
			b[i] = in.nextInt();
			
		}
	}
	
	static void solve() {
		
		int left = -999999999;
		int right = 999999999;
		
		
		for(int i = n-1; i >= 0; i--) {
			if(c[i].equals("none")) {
				left = Math.max(left, a[i]);
				right = Math.min(right,  b[i]);
			}
			else if(c[i].equals("off")) {
				left += a[i];
				right += b[i];
			}
			else if(c[i].equals("on")) {
				left -= b[i];
				right -= a[i];
				if(left < 0) left = 0;
			}
		}

		out.println(left+" "+right);
		
		left = -999999999;
		right = 999999999;

		
		for(int i = 0; i < n; i++) {
			if(c[i].equals("none")) {
				left = Math.max(left, a[i]);
				right = Math.min(right,  b[i]);
			}
			else if(c[i].equals("on")) {
				left += a[i];
				right += b[i];
			}
			else if(c[i].equals("off")) {
				left -= b[i];
				right -= a[i];
				if(left < 0) left = 0;
			}
		}
		
		out.println(left+" "+right);
		

	}
}
