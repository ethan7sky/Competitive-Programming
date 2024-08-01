import java.util.*;
import java.io.*;

public class CF539266B {
	
	static int n;
	static long[][] a, minDist;
	static UnionFind DSU;
	static ArrayList<edge> adj[];
	static edge edges[];
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		a = new long[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		edges = new edge[(int)n*(n-1)/2];
		int idx=0;
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				if(a[i][j] != a[j][i]) {
					System.out.println("NO");
					return;
				}
				if(i==j) {
					if(a[i][j]!=0) {
						System.out.println("NO");
						return;
					}
				}
				else {
					if(a[i][j] <= 0) {
						System.out.println("NO");
						return;
					}
					edges[idx] = new edge(a[i][j], i, j);
					idx++;
				}
				
			}
		}
		//System.out.println(Arrays.toString(edges));

		adj = new ArrayList[n];
		for(int i=0; i<n; i++) adj[i] = new ArrayList<edge>();
		Arrays.sort(edges);
		DSU = new UnionFind(n);
		for(edge i: edges) {
			if(!DSU.connected(i.from, i.to)) {
				adj[i.from].add(new edge(i.weight, i.to));
				adj[i.to].add(new edge(i.weight, i.from));
				DSU.unify(i.from, i.to);
			}
		}
		
		minDist = new long[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(minDist[i], Long.MAX_VALUE);
		}
		
		for(int i=0; i<n; i++) {
			dfs(i, -1, 0, i);
		}
		
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				if(a[i][j] != minDist[i][j]) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
		return;
		
	}
	static void dfs(int node, int parent, long dist, int root) {
		minDist[root][node] = Math.min(minDist[root][node], dist);
		for(edge i: adj[node]) {
			if(i.to==parent) continue;
			dfs(i.to, node, dist+i.weight, root);
		}
	}
	
	
	static class edge implements Comparable<edge>{
		long weight;
		int from, to;
		public edge(long a, int b) {
			this.weight = a;
			this.to = b;
		}
		public edge(long a, int b, int c) {
			this.weight = a;
			this.from = b;
			this.to = c;
		}
		@Override
		public int compareTo(edge that) {
			if(this.weight > that.weight) return 1;
			if(this.weight < that.weight)return -1;
			return 0;
		}
		public String toString() {
			return weight+" "+from+" "+to;
		}
	}
	
	static class UnionFind {	
		private int size;
		private int[] sz;
		private int[] parent;
		private int numComponents;
		
		public UnionFind(int size) {
			
			this.size = numComponents = size;
			sz = new int[size];
			parent = new int[size];
			
			for(int i=0; i<size; i++) {
				parent[i] = i;
				sz[i] = 1;
			}
		}
		public int find(int p) {
			
			int root = p;
			while(root != parent[root]) {
				root = parent[root];
			}
			
			while(p!=root) {
				int to = parent[p];
				parent[p] = root;
				p = to;
			}
			return root;
		}
		
		public int recursiveFind(int p) {
			if(p==parent[p]) return p;
			else return parent[p] = recursiveFind(parent[p]);
		}
		
		public boolean connected(int p, int q) {
			return find(p) == find(q);
		}
		
		public int componentSize(int p) {
			return sz[find(p)];
		}
		
		public int size() {
			return size;
		}
		
		public int components() {
			return numComponents;
		}
		
		public void unify(int p, int q) {
			
			int root1 = find(p);
			int root2 = find(q);
			
			if(root1==root2) return;
			
			if(sz[root1] < sz[root2]) {
				sz[root2] += sz[root1];
				parent[root1] = root2;
			} 
			else {
				sz[root1] += sz[root2];
				parent[root2] = root1;
			}
			
			numComponents--;
		}
	}

}
