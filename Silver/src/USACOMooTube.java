import java.util.*;
import java.io.*;

public class USACOMooTube {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, q, k, v, min[];
	static int a[][];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader("mootube.in"));
		//out = new PrintWriter("mootube.out");
		init();
		solve();
		in.close();
		//out.close();
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		a = new int[n+1][n+1];
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			a[P][Q] = R;
			a[Q][P] = R;
		}
	}
	static void solve() throws  IOException {
		
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(in.readLine());
			k = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			min = new int[n+1];
			Arrays.fill(min, 1000000001);
			dfs(v);
			int cnt=0;
			for(int j=1; j<n+1; j++) 
				if(min[j]!=1000000001 && min[j]>=k) cnt++;
			out.println(cnt);
		}
	}
	static void dfs(int i) {
		
		for(int j: a[i]) {
			if(j==0) continue;
			if(j)
		}
		
		for(String s: a[i]) {
			st = new StringTokenizer(s);
			int video = Integer.parseInt(st.nextToken());
			int relevance = Integer.parseInt(st.nextToken());
			
			if(relevance > min[video]) continue;
			min[video] = relevance;
			dfs(video);
		}
	}
	
}
