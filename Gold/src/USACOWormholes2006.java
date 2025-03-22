import java.util.*;
import java.io.*;

public class USACOWormholes2006 {
	
	static int T, N, M, W;
	static BufferedReader in;
	static StringTokenizer st;
	static ArrayList<edge> adj[];
	static Queue<Integer> queue;
	static int time[], len[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		while(T-->0) {
			
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[N];
			for(int i=0; i<N; i++) adj[i] = new ArrayList<edge>();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				int t = Integer.parseInt(st.nextToken());
				adj[s].add(new edge(e, t));
				adj[e].add(new edge(s, t));
			}
			for(int i=0; i<W; i++) {
				st = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				int t = Integer.parseInt(st.nextToken())*(-1);
				adj[s].add(new edge(e, t));
			}
			
			if(SPFA()) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.print(sb);
	}
	
	static boolean SPFA() {
		time = new int[N];
		len = new int[N];
		queue = new LinkedList<Integer>();
		
		for(int i=0; i<N; i++) {
			queue.add(i);
		}
		while(!queue.isEmpty()) {
			int u = queue.poll();
			for(edge a: adj[u]) {
				if(time[u] + a.weight < time[a.to]) {
					len[a.to] = len[u]+1;
					if(len[a.to]== N) return true;
					time[a.to] = time[u]+a.weight;
					if(!queue.contains(a.to)) queue.add(a.to); 
				}
			}
		}
		return false;
	}
	
	static class edge {
		int to, weight;
		public edge(int a, int b) {
			this.to = a;
			this.weight = b;
		}
	}
}