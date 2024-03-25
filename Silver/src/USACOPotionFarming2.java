import java.util.*;
import java.io.*;

public class USACOPotionFarming2 {
	
	static int n, a[], idx[], traversalcnt;
	static boolean potion[];
	static boolean v[]; //for dfs
	static HashMap<Integer, HashSet<Integer>> edges;
	static Queue<Integer> finding;
	static int[] parents;
	static int[] depths;
	static int ans;
	static HashSet<Integer> orphans;
	static ArrayList<Integer>[] grandkids;
	
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		a = new int[n];
		v = new boolean[n+1];
		depths = new int[n+1];
		edges = new HashMap<Integer, HashSet<Integer>>();
		parents = new int[n+1];
		orphans = new HashSet<Integer>();
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(!edges.containsKey(x)) 
				edges.put(x, new HashSet<Integer>());
			if(!edges.containsKey(y)) 
				edges.put(y, new HashSet<Integer>());
			
			edges.get(x).add(y);
			edges.get(y).add(x);
		}
		
		dfs(1, 0);
		//System.out.println(orphans);
		traversalcnt = orphans.size();
		
		pair[] answers = new pair[traversalcnt];
		for(int i=0; i<traversalcnt; i++) {
			answers[i] = new pair(a[i], depths[a[i]]);
		}
		Arrays.sort(answers);
		
//		System.out.println(Arrays.toString(parents));
//		System.out.println(Arrays.toString(answers));
//		System.out.println(traversalcnt);
		
		grandkids = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			grandkids[i] = new ArrayList<Integer>();
		}
		
		for(int i: orphans) {
			findparents(parents[i], i);
		}
		
		ArrayList<Integer> used = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			int curr = answers[i].val;
			for(int j: grandkids[curr]) {
				if(!used.contains(j)) {
					used.add(j);
					break;
				}
			}
		}
		for(int i=0; i<n+1; i++) {
			System.out.println(grandkids[i]);
		}
		
		System.out.println(used.size());
		
		
	}
	static void findparents(int curr, int child) {
		grandkids[curr].add(child);
		if(curr==1) return;
		findparents(parents[curr], child);
	}
	
	static boolean dfs(int node, int depth) {
		
		depths[node] = depth;
		v[node] = true;
		boolean children = false;
		for(int i: edges.get(node)) {
			if(!v[i]) {
				parents[i] = node;
				children = true;
				dfs(i, depth+1);
			}
		}
		v[node] = false;
		
		if(!children) {
			orphans.add(node);
		}
		return children;
		
	}
	static class pair implements Comparable<pair> {

		int val, depth;
		
		pair(int a, int b){
			val = a;
			depth = b;
		}
		
		public String toString() {
			return val+" "+depth;
		}
		
		@Override
		public int compareTo(USACOPotionFarming2.pair o) {
			// TODO Auto-generated method stub
			return o.depth-this.depth;
		}
		
	}
}
