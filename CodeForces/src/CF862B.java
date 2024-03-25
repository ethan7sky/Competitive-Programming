import java.util.*;
import java.io.*;

public class CF862B {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, node[];
	static ArrayList<Integer>[] a;
	static boolean v[];
	
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());
		a = new ArrayList[n+1];
		Arrays.setAll(a, i->new ArrayList<Integer>());
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x].add(y);
			a[y].add(x);
		}
		node = new int[n+1];
	}
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	}
	static void solve() {
		
		for(int i=1; i<=n; i++) {
			if(node[i]==0) {
				node[i] = 1;
				bfs(i);
			}
		}
		
		long pos = 0l, neg = 0l;
		for(int i=1; i<=n; i++) {
			if(node[i]==1) pos++;
			else neg++;
		}
		long total = pos*neg;
		System.out.println(total - (n-1));
	}
	
	static void bfs(int i) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		v = new boolean[n+1];
		q.add(i);
		v[i] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int next: a[curr]) {
				if(v[next]) continue;
				v[next] = true;
				
				if(node[next] == 0) {
					node[next] = node[curr]*-1;
					q.add(next);
				}
			}
		}
	}
}
