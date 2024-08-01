import java.util.*;
import java.io.*;

public class CF537930C {
	
	static int n, q;
	static int M = 20; // 2*(int)1e5+1;
	static ArrayList<Integer>[] adj;
	static boolean v[];
	static BufferedReader in;
	static StringTokenizer st;
	static int Euler[];// = new int[2*M];
	static int depth[];// = new int[2*M];
	static int last[];// = new int[M];
	static StringBuilder sb;
	static int segtree[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) adj[i] = new ArrayList<Integer>();
		
		v = new boolean[n+1];
		Euler = new int[2*n-1];
		depth = new int[2*n-1];
		last = new int[n+1];
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		oilerTour(1, 0);
		System.out.println(Arrays.toString(Euler));
		System.out.println(Arrays.toString(depth));
//		for(int i=0; i<2*n-1; i++) {
//			System.out.println(Euler[i]+" "+depth[i]);
//		}
		
		idx = 0;
		Arrays.fill(v, false);
		init_segtree();
		
		
		sb = new StringBuilder();
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ans = find_lca(0, 2*n-1, last[a], last[b], 0);
		}
		
	}
	
	static void init_segtree() {
		int x = (int) Math.ceil(Math.log(2*n-1)/Math.log(2));
		int max_size = 2*(int) Math.pow(2, x) - 1;
		segtree = new int[max_size];
		makeST(0, 2*n-2, 0);
	}
	static int makeST(int ss, int se, int si) {
		if(ss==se) {
			segtree[si] = Euler[ss];
			return Euler[ss];
		}
		int mid = (ss+se)/2;
		segtree[si] = Math.min(makeST(ss, mid, si*2+1), makeST(mid+1, se, si*2+2));
		return segtree[si];
	}
	
	static int find_lca(int ss, int se, int l, int r, int index) {
		if(l <= ss && r >= se) {
			return 
		}
	}
	
	
	
	static int idx = 0;
	static void oilerTour(int node, int d) {
		v[node] = true;
		Euler[idx] = node;
		depth[idx] = d;
		last[node] = idx;
		idx++;
		System.out.println("here " +Arrays.toString(depth));
		for(int i: adj[node]) {
			if(!v[i]) {
				oilerTour(i, d+1);
				Euler[idx] = node;
				depth[idx] = d;
				last[node] = idx;
				idx++;
				System.out.println(Arrays.toString(depth));
			}
		}
	}
}
