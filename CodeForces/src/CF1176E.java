import java.util.*;
import java.io.*;

public class CF1176E {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int t, n, m;
	static ArrayList<Integer>[] a;
	static boolean v[], chosen[];
	static StringBuilder res;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		res = new StringBuilder();
		
		while(t-->0) {
			init();
			solve();
		}
		System.out.print(res);
		
	}
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[n+1];
		for(int i=0; i<=n; i++) 
			a[i] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x].add(y);
			a[y].add(x);
		}
		chosen = new boolean[n+1]; //rmbr not to count index 0
		v = new boolean[n+1];
	}
	static void solve() {
		
		dfs(1, true);
		int cnt0 = 0;
		StringBuilder sb0 = new StringBuilder();
		int cnt1 = 0;
		StringBuilder sb1 = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			if(chosen[i]) {
				cnt1++;
				sb1.append(i).append(" ");
			}
			else {
				cnt0++;
				sb0.append(i).append(" ");
			}
		}
		if(cnt1<cnt0) {
			res.append(cnt1).append("\n").append(sb1).append("\n");
		}
		else {
			res.append(cnt0).append("\n").append(sb0).append("\n");
		}
	}
	static void dfs(int idx, boolean choose) {
		if(v[idx]) return;
		v[idx] = true;
		chosen[idx] = choose;
		for(int i: a[idx]) {
			dfs(i, !choose);
		}
	}
}
