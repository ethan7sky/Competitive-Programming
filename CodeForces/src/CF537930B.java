import java.util.*;
import java.io.*;

public class CF537930B {
	
	static HashSet<Integer> v;
	static int n, m;
	static BufferedReader in;
	static StringTokenizer st;
	static long[] minDist;
	static ArrayList<pair>[] adj;
	static PriorityQueue<pair> pq;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		minDist = new long[n+1];
		v = new HashSet<Integer>();
		adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) adj[i] = new ArrayList<pair>();
		Comparator<pair> cp = new comparator();
		pq = new PriorityQueue<pair>(cp);
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			adj[u].add(new pair(v, w));
			adj[v].add(new pair(u, w));
		}
		
		Arrays.fill(minDist, Long.MAX_VALUE);
		
		minDist[1] = 0;
		
		pq.add(new pair(1, 0));
		
		while(v.size() != n) {
//			System.out.println(pq);
//			System.out.println(pq.peek());
			if(pq.isEmpty()) break;
			pair node = pq.poll();
			if(v.contains(node.edge)) continue;
			v.add(node.edge);
			for(pair i: adj[node.edge]) {
				if(!v.contains(i.edge)) {
					minDist[i.edge] = Math.min(minDist[i.edge], minDist[node.edge]+i.weight);
					pq.add(new pair(i.edge, minDist[i.edge]));
				}
			}
		}
		
		sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			if(minDist[i]==Long.MAX_VALUE) {
				sb.append("-1 ");
			}
			else{
				sb.append(minDist[i]).append(" ");
			}
		}
		System.out.println(sb);
		
	}
//	static void dfs(int node) {
//		v[node] = true;
//		for(pair i: adj[node]) {
//			if(v[i.edge]) continue;
//			minDist[i.edge] = Math.min(minDist[i.edge],minDist[node]+i.weight);
//			dfs(i.edge);
//		}
//	}
	static class comparator implements Comparator<pair> {
		@Override
		public int compare(pair a, pair b) {
			if(a.weight < b.weight) return -1;
			if(a.weight > b.weight)return 1;
			return 0;
		}
	}
	
	static class pair implements Comparator<pair> {
		int edge;
		long weight;
		public pair(int a, long b) {
			this.edge = a;
			this.weight = b;
		}
		public String toString() {
			return edge+" "+weight;
		}
		@Override
		public int compare(pair a, pair b) {
			if(a.weight < b.weight) return -1;
			if(a.weight > b.weight)return 1;
			return 0;
		}
	}
}
