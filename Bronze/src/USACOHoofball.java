import java.util.*;
import java.io.*;

public class USACOHoofball {
	
	static Scanner in;
	static PrintWriter out;
	static int n, a[], ans;
	static char[] dir;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		in = new Scanner(new FileReader("hoofball.in"));
		out = new PrintWriter("hoofball.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		
		n = in.nextInt();
		
		a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		
		dir = new char[n];
		for(int i=1; i<n-1; i++) {
			if(a[i] - a[i-1] <= a[i+1] - a[i]) dir[i] = 'l';
			else dir[i] = 'r';
		}
		
		dir[0] = 'r';
		dir[dir.length-1] = 'l';
	}
	
	static void solve() {
		
		ans = 0;
		int r = 0;	
		
		for(int i=0; i<dir.length; i++) {
			
			if(dir[i] == 'r') r++;
			
			if(dir[i] == 'l') {
				
				if(r > 1) {
					ans++; r=0;
				}
				else if(r <= 1) {
					if(i!=dir.length-1 && dir[i+1] == 'l') continue;
					else {
						ans++; r=0;
					}
				}
			}
		}
		
		out.println(ans);
	}
}