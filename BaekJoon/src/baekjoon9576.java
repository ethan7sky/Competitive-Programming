import java.util.*;
import java.io.*;

public class baekjoon9576 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int t, n, m, b[];
	static boolean v[];
	static int a[][];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			init();
			solve();
		}
	}
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[m+1][2];
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(in.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		
		b = new int[n+1];
		v = new boolean[n+1];
		
	}
	static void solve() {
		
		int cnt = 0;
		for(int i=1; i<=m; i++) {
			Arrays.fill(v, false);
			if(dfs(i)) cnt++;
		}
		System.out.println(cnt);
	}
	static boolean dfs(int x) {
		
		for(int i=a[x][0]; i<=a[x][1]; i++) {
			if(v[i]) continue;
			v[i] = true;
			if(b[i]==0 || dfs(b[i])) {
				b[i] = x;
				return true;
			}
		}
		return false;
	}
}
