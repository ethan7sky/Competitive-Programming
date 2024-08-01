import java.util.*;
import java.io.*;

public class CF538355A {
	
	static boolean inQueue[];
	static int dist[];
	static int cnt=0;
	static ArrayList<pair> adj[];
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n+1];
		for(int i=0; i<=n; i++) adj[i] = new ArrayList<pair>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new pair(v, w));
			adj[v].add(new pair(u, w));
		}
		
		SPFA(n, 1);
		
		System.out.println(cnt);
	}
	
	static void SPFA(int g, int s){
		PriorityQueue<pair> pq = new PriorityQueue<pair>(new comparator());
		dist = new int[g+1];
		inQueue = new boolean[g+1];
		for(int i=0; i<=g; i++) {
			dist[i] = Integer.MAX_VALUE;
			inQueue[i] = false;
		}
		dist[s] = 0;
		pq.add(new pair(s, 0));
		inQueue[s] = true;
		cnt=0;
		while(!pq.isEmpty()) {
			System.out.println(pq);
			pair u = pq.poll();
			System.out.println(u.node);
			System.out.println(Arrays.toString(inQueue));
			inQueue[u.node] = false;
			cnt++;
			for(pair v: adj[u.node]) {
				int d = dist[u.node] + v.weight;
				if(dist[v.node]> d) {
					System.out.println(v.node+" true");
					dist[v.node] = d;
					if(!inQueue[v.node]) {
						pq.add(new pair(v.node, d));
						inQueue[v.node] = true;
					}
				}
			}
		}
	}
	static class comparator implements Comparator<pair> {

		@Override
		public int compare(CF538355A.pair o1, CF538355A.pair o2) {
			// TODO Auto-generated method stub
			if(o1.weight==o2.weight) {
				return o2.node - o1.node;
			}
			return o1.weight - o2.weight;
		}
		
	}
	static class pair {
		int node, weight;
		public pair(int a, int b) {
			this.node = a;
			this.weight = b;
		}
		public String toString() {
			return node+" "+weight;
		}
	}
}
