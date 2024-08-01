import java.util.*;
import java.io.*;

public class CF538135B3 {
	
	static long[] minDist;
	static int[] parent;
	static long[] incomingEdge;
	static ArrayList<pair> adj[];
	static node[] edges;
	static int n, m, u;
	static long ans;
	static PriorityQueue<pair> pq;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		minDist = new long[n+1];
		Arrays.fill(minDist, Long.MAX_VALUE);
		parent = new int[n+1];
		for(int i=0; i<=n; i++) parent[i] = i;
		incomingEdge = new long[n+1];
		Arrays.fill(incomingEdge, Long.MAX_VALUE);
		adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) adj[i] = new ArrayList<pair>();
		edges = new node[m];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			adj[a].add(new pair(b, w));
			adj[b].add(new pair(a, w));
			edges[i] = new node(a, b, w);
		}
		
		u = Integer.parseInt(in.readLine());
		
		minDist[u] = 0;
		incomingEdge[u] = 0;
		pq = new PriorityQueue<pair>(new comparator());
		pq.add(new pair(u, 0));
		
		while(!pq.isEmpty()) {
			
			pair curr = pq.poll();
			
			if(adj[curr.node].isEmpty()) continue;
			
			for(pair i: adj[curr.node]) {
				int next = i.node;
				long newWeight = curr.weight+i.weight;
				
				if(newWeight < minDist[next]) {
					parent[next] = curr.node;
					minDist[next] = newWeight;
					incomingEdge[next] = i.weight;
					pq.add(new pair(next, newWeight));
				}
				else if(newWeight == minDist[next]) {
					if(incomingEdge[next] > i.weight) {
						incomingEdge[next] = i.weight;
						parent[next] = curr.node;
					}
				}
				//System.out.println(Arrays.toString(incomingEdge));
			}
		}
		sb = new StringBuilder();
		ans=0;
		for(int i=1; i<=n; i++) {
			ans += incomingEdge[i];
		}
		sb.append(ans).append("\n");
		
		for(int i=0; i<m; i++) {
			int a = edges[i].from;
			int b = edges[i].to;
			if(parent[a]==b||parent[b]==a) sb.append(i+1).append(" ");
		}
		System.out.println(sb);
		
	}
	
	
	
	
	
	static class pair {
		int node;
		long weight;
		public pair(int a, long b) {
			this.node = a;
			this.weight = b;
		}
	}
	static class comparator implements Comparator<pair> {
		@Override
		public int compare(pair a, pair b) {
			if(a.weight < b.weight) return -1;
			if(a.weight > b.weight)return 1;
			return 0;
		}
	}
	static class node {
		int from, to;
		long weight;
		public node(int a, int b, long c) {
			this.from = a;
			this.to = b;
			this.weight = c;
		}
	}
}
