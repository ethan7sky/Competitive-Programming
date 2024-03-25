import java.util.*;
import java.io.*;

public class USACOStuckInARut {
	
	static BufferedReader in;
	static PrintWriter out;
	static int n, x[], y[], ans[];
	static boolean stop[];
	static ArrayList<Integer> E, N;
	
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		
	}
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());
		
		E = new ArrayList<Integer>();
		N = new ArrayList<Integer>();
		x = new int[n];
		y = new int[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			char d = st.nextToken().charAt(0);
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			if(d=='E') E.add(i);
			else N.add(i);
		}
		E.sort(Comparator.comparing(i->y[i]));
		N.sort(Comparator.comparing(i->x[i]));
		stop =new boolean[n];
		ans = new int[n];
	}
	static void solve() {
		
		for(int e: E) {
			for(int n: N) {
				
				if(stop[e]||stop[n]||x[e]>=x[n]||y[e]<=y[n]) continue;
				
				int dx = Math.abs(x[e]-x[n]);
				int dy = Math.abs(y[e]-y[n]);
				
				if(dx<dy) {
					stop[n] = true;
					ans[e] += 1+ans[n];
				}
				else if(dx>dy) {
					stop[e] = true;
					ans[n] += 1+ans[e];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i: ans) sb.append(i).append("\n");
		System.out.print(sb.toString());
	}
}
