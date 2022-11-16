import java.util.*;
import java.io.*;

public class USACOJustStalling {
	
	static Scanner in;
	static int n, a[], b[], cow, j;
	static long ans;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		
		n = in.nextInt();
		
		a = new int[n];
		b = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}
		for(int i=0; i<n; i++) {
			b[i] = in.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b);
		
	}
	static void solve() {
		
		ans = 1;
		j = 0;
		cow = 0;
		
		for(int i=0; i<n; i++) {
			
			while(j<n && b[i] >= a[j]) {
				cow++; j++;
			}
			ans *= cow;
			cow--;
		}
		System.out.println(ans);
	}
}
