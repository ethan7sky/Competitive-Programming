import java.util.*;
import java.io.*;

public class USACOAirCownditioning2 { 
	 
	static Scanner in; 
	static int n, a[], b[], c[], ans; 
	static ArrayList<Integer> increasing, decreasing; 
	 
	public static void main(String[] args) { 
		
		in = new Scanner(System.in); 
		n = in.nextInt();
		a = new int[n];
		b = new int[n];
		c = new int[n+2];
		
		for(int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}
		for(int i=0; i<n; i++) {
			b[i] = in.nextInt();
		}
		for(int i=1; i<=n; i++) {
			c[i] = a[i-1] - b[i-1];
		}
		
		ans=0;
		for(int i=0; i<=n; i++) {
			ans += Math.abs(c[i] - c[i+1]);
		}
		System.out.println(ans/2);
	}
}