import java.util.*;
import java.io.*;

public class USACOOutOfPlace {
	
	static Scanner in;
	static PrintWriter out;
	static int n, a[], b[], ans;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		in = new Scanner(new FileReader("outofplace.in"));
		out = new PrintWriter("outofplace.out");
		
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
		
		b = a.clone();
		Arrays.sort(b);
		
	}
	
	static void solve() {
		
		ans = -1;
		
		for(int i=0; i<n; i++) {
			if(a[i] != b[i]) ans++;
		}
		
		out.println(ans);
	}
}
