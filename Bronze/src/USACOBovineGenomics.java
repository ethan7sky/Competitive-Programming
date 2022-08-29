import java.io.*;
import java.util.*;

public class USACOBovineGenomics {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, m, ans;
	static String a[], b[];
	
	public static void main(String[] args) throws IOException {
	
		in = new BufferedReader(new FileReader("cownomics.in"));
		out = new PrintWriter("cownomics.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException{
		st = new StringTokenizer(in.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		a = new String[n];
		b = new String[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = in.readLine();
		}
		for(int i = 0; i < n; i++) {
			b[i] = in.readLine();
		}
	}
	
	static void solve() {
		
		for(int i = 0; i < m; i++) {
			
			boolean flag = true;
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(a[j].charAt(i) == b[k].charAt(i)) {
						flag = false;
						break;
					}
				}
			}
			
			if(flag) ans++;
		}
		out.println(ans);
	}
}