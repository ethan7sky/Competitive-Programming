import java.util.*;
import java.io.*;

public class CF539266C {
	
	static int n, m;
	static pair[] q;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static edge[] edges;
	static UnionFind DSU;
	static long[] ans;
	static long cnt;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		edges = new edge[n-1];
		q = new pair[m];
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(in.readLine());
			edges[i] = new edge(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<m; i++) {
			q[i] = new pair(Integer.parseInt(st.nextToken()), i);
		}
		
		Arrays.sort(edges);
		Arrays.sort(q);
		
		DSU = new UnionFind(n+1);
		
		ans = new long[m];
		
		int edgeIdx=0;
		cnt=0;
		
		for(pair query: q) {
			
			int queryVal = query.val;
			int ansIdx = query.idx;
			
			while(edgeIdx<n-1 && edges[edgeIdx].weight <= queryVal) {
				DSU.subtract(edges[edgeIdx].a);
				DSU.subtract(edges[edgeIdx].b);
				DSU.unify(edges[edgeIdx].a, edges[edgeIdx].b);
				DSU.add(edges[edgeIdx].a);
				edgeIdx++;
				//DSU.print();
			}
			ans[ansIdx] = cnt;
		}
		
		sb = new StringBuilder();
		for(long i: ans) sb.append(i).append(" ");
		System.out.println(sb);
		
	}
	
	
	
	static class UnionFind {
		private int size;
		private long[] sz;
		private int[] parent;
		private int numComponents;
		//private HashSet<Integer> parents;
		
		public UnionFind(int size) {
			
			this.size = numComponents = size;
			sz = new long[size];
			parent = new int[size];
			
			for(int i=0; i<size; i++) {
				parent[i] = i;
				sz[i] = 1;
			}
		}
		public void print() {
			System.out.println(Arrays.toString(sz));
			System.out.println(Arrays.toString(parent));
			System.out.println(cnt);
			System.out.println();
		}
		
		public void subtract(int p) {
			p = find(p);
			cnt -= (long)(sz[p])*(sz[p]-1)/2;
		}
		public void add(int p) {
			p = find(p);
			cnt += (long)(sz[p])*(sz[p]-1)/2;
		}
		
//		public long findPairs() {
//			long ans=0;
//			for(int i=0; i<size; i++) {
//				if(find(i) == parent[i]) {
//					ans += (long)sz[i]*(sz[i]-1)/2;
//				}
//			}
//			return ans;
//		}
		
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
		
		public long componentSize(int p) {
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
//				if(parents.contains(root1)) parents.remove(root1);
//				parents.add(root2);
			} 
			else {
				sz[root1] += sz[root2];
				parent[root2] = root1;
//				if(parents.contains(root2)) parents.remove(root2);
//				parents.add(root1);
			}
			
			numComponents--;
		}
	}
	static class pair implements Comparable<pair> {
		int val, idx;
		public pair(int a, int b) {
			this.val = a;
			this.idx = b;
		}
		@Override
		public int compareTo(pair that) {
			return this.val-that.val;
		}
	}
	static class edge implements Comparable<edge> {
		int a, b, weight;
		public edge(int x, int y, int z) {
			this.a = x;
			this.b = y;
			this.weight = z;
		}
		@Override
		public int compareTo(edge that) {
			return this.weight - that.weight;
		}
	}
	
}
