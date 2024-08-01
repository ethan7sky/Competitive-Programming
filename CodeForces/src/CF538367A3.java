import java.util.*;
import java.io.*;

public class CF538367A3 {
	
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
			
			Arrays.fill(minDist, Long.MAX_VALUE);
			pq = new PriorityQueue<pair>(new comparator());
			
			firstSeen = new HashMap<Integer, ArrayList<Long>>();
			for(int i: mt) {
				minDist[i] = 0;
				//pq.add(new pair(i, 0));
				v.add(i);
				for(pair j: adj[i]) {
					//pq.add(new pair(j.node, j.weight));
					if(!firstSeen.containsKey(j.node)) {
						firstSeen.put(j.node, new ArrayList<Long>());
					}
					firstSeen.get(j.node).add(j.weight);
				}
			}
			for(int i: firstSeen.keySet()) {
				if(v.contains(i)) continue;
				Collections.sort(firstSeen.get(i));
				for(long j: firstSeen.get(i)) {
					if(cleaningRobotCnt[i]>0) cleaningRobotCnt[i]--;
					else {
						pq.add(new pair(i, j));
						minDist[i] = j;
						break;
					}
				}
			}
			
			
			while(!pq.isEmpty()) {
				
//				System.out.println(pq);
//				System.out.println(Arrays.toString(cleaningRobotCnt));
//				System.out.println(Arrays.toString(minDist));
				
				pair curr = pq.poll();
				
				if(v.contains(curr.node)&&minDist[curr.node]!=0) continue;
				v.add(curr.node);
				
				for(pair i: adj[curr.node]) {
					if(!v.contains(i.node)) {
						if(cleaningRobotCnt[i.node]>0) {
							cleaningRobotCnt[i.node]--;
							continue;
						}
						minDist[i.node] = Math.min(minDist[curr.node]+i.weight, minDist[i.node]);
						pq.add(new pair(i.node, minDist[i.node]));
//						if(minDist[curr.node]+i.weight < minDist[i.node]) {
//							minDist[i.node] = minDist[curr.node]+i.weight; 
//							pq.add(new pair(i.node, minDist[i.node]));
//						}
					}
				}
			}
			if(!v.contains(1)) sb.append("-1\n");
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
