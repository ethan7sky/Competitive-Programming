import java.util.*;
import java.io.*;

public class USACOConnectingTwoBarns {
	
	
	static BufferedReader in;
	static StringTokenizer st;
	static int t, m, n;
	//static boolean v1[], v2[], nreached;
	static HashSet<Integer> v1, v2;
	static ArrayList[] paths;
	static StringBuilder sb;
	
	static class Pair {
		
		int x, y;
		public Pair(int a, int b) {
			this.x = a;
			this.y = b;
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		
		while(t-->0) {
			
			init();
			solve();
		}
		System.out.print(sb);
		
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		paths = new ArrayList[n+1];
		for(int i=0; i<=n; i++) paths[i] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			paths[x].add(y);
			paths[y].add(x);
		}
		
//		v1 = new boolean[n+1];
//		v2 = new boolean[n+1];
//		nreached = false;
		
		v1 = new HashSet<Integer>();
		v2 = new HashSet<Integer>();
		
	}
	static void solve() {
		
		dfs(1, true);
		
		if(v1.contains(n)) {
			sb.append("0\n");
			return;
		}
		
		dfs(n, false);
		
		System.out.println(v1);
		System.out.println(v2);
		
		
//		int lastv1idx = 0;
//		int lastv2idx = n;
//		int min = n;
//		
//		for(int i=0; i<=n; i++) {
//			
//			if(v1[i]) lastv1idx = i;
//			else if(v2[i]) lastv2idx = i;
//			min = Math.min(min, Math.abs(lastv1idx-lastv2idx));
//			
//		}
//		sb.append(min).append("\n");
//		
	}
	
	static void dfs(int idx, boolean start0) {
		
		if(start0&&v1.contains(idx)) return;
		if(!start0&&v2.contains(idx)) return;
		
		if(start0) v1.add(idx);
		else v2.add(idx);
		
		ArrayList<Integer> temp = paths[idx];
		for(int i: temp) {
			dfs(i, start0);
		}
	}
	
	
}
