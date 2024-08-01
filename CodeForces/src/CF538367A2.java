import java.util.*;
import java.io.*;

public class CF538367A2 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int t, nodeCnt, pathCnt, mtCnt;
	static int mt[], cleaningRobotCnt[];
	static ArrayList<pair> adj[];
	static long[] minDist; 
	static PriorityQueue<pair> pq;
	static HashSet<Integer> v;
	static HashMap<Integer, ArrayList<Long>> firstSeen;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		while(t-->0) {
			st = new StringTokenizer(in.readLine());
			nodeCnt = Integer.parseInt(st.nextToken());
			pathCnt = Integer.parseInt(st.nextToken());
			mtCnt = Integer.parseInt(st.nextToken());
			
			
			minDist = new long[nodeCnt+1];
			mt = new int[mtCnt];
			cleaningRobotCnt = new int[nodeCnt+1];
			
			st = new StringTokenizer(in.readLine());
			for(int i=0;i < mtCnt; i++) {
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
			
			Arrays.fill(minDist, Long.MAX_VALUE);
			pq = new PriorityQueue<pair>(new comparator());
			
			firstSeen = new HashMap<Integer, ArrayList<Long>>();
			for(int i: mt) {
				minDist[i] = 0;
				pq.add(new pair(i, 0));
				cleaningRobotCnt[i] = 0;
			}
			
//			System.out.println(Arrays.toString(adj));
			
			
			while(!pq.isEmpty()) {
				
				
				
//				System.out.println(pq);
//				System.out.println(Arrays.toString(cleaningRobotCnt));
//				System.out.println(Arrays.toString(minDist));
				
				pair curr = pq.poll();

				if(v.contains(curr.node)) continue;
				
				if(cleaningRobotCnt[curr.node]>0) {
					cleaningRobotCnt[curr.node]--;
					continue;
				}
				
				v.add(curr.node);
				minDist[curr.node] = Math.min(minDist[curr.node], curr.weight); 
				
				for(pair i: adj[curr.node]) {
					if(!v.contains(i.node)) {;
						pq.add(new pair(i.node, minDist[curr.node]+i.weight));
//						if(minDist[curr.node]+i.weight < minDist[i.node]) {
//							minDist[i.node] = minDist[curr.node]+i.weight; 
//							pq.add(new pair(i.node, minDist[i.node]));
//						}
					}
				}
			}
			if(minDist[1] == Long.MAX_VALUE) sb.append("-1\n");
			else sb.append(minDist[1]).append("\n");
		}
		System.out.print(sb);
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
		int node;
		long weight;
		public pair(int a, long b) {
			this.node = a;
			this.weight = b;
		}
		public String toString() {
			return node+" "+weight;
		}
	}
}
