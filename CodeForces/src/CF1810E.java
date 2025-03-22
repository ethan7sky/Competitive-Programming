import java.io.*;
import java.util.*;

public class CF1810E { //i quit cause DSU was the wrong ducking strategy

	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int T, N, M;
	static pair a[];
	static boolean v[];
	static ArrayList<pair> adj[];

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		while(T-->0 ){
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			a = new pair[N];
			v = new boolean[N];
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++){
				a[i] = new pair(Integer.parseInt(st.nextToken()), i);
				if(a[i].first==0) v[i] = true;
			}
			adj = new ArrayList[N];
			for(int i=0; i<N; i++) adj[i] = new ArrayList<pair>();

			for(int i=0; i<M; i++){
				st = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken())-1;
				// adj[from idx].add(new pair(monsterDanger of to, to idx));
				adj[u].add(new pair(a[v].first, v));
				adj[v].add(new pair(a[u].first, u));
			}
			
			Arrays.sort(a);
			for(int i=0; i<N; i++) Collections.sort(adj[i]);
			
//			System.out.println(Arrays.toString(a));
			
			UnionFind DSU = new UnionFind(N);
			
//			System.out.println(adj[1]);

			for(pair i: a) { //monsterDanger, idx
//				System.out.println("curr = "+i.toString());
//				if(DSU.componentSize(i.second)==1 && i.first != 0) {
//					
//				}
				for(pair c: adj[i.second]) { //monsterDanger of to, to
					
					if(v[i.second] && v[c.second]) {
						DSU.unify(i.second, c.second);
					} else if(v[i.second] && !v[c.second]) {
						if(DSU.componentSize(i.second) >= c.first) {
							DSU.unify(i.second, c.second);
							v[c.second] = true; 
						}
					} else if(!v[i.second] && v[c.second]) {
						if(DSU.componentSize(c.second) >= i.first) {
							DSU.unify(c.second, i.second);
							v[i.second] = true; 
						}
					}
					
					
					
//					System.out.println("adj to "+c.toString());
//					if((v[c.second] && DSU.componentSize(c.second) >= i.first) || ((!v[c.second]||v[i.second]) && DSU.componentSize(i.second) >= c.first)) {
//						if(!DSU.connected(i.second, c.second)) {
//							DSU.unify(i.second, c.second);
//							v[i.second] = true;
//							v[c.second] = true; 
////							System.out.println("           CONNECTED "+i.second+" "+c.second);
//						}
//					}
					
//					if(v[i.second]) {
//						if(DSU.componentSize(i.second) >= c.first) {
//							if(!v[c.second] && !DSU.connected(i.second, c.second)) {
//								DSU.unify(i.second, c.second);
//								v[c.second] = true;
//								System.out.println("           CONNECTED "+i.second+" "+c.second);
//							}
//						}
//					}
//					else {
//						if(DSU.componentSize(c.second)>= i.first && v[c.second]) {
//							DSU.unify(i.second, c.second);
//							v[i.second]= true; 
//						}
//					}
				}
//				System.out.println("num of components is now "+DSU.numComponents);
			}
			
//			System.out.println(DSU.numComponents);

			if(DSU.numComponents == 1) {
				sb.append("YES\n");
			} else sb.append("NO\n");
		}


		System.out.print(sb);

	}

	static class pair implements Comparable<pair> {
		int first, second;
		public pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		@Override
		public int compareTo(pair that) {
			return this.first - that.first;
		}
		@Override
		public String toString() {
			return first+" "+second;
		}
	}
	static class UnionFind {

		// The number of elements in this union find
		private int size;

		// Used to track the size of each of the component
		private int[] sz;

		// id[i] points to the parent of i, if id[i] = i then i is a root node
		private int[] id;

		// Tracks the number of components in the union find
		private int numComponents;

		public UnionFind(int size) {

			if (size <= 0) throw new IllegalArgumentException("Size <= 0 is not allowed");

			this.size = numComponents = size;
			sz = new int[size];
			id = new int[size];

			for (int i = 0; i < size; i++) {
			id[i] = i; // Link to itself (self root)
			sz[i] = 1; // Each component is originally of size one
			}
		}

		// Find which component/set 'p' belongs to, takes amortized constant time.
		public int find(int p) {

			// Find the root of the component/set
			int root = p;
			while (root != id[root]) root = id[root];

			// Compress the path leading back to the root.
			// Doing this operation is called "path compression"
			// and is what gives us amortized time complexity.
			while (p != root) {
			int next = id[p];
			id[p] = root;
			p = next;
			}

			return root;
		}

		// This is an alternative recursive formulation for the find method
		// public int find(int p) {
		//   if (p == id[p]) return p;
		//   return id[p] = find(id[p]);
		// }

		// Return whether or not the elements 'p' and
		// 'q' are in the same components/set.
		public boolean connected(int p, int q) {
			return find(p) == find(q);
		}

		// Return the size of the components/set 'p' belongs to
		public int componentSize(int p) {
			return sz[find(p)];
		}

		// Return the number of elements in this UnionFind/Disjoint set
		public int size() {
			return size;
		}

		// Returns the number of remaining components/sets
		public int components() {
			return numComponents;
		}

		// Unify the components/sets containing elements 'p' and 'q'
		public void unify(int p, int q) {

			// These elements are already in the same group!
			if (connected(p, q)) return;

			int root1 = find(p);
			int root2 = find(q);

			// Merge smaller component/set into the larger one.
			if (sz[root1] < sz[root2]) {
			sz[root2] += sz[root1];
			id[root1] = root2;
			sz[root1] = 0;
			} else {
			sz[root1] += sz[root2];
			id[root2] = root1;
			sz[root2] = 0;
			}

			// Since the roots found are different we know that the
			// number of components/sets has decreased by one
			numComponents--;
		}
	}
}
