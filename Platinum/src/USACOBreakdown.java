import java.util.*;
import java.io.*;

public class USACOBreakdown {
	
	//idea:
	/*
	 *  process offline queries (backwards)
	 *  every time we add an edge, consider including it in a path of k edges. For each of the possible following edges and before edges, memo the minimum weight of a path with length x, 0<x<k
	 *  then, update the minimum path lengths. if one of the k-length paths going through the current path is less than the current minimum, update that value. 
	 *  append answer at the start of a string builder.
	 */
	
	static int n, k;
	static pair[] removals;
	static ArrayList<Integer> currAdj[];
	static int[][] weights;
	static long minStartingWithDist[][], minEndingWithDist[][]; // [startingNode][dist]
	static int minAnsSoFar;
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		weights = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				weights[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		removals = new pair[n*n];
		for(int i=0; i<n*n; i++) {
			st = new StringTokenizer(in.readLine());
			removals[i] = new pair(Integer.parseInt(st.nextToken())-1,
					Integer.parseInt(st.nextToken())-1);
		}
		
		
		minAnsSoFar = Integer.MAX_VALUE;
		minStartingWithDist = new long[n][k-1];
		for(int i=0; i<n; i++) {
			for(int j=0; j<k-1; j++) {
				minStartingWithDist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		currAdj = new ArrayList[n];
		for(int i=0; i<n; i++) currAdj[i] = new ArrayList<Integer>();
		
		for(int i=n*n-1; i>=0; i--) {
			pair c = removals[i];
			minStartingWithDist[c.first][1] = Math.min(minStartingWithDist[c.first][1], weights[c.first][c.second]);
			for(int pathLen=2; pathLen<=k; pathLen++) {
				
			}
		}
		
		
	}
	
	static class pair {
		int first, second;
		public pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
}
