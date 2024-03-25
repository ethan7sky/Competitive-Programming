import java.util.*;
import java.io.*;

public class USACOMoocast {
	
	static int n, x[], y[],p[], max, cnt;
	static boolean visited[];
	static ArrayList<Integer>[] a;
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new FileReader("moocast.in"));
		out = new PrintWriter("moocast.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());
		x = new int[n];
		y = new int[n];
		p = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		a = new ArrayList[n];
		for(int i=0; i<n; i++) a[i] = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				
				double d = Math.sqrt(Math.pow(x[i]-x[j],2)+Math.pow(y[i]-y[j], 2));
				
				if(p[i]>=d) a[i].add(j);
				if(p[j]>=d) a[j].add(i);
			}
		}
		max = 1;
	}
	static void solve() {
		
		for(int i=0; i<n; i++) {
			
			visited = new boolean[n];
			cnt = 1;
			dfs(i);
			max = Math.max(max,  cnt);
			
		}
		out.println(max);
	}
	static void dfs(int i) {
		
		visited[i] = true;
		
		for(int cow: a[i]) {
			if(visited[cow]) continue;
			cnt++;
			dfs(cow);
		}
		
	}
	
}