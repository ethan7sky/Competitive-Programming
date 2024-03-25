import java.util.*;
import java.io.*;

public class BaekJoon11724 {
	
	static ArrayList<Integer>[] a;
	static Scanner in;
	static int n, m, ans;
	static boolean[] v;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		solve();
	}
	static void init() {
		
		n = in.nextInt();
		m = in.nextInt();
		
		v = new boolean[n+1];
		
		
		a = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) a[i] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
	}
	static void solve() {
		
		for(int i=1; i<=n; i++) {
			if(!v[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
	static void dfs(int i) {
		
		v[i] = true;
		
		for(int j: a[i]) {
			if(!v[j]) dfs(j);
		}
	}
}
