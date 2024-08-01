import java.util.*;
import java.io.*;
public class CF538367A {
	static int t, nodeCnt, pathCnt, mtCnt;
	static int mt[], cleaningRobotCnt[];
	static ArrayList<pair> adj[];
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static PriorityQueue<pair> pq;
	static long[] maxDist;
	static ArrayList<Long>[] mtVals;
	static HashSet<Integer> v;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			st = new StringTokenizer(in.readLine());
			nodeCnt = Integer.parseInt(st.nextToken());
			pathCnt = Integer.parseInt(st.nextToken());
			mtCnt = Integer.parseInt(st.nextToken());
			maxDist = new long[nodeCnt+1];
			mt = new int[mtCnt];
			cleaningRobotCnt = new int[nodeCnt+1];
			
			st = new StringTokenizer(in.readLine());
			for(int i=0;i <mtCnt; i++) {
				mt[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(in.readLine());
			for(int i=1; i<=nodeCnt; i++) {
				cleaningRobotCnt[i] = Integer.parseInt(st.nextToken());
			}
			
			adj = new ArrayList[nodeCnt+1];
			for(int i=0; i<=nodeCnt; i++) adj[i] = new ArrayList<pair>();
			
			for(int i=0; i<pathCnt; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				adj[a].add(new pair(b, w));
				adj[b].add(new pair(a, w));
			}
			v = new HashSet<Integer>();
			
			Arrays.fill(maxDist, -1);
			
			maxDist[1] = 0;
			pq.add(new pair(1, 0));
			
			while(v.size() != nodeCnt) {
				
				if(pq.isEmpty()) break;
				pair curr = pq.poll();
				
				if(v.contains(curr.node)) continue;
				v.add(curr.node);
				
				if(adj[curr.node].size() <= cleaningRobotCnt[curr.node]) continue; 
				for(pair i: adj[curr.node]) {
					if(!v.contains(i.node)) {
						maxDist[i.edge] 
					}
				}
			}
			
		}
	}
	static class comparator implements Comparator<pair> {
		@Override
		public int compare(pair a, pair b) {
			if(a.weight < b.weight) return -1;
			if(a.weight > b.weight) return 1;
			return 0;
		}
	}
	
	
	static class pair {
		int node, weight;
		public pair(int a, int b) {
			this.node = a;
			this.weight = b;
		}
	}
}
