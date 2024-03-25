import java.util.*;
import java.io.*;

public class baekjoon1298 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, b[];
	static boolean v[];
	static ArrayList<Integer> a[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	}
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(in.readLine());
			a[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		for(int i=1; i<=n; i++) {
			a[i].sort(Comparator.naturalOrder());
		}
		
		b = new int[n+1];
		v = new boolean[n+1];
		
	}
	static void solve() {
		
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			Arrays.fill(v, false);
			if(dfs(i)) cnt++;
		}
		System.out.println(cnt);
	}
	static boolean dfs(int x) {
		
		for(int i:a[x]) { 
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
