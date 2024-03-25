import java.util.*;
import java.io.*;

public class USACOPotionFarming {
	
	static int n, a[], idx[], traversalcnt;
	static boolean potion[];
	static boolean v[]; //for dfs
	static HashMap<Integer, HashSet<Integer>> edges;
	static Queue<Integer> finding;
	static int[] parents;
	static int ans;
	
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		a = new int[n];
		idx = new int[n+1];
		potion = new boolean[n];
		v = new boolean[n+1];
		edges = new HashMap<Integer, HashSet<Integer>>();
		finding = new ArrayDeque<Integer>();
		parents = new int[n+1];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			idx[a[i]] = i;
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
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(idx));
		for(int i: edges.keySet()) {
			System.out.println(i+" "+edges.get(i));
		}
		
		dfs(1);
		
		System.out.println(Arrays.toString(potion));
		
		System.out.println(traversalcnt);
		System.out.println(Arrays.toString(parents));
		
		for(int i=n; i>=n; i++) {
			if(potion[i]) {
				if(retrack(i)) 
			}
		}
	}
	static boolean retrack(int node) {
		
		
		
	}
	static boolean dfs(int node) {
		v[node] = true;
		boolean children = false;
		for(int i: edges.get(node)) {
			if(!v[i]) {
				parents[i] = node;
				children = dfs(i)? true:children;
			}
		}
		v[node] = false;
		
		if(!children) {
			potion[idx[node]] = true;
			traversalcnt++;
		}
		return !children;
		
	}
}
