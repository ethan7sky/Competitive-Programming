import java.util.*;
import java.io.*;

public class USACOBarnTree {
	
	static int n, h, a[], ans;
	static BufferedReader in;
	static StringTokenizer st;
	static nodes b[];
	static boolean v[];
	static HashSet<Integer> adj[];
	static int depths[], parents[];
	static long avg=0L;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		a = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			avg += a[i];
		}
		avg /= n;
		for(int i=0; i<n; i++) a[i] -= avg;
		
		adj = new HashSet[n];
		for(int i=0; i<n; i++) adj[i] = new HashSet<Integer>();
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			adj[x].add(y);
			adj[y].add(x);
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(adj[i]);
		}

		depths = new int[n];
		parents = new int[n];
		dfs(0, 0, 0);
//		for(int i=0; i<n; i++) {
//			for(int j=i; j<n; j++) {
//				if(adj[j].contains(i)) {
//					depth[j] = depth[i] + 1;
//					parents[j] = i;
//				}
//			}
//		}
		
		System.out.println(Arrays.toString(parents));

		b = new nodes[n];
		for(int i=0; i<n; i++) {
			b[i] = new nodes(i, depths[i]);
		}
		
		Arrays.sort(b);
		
		v = new boolean[n];
		sb = new StringBuilder();
		for(nodes i: b) {
			if(a[i.node]==0) continue;
			
			int newidx = parents[i.node];
			a[newidx] += a[i.node];
			
			if(a[i.node]>0) 
				sb.append(i.node+1+" "+(newidx+1)+" "+a[i.node]);
			else 
				sb.append(newidx+1+" "+(i.node+1)+" "+-a[i.node]);
			
			a[i.node] = 0; 
			
			sb.append("\n");
			ans++;
			
			
			v[i.node] = true; 
		}
	}
	static void dfs(int prev, int curr, int depth) {
		parents[curr] = prev;
		depths[curr] = depth;
		
		for(int i: adj[curr]) {
			if(i==prev) continue;
			dfs(curr, i, depth+1);
		}
	}
	
	static class nodes implements Comparable<nodes> {

		int node, depth;
		nodes(int n, int d){
			node = n;
			depth = d;
		}
		
		public String toString() {
			return node+" "+depth;
		}
		
		@Override
		public int compareTo(USACOBarnTree.nodes o) {
			// TODO Auto-generated method stub
			return o.depth-this.depth;
		}
		
	}
	
}
