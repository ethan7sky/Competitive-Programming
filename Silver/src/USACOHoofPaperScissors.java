import java.util.*;
import java.io.*;

public class USACOHoofPaperScissors {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, a[], s[][], e[][], ans;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("hps.in"));
		out = new PrintWriter("hps.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = conv(in.readLine());

		s = new int[n][3];
		e = new int[n][3];
		
		s[0][a[0]]++;
		e[n-1][a[n-1]]++;
		for(int i=1; i<n; i++) {
			for(int j=0; j<3; j++) {
				s[i][j] = s[i-1][j];
				e[n-i-1][j] = e[n-i][j];
			}
			s[i][a[i]]++;
			e[n-i-1][a[n-i-1]]++;
		}
	}
	static void solve() { 
		
		for(int i=0; i<n-1; i++) {
			ans = Math.max(max(s[i])+ max(e[i+1]),ans);
		}
		out.println(ans);
	}
	static int max(int[] x) {
		
		return Math.max(x[0],  Math.max(x[1],  x[2]));
	}
	static int conv(String s) {
		
		if(s.equals("P")) return 0;
		else if(s.equals("H")) return 1;
		return 2;
	}
}
