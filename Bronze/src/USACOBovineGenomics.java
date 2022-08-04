import java.io.*;
import java.util.*;

public class USACOBovineGenomics {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, m, ans;
	static String a[], b[];
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
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
			
			char[] a1 = new char[n];
			char[] b1 = new char[n];
			
			for(int j = 0; j < n; j++) {
				a1[j] = a[j].charAt(i);
				b1[j] = b[j].charAt(i);
			}
			
			//position = i
			boolean flag = true;
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(a1[j] == b1[k] || b1[j] == a1[k]) {
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
