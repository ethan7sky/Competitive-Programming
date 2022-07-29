import java.util.*;
import java.io.*;

public class CFMaximumDistance {
	
	static Scanner in;
	static int N, x[], y[];
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		N = in.nextInt();
		x = new int[N];
		y = new int[N];
		
		int[] l = new int[] {Integer.MAX_VALUE,Integer.MAX_VALUE};
		int[] r = new int[] {Integer.MIN_VALUE,Integer.MIN_VALUE};
		int[] u = new int[] {Integer.MIN_VALUE,Integer.MIN_VALUE};
		int[] d = new int[] {Integer.MAX_VALUE,Integer.MAX_VALUE};
		
		for(int i = 0; i < N; i++) {
			x[i] = in.nextInt();
		}
		for(int i = 0; i < N; i++) {
			y[i] = in.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			
			if(x[i] < l[0] || x[i] == l[0] && y[i] < l[1]) {
				l[0] = x[i];
				l[1] = y[i];
			}
			if(x[i] > r[0] || x[i] == r[0] && y[i] > r[1]) {
				r[0] = x[i];
				r[1] = y[i];
			}
			if(y[i] > u[1] || y[i] == u[1] && x[i] < u[0]) {
				u[0] = x[i];
				u[1] = y[i];
			}
			if(y[i] < d[1]|| y[i] == u[1] && x[i] > u[0]) {
				d[0] = x[i];
				d[1] = y[i];
			}
		}
		
		
		long max = Long.MIN_VALUE;
		
		max = Math.max(max, solve(l, u));
		max = Math.max(max, solve(u, r));
		max = Math.max(max, solve(r, d));
		max = Math.max(max, solve(d, l));
		max = Math.max(max, solve(u, d));
		max = Math.max(max, solve(l, r));
		
		
		System.out.println(max);
		
		
	}
	
	static long solve(int[] a, int[] b) {
		long rise = (long) b[1]- (long) a[1];
		long run = (long) b[0]- (long) a[0];
		return (long) ( Math.pow(rise, 2) + Math.pow(run, 2) );
	}
}
