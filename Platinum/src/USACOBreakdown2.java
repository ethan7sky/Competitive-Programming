import java.util.*;
import java.io.*;

public class USACOBreakdown2 {
	
	/*
	 *  how in the world does this run in time?? O(kn^4) lmfao
	 */
	
	static int N, K;
	static edge[] removals;
	static ArrayList<edge> edges;
	static int[][] weights;
	static long minStartingWithDist[][], minEndingWithDist[][]; // [startingNode][dist]
	static int minAnsSoFar;
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		weights = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				weights[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		removals = new edge[N*N];
		for(int i=0; i<N*N; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			removals[i] = new edge(from, to, weights[from][to]);
		}

		
		edges = new ArrayList<edge>();
		
		sb = new StringBuilder();
		minAnsSoFar = Integer.MAX_VALUE;
		for(int i = N*N-1; i>=0; i--) {

			int[] dist = new int[N];
			int[] ans = new int[N];
			
			for(int j=0; j<N; j++) {
				dist[j] = Integer.MAX_VALUE;
			}
			dist[0] = 0;
			
			for(int j=0; j<K; j++) {
				Arrays.fill(ans, Integer.MAX_VALUE);
				for(edge k: edges) {
					if(dist[k.from] != Integer.MAX_VALUE) {
						ans[k.to] = Math.min(ans[k.to], dist[k.from]+k.weight);
					}
				}
				dist = ans.clone();
			}
			
			minAnsSoFar = Math.min(minAnsSoFar, ans[N-1]);
			
			sb
			.insert(0,  "\n")
			.insert(0, minAnsSoFar==Integer.MAX_VALUE? -1 : minAnsSoFar);
			
			edges.add(removals[i]);
		}
		
		System.out.print(sb);		
	}
	
	static class edge {
		int from, to, weight;
		public edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return from+" "+to+" "+weight;
		}
	}
}
