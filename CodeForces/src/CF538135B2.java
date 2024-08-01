import java.util.*;
import java.io.*;

public class CF538135B2 {
	
	static HashSet<Integer> v;
	static int n, m, u;
	static BufferedReader in;
	static StringTokenizer st;
	static long[] minDist;
	static ArrayList<pair>[] adj;
	static PriorityQueue<pair> pq;
	static StringBuilder sb;
	static node dists[];
	static HashSet<String> removed;
	static long sum;
	
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
			sum += w;
		}
		
		Arrays.fill(minDist, Long.MAX_VALUE);
		
		u = Integer.parseInt(in.readLine());
		
		minDist[u] = 0;
		
		pq.add(new pair(u, 0));
		
		while(v.size() != n) {
//			System.out.println(pq);
//			System.out.println(pq.peek());
			if(pq.isEmpty()) break;
			pair node = pq.poll();
			if(v.contains(node.edge)) continue;
			v.add(node.edge);
			for(pair i: adj[node.edge]) {
				if(!v.contains(i)) {
					minDist[i.edge] = Math.min(minDist[i.edge], minDist[node.edge]+i.weight);
					pq.add(new pair(i.edge, minDist[i.edge]));
				}
			}
		}
		
		sb = new StringBuilder();
		for(int i=0; i<=n; i++) {
			if(minDist[i]==Long.MAX_VALUE) {
				sb.append("-1 ");
			}
			else{
				sb.append(minDist[i]).append(" ");
			}
		}
		System.out.println(sb);
		
		System.out.println(sum);
		
		//if same dist weight, remove most recently added from dijkstras
		
		removed = new HashSet<String>();
		

		node temp[] = new node[n];
		for(int i=1; i<=n; i++) {
			if(i==u) temp[i-1] = new node(i, 0);
			temp[i-1] = new node(i, minDist[i]);
		}
		Arrays.sort(temp);
		dists = new node[n+1];
		for(int i=0; i<n; i++) dists[i+1] = temp[i];
		dists[0] = new node(0, 0);
		System.out.println(Arrays.toString(dists));
		removeEdges();
		
		System.out.println(sum);
		
	}
	static void removeEdges() {
		
		for(node i: dists) {
			if(i.idx==0) continue;
			long currMinDist = i.minDist;			
			for(pair j: adj[i.idx]) {
				if(removed.contains(i.idx+" "+j.edge))continue; 
				if(minDist[j.edge] + j.weight > currMinDist) {
					//can remove
					
					long minDistWithout = Long.MAX_VALUE;
					for(pair k: adj[j.edge]) {
						if(k.edge == i.idx) continue;
						minDistWithout = Math.min(minDistWithout, minDist[k.edge]+k.weight);
					}
					if(minDistWithout == minDist[j.edge]) {
						sum -= j.weight;
						removed.add(i.idx+" "+j.edge);
						removed.add(j.edge+" "+i.idx);
						System.out.println(i.idx+" "+j.edge);
					}
				}
			}
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
	
	static class node implements Comparable<node> {
		int idx;
		long minDist;
		public node(int x, long y){
			this.idx = x;
			this.minDist = y;
		}
		@Override
		public int compareTo(node a) {
			if(this.minDist < a.minDist)return 1;
			if(this.minDist > a.minDist)return -1;
			return 0;
		}
		public String toString() {
			return idx+" "+minDist;
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
