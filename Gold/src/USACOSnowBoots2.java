import java.util.*;
import java.io.*;

public class USACOSnowBoots2 {
	
	static int n, b;
	static tile[] tiles;
	static boot[] boots;
	static TreeSet<Integer> availableDepths;
	static int[] ans;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(new File("snowboots.in")));
		out = new PrintWriter(new File("snowboots.out"));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		tiles = new tile[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) tiles[i] = new tile(Integer.parseInt(st.nextToken()), i);
		Arrays.sort(tiles);
		
//		System.out.println(Arrays.toString(tiles));
		
		boots = new boot[b];
		for(int i=0; i<b; i++) {
			st = new StringTokenizer(in.readLine());
			boots[i] = new boot(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					i);
		}
		Arrays.sort(boots);
		
//		System.out.println(Arrays.toString(boots));
		
		availableDepths = new TreeSet<Integer>();
		for(int i=0; i<n; i++) availableDepths.add(i);
		
		ans = new int[b];
		int remainingTilesIdx = 0;
		int maxRequiredStep = 0;
		
		for(boot B: boots) {
			
			while(remainingTilesIdx<n
					&& B.maxDepth < tiles[remainingTilesIdx].depth) {
				tile remove = tiles[remainingTilesIdx];
				availableDepths.remove(remove.idx);
				int newGap = availableDepths.ceiling(remove.idx) - availableDepths.floor(remove.idx);
				maxRequiredStep = Math.max(newGap, maxRequiredStep);
				
				remainingTilesIdx++;
			}
			
			if(B.maxDist >= maxRequiredStep) ans[B.idx] = 1;
			else ans[B.idx] = 0; 
			
		}

		StringBuilder res = new StringBuilder();
		for(int i: ans) res.append(i).append("\n");
		out.print(res);
		
		in.close();
		out.close();
	}
	
	
	static class tile implements Comparable<tile> {
		int depth, idx;
		public tile(int a, int b) {
			this.depth = a;
			this.idx = b;
		}
		public String toString() {
			return depth+" "+idx;
		}
		@Override
		public int compareTo(tile o1) {
			return o1.depth-this.depth;
		}
		
	}
	
	static class boot implements Comparable<boot> {
		int maxDepth, maxDist, idx;
		public boot(int a, int b, int c) {
			this.maxDepth = a;
			this.maxDist = b;
			this.idx = c;
		}
		public String toString() {
			return maxDepth+" "+maxDist+" "+idx;
		}
		@Override
		public int compareTo(boot o1) {
			return o1.maxDepth-this.maxDepth;
		}
		
	}
}
