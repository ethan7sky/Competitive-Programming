import java.util.*;
import java.io.*;

public class USACOBessiesInterview2 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, a[];
	static boolean works[];
	static PriorityQueue<pair> pq = new PriorityQueue<pair>(new comp());
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Integer>> events = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		a = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			if(i<K) {
				pq.add(new pair(a[i], i));
			}
		}
		
		int currIdx = K;
		while(currIdx<N && !pq.isEmpty()) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			pair curr = pq.poll();
			temp.add(curr.idx);
			while(!pq.isEmpty() && pq.peek().time==curr.time) {
				temp.add(pq.poll().idx);
			}
			if(temp.size()>1) {
				events.add(temp);
			}
			
			for(int idx: temp) {
				if(currIdx<N) {
					pq.add(new pair(curr.time+a[currIdx], idx));
					currIdx++;
				}
			}
		}
		long ansTime = pq.peek().time;
		sb.append(ansTime).append("\n");
		
		works = new boolean[K];
		while(pq.peek().time == ansTime) {
			works[pq.poll().idx] = true; 
		}
		
		for(int i=events.size()-1; i>=0; i--) {
			ArrayList<Integer> curr = events.get(i);
			boolean work = false;
			for(int idx: curr) {
				work |= works[idx];
			}
			for(int idx: curr) {
				works[idx] |= work;
			}
		}
		
		for(boolean k: works) {
			sb.append(k? 1:0);
		}
		
		System.out.println(sb);	
		
		
	}

	static class comp implements Comparator<pair> {
		public int compare(pair a, pair b) {
			if(a.time > b.time) return 1;
			else if(a.time==b.time) return 0;
			return -1;
		}
	}
	
	static class pair {
		long time;
		int idx;
		public pair(long time, int idx) {
			this.time = time;
			this.idx = idx;
		}
		@Override
		public String toString() {
			return time+" "+idx;
		}
	}
}
