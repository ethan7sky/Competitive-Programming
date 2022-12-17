import java.io.*;
import java.util.*;

public class USACOAcowdemiaI1 {
	
	static int n, l;
	static Integer a[];
	static Scanner in;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		init();
		solve();
		
	}
	
	static void init() {
		
		n = in.nextInt();
		l = in.nextInt();
		
		a = new Integer[n];
		for(int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}
		
		Arrays.sort(a, Comparator.reverseOrder());		
	}
	
	static void solve() {
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			if(i+1 > a[i]) break;
			ans++;
		}
		
		for(int i=ans; i>=0; i--) {
			if(l==0) break;
			l--;
			a[i]++;
		}
		
		
		ans = 0;
		for(int i=0; i<n; i++) {
			if(i+1 > a[i]) break;
			ans++;
		}
		
		
		System.out.println(ans);
	}
}
