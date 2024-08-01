import java.util.*;
import java.io.*;

public class CF539266E {
	
	static int n, m;
	static ArrayList<edge> edges[];
	static edge allEdges[];
	static long sum;
	static long ans[];
	static UnionFind DSU;
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		DSU = new UnionFind(n);
		ans = new long[m];
		edges = new ArrayList[n+1];
		for(int i=1; i<=n; i++) edges[i] = new ArrayList<edge>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	static class edge implements Comparable<edge>{
		long weight;
		int from, to, idx;
		public edge(int a, long b, int c) {
			this.to = a;
			this.weight = b;
			this.idx = c;
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
