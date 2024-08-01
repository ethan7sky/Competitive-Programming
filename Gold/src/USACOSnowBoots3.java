import java.util.*;
import java.io.*;

public class USACOSnowBoots3 {
	
	static int n, b;
	static tile[] tiles;
	static boot[] boots;
	static int[] ans;
	static TreeSet<Integer> available;
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader(new File("snowboots.in")));
		out = new PrintWriter(new File("snowboots.out"));
		
		//init
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		tiles = new tile[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) tiles[i] = new tile(Integer.parseInt(st.nextToken()), i);
		Arrays.sort(tiles);
		
		boots = new boot[b];
		for(int i=0; i<b; i++) {
			st = new StringTokenizer(in.readLine());
			boots[i] = new boot(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					i);
		}
		Arrays.sort(boots);
		
		available = new TreeSet<Integer>();
		for(int i=0; i<n; i++) available.add(i);
		
		
		//solve
		
		ans = new int[b];
		int remainingTilesIdx = 0;
		int maxDist = 0;
		
		for(boot B: boots) {
			
			while(remainingTilesIdx < n && B.maxDepth < tiles[remainingTilesIdx].depth) {
				
				int idx = tiles[remainingTilesIdx].idx;
				available.remove(idx);
				int remainingGapLen = available.ceiling(idx) - available.floor(idx);
				
				maxDist = Math.max(remainingGapLen, maxDist);
				remainingTilesIdx++;
			}
			
			ans[B.idx] = B.maxDist >= maxDist ? 1:0; 
		}
		
		
		sb = new StringBuilder();
		for(int i: ans) sb.append(i).append("\n");
		out.print(sb);
		
		in.close();
		out.close();
	}
	
	
	static class boot implements Comparable<boot> {
		int maxDepth, maxDist, idx;
		public boot(int a, int b, int c) {
			this.maxDepth = a;
			this.maxDist = b;
			this.idx = c;
		}
		@Override
		public int compareTo(boot that) {
			return that.maxDepth - this.maxDepth;
		}
	}
	
	static class tile implements Comparable<tile> {
		int depth, idx;
		public tile(int a, int b) {
			this.depth = a;
			this.idx = b;
		}
		@Override
		public int compareTo(tile that) {
			return that.depth-this.depth;
		}
	}
	
}
