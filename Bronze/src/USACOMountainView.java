import java.util.*;
import java.io.*;

public class USACOMountainView {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, x[], y[], cnt;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("mountains.in"));
		out = new PrintWriter("mountains.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	static void init() throws IOException{
		
		n = Integer.parseInt(in.readLine());
		x = new int[n];
		y = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		cnt=0;
	}
	static void solve() {
		
		for(int i=0; i<n; i++) {
			int currx = x[i];
			int curry = y[i];
			
			boolean view = true;
			for(int j=0; j<n; j++) {
				if(j==i) continue;
				if(y[j]-curry>=Math.abs(x[j]-currx)) {
					view = false;
					break;
				}
			}
			if(view) cnt++;
		}
		out.println(cnt);
	}
}
