import java.util.*;
import java.io.*;

public class USACOLoadBalancing {
	
	static int n, q1, q2, q3, q4, min;
	static xy[] a;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader("balancing.in"));
		//out = new PrintWriter("balancing.out");
		
		init();
		
		System.out.println(min);
		
		in.close();
		out.close();
	}
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());
		
		a = new xy[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = new xy(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
		}
		
		min=n;
		for(int i=0; i<n; i++) {
			solve(a[i].x+1, a[i].y+1);
			solve(a[i].x+1, a[i].y-1);
			solve(a[i].x-1, a[i].y+1);
			solve(a[i].x-1, a[i].y-1);
		}
		
	}
	static void solve(int x, int y) {
		
		q1=q2=q3=q4=0;
		
		for(int i=0; i<n; i++) {
			if(a[i].x>x&&a[i].y>y) q1++;
			else if(a[i].x<x&&a[i].y>y) q2++;
			else if(a[i].x<x&&a[i].y<y) q3++;
			else q4++;
		}
		min = Math.min(min, Math.max(Math.max(q1, q2), Math.max(q3, q4)));
		
	}
	
	
	static class xy {
		
		int x, y;
		xy(int a, int b) {
			x = a;
			y = b;
		}
		
	}
}
