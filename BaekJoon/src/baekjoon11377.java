import java.util.*;
import java.io.*;

public class baekjoon11377 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, k, s, b[];
	static boolean v[];
	static ArrayList<Integer>[] a;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		
		a = new ArrayList[n+1];
		for(int i=0; i<=n ;i++) a[i] = new ArrayList<Integer>();
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(in.readLine());
			s = Integer.parseInt(st.nextToken());
			for(int j=0; j<s; j++) {
				a[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		b = new int[m+1];
		v = new boolean[m+1];
		
	}
	static void solve() {
		
		int cnt = 0;
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<2; j++) {
				Arrays.fill(v,  false);
				if(dfs(i)) cnt++;
			}
		}
		int z = 0;
		for(int i=1; i<=n && z<k; i++) {
			Arrays.fill(v, false);
			if(dfs(i)) z++;
		}
		System.out.println(cnt+z);
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
