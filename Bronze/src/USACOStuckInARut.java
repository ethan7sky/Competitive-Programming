import java.util.*;
import java.io.*;

public class USACOStuckInARut {
	static Scanner in;
	static PrintWriter out;
	static int n, x[], y[];
	static char d[];
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		
		n = in.nextInt();
		x = new int[n];
		y = new int[n];
		d = new char[n];
		
		for(int i = 0; i < n; i++) {
			d[i] = in.next().charAt(0);
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		
	}
	static void solve() {
		
		int min = 0;
		for(int i = 0; i < n; i++) {
			min = check(i);
			
			if(min == Integer.MAX_VALUE) {
				System.out.println("Infinity");
			}
			else System.out.println(min);
		}
	}
	
	static int check(int i) {
		
		int min = Integer.MAX_VALUE;
		
		for(int j = 0; j < n; j++) {
			
			if(i==j || d[i]==d[j]) continue;
			
			int dx = Math.abs(x[i]-x[j]);
			int dy = Math.abs(y[i]-y[j]);
			
			if(d[i]=='E') {
				if(x[i]>x[j] || y[i] < y[j]) continue;
				if(dx>dy && check(j)>=dy) min = Math.min(min,  dx);
				
			}
			else {
				if(x[i]<x[j] || y[i] > y[j]) continue;
				if(dx<dy && check(j)>=dy) min = Math.min(min,  dy);
				
			}
		}
		return min;
	}
}
