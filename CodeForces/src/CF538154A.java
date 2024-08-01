import java.util.*;
import java.io.*;

public class CF538154A {

	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;

	static int n, m;
	static int donut[];
	static ArrayList<pair>[] adj;
	static long[] minDist;
	static long[][] construct;
	static HashSet<Integer> v;
	static PriorityQueue<pair> pq;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		donut = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			donut[i] = Integer.parseInt(st.nextToken());
		}
		
		int k = (int)donut[0];
		
		adj = new ArrayList[k];
		for(int i=0; i<k; i++) adj[i] = new ArrayList<pair>();
		
		
		for(int i=0; i<k; i++) {
			
			for(int j=1; j<n; j++) {
				int from = i;
				int to = i+donut[j];
				to %= k;
				adj[from].add(new pair(to, donut[j], j));
			}
		}
		
		minDist = new long[k];
		construct = new long[k][n];
		
		v = new HashSet<Integer>();
		
		pq = new PriorityQueue<pair>(new comparator());
		
		Arrays.fill(minDist, Long.MAX_VALUE);
		
		minDist[0] = 0;
		long[] temp = new long[n];
		pq.add(new pair(0, 0, temp));
		
		while(v.size()!=k) {
			
			if(pq.isEmpty()) break;			
			pair node = pq.poll();
			
			if(v.contains(node.edge)) continue;
			v.add(node.edge);
			
			for(pair i: adj[node.edge]) {
				if(!v.contains(i.edge)) {
					long[] temp2 = node.copy.clone();
					if(minDist[node.edge]+i.weight < minDist[i.edge]) {
						minDist[i.edge] =  minDist[node.edge]+i.weight;
						temp2[i.type]++;
						
						construct[i.edge] = temp2.clone(); 
						pq.add(new pair(i.edge, minDist[i.edge], temp2));
					}
				}
			}
		}

//		System.out.println(Arrays.toString(minDist));
//		
//		for(int i=0; i<k; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(construct[i][j]);
//			}System.out.println();
//		}System.out.println();
		
		
		
		//solve
		
		sb = new StringBuilder();
		
		int q = Integer.parseInt(in.readLine());
		while(q-->0) {
			long x = Long.parseLong(in.readLine());
			int mod = (int)(x%(long)(k));
			if(minDist[mod] <= x) {
				sb.append(1).append("\n");
				long amt = (long)(x-minDist[mod])/k;
				sb.append(amt).append(" ");
				for(int i=1; i<n; i++) {
					sb.append(construct[mod][i]).append(" ");
				}
				sb.append("\n");
			}
			else {
				sb.append("0\n");
				for(int i=0; i<n; i++) {
					sb.append("0 ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
		
		
		
		
	}

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
		int type;
		long[] copy;
		public pair(int a, long b, int c) {
			this.edge = a;
			this.weight = b;
			this.type = c;
		}
		public pair(int a, long b, long[] d) {
			this.edge = a;
			this.weight = b;
			this.copy = d.clone();
		}
		public String toString() {
			return edge+" "+weight+" "+type;
		}
		@Override
		public int compare(pair a, pair b) {
			if(a.weight < b.weight) return -1;
			if(a.weight > b.weight)return 1;
			return 0;
		}
	}
}
