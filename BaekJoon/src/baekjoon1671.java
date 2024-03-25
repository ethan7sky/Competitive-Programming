import java.util.*;
import java.io.*;

public class baekjoon1671 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, b[], j[];
	static boolean v[];
	static shark[] s;
	static ArrayList<Integer> a[];
	
	static class shark {
		int x, y, z;
		shark(int a, int b, int c) {
			x = a; y = b; z = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	}
	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		s = new shark[n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			s[i] = new shark(x, y, z);
		}
		
		a = new ArrayList[n+1];
		for(int i=1; i<=n; i++) a[i] = new ArrayList<Integer>();
		
		for(int i=1; i<n; i++) {
			for(int j=i+1; j<=n; j++) {
				
				if(s[i].x>=s[j].x && s[i].y>=s[j].y && s[i].z>=s[j].z)a[i].add(j);
				else if(s[i].x<=s[j].x && s[i].y<=s[j].y && s[i].z<=s[j].z)a[j].add(i);
				
			}
		}
		
		
		j = new int[n+1];
		v = new boolean[n+1];
		
	}
	static void solve() {
		
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<2; j++) {
				Arrays.fill(v,  false);;
				if(dfs(i)) cnt++;
			}
		}
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
