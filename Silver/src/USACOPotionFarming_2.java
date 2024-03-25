import java.util.*;
import java.io.*;

public class USACOPotionFarming_2 {
	
	static int n, paths[];
	static ArrayList<Integer>[] edges;
	static boolean v[];
	static HashSet<Integer> leaves;
	static HashMap<Integer, Integer> potions;
	static BufferedReader in;
	static StringTokenizer st;
	static HashSet<maxpotions> nodeswithpotions[];
	static int[] parent;
	static int[] input;
	
	public static void main(String[] args) throws IOException {
		
		 in = new BufferedReader(new InputStreamReader(System.in));
		 
		 n = Integer.parseInt(in.readLine());
		 potions = new HashMap<Integer, Integer>();
		 
		 st = new StringTokenizer(in.readLine());
		 input = new int[n];
		 
		 for(int i=0; i<n; i++) {
			 input[i] = Integer.parseInt(st.nextToken());
			 if(!potions.containsKey(input[i])) potions.put(input[i], 1);
			 else potions.put(input[i], potions.get(input[i])+1);
		 }
		 
		 edges = new ArrayList[n+1];
		 nodeswithpotions = new HashSet[n];
		 for(int i=1; i<=n; i++) {
			 edges[i] = new ArrayList<Integer>();
			 nodeswithpotions[i-1] = new HashSet<maxpotions>();
		 }
		 
		 for(int i=1; i<n; i++) {
			 st = new StringTokenizer(in.readLine());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 edges[a].add(b);
			 edges[b].add(a);
		 }
		 
		 parent = new int[n+1];
		 v = new boolean[n+1];
		 leaves = new HashSet<Integer>();
		 
		 dfsCountLeaves(1, 0);
//		 System.out.println("leaves = "+leaves);
		 
		 for(int i=leaves.size(); i<n; i++) {
			 potions.put(input[i], potions.get(input[i])-1);
			 if(potions.get(input[i])==0) potions.remove(input[i]);
		 }
		 
		 dfsFindLeaves(1, 0);
//		 
//		 for(HashSet<maxpotions> i: nodeswithpotions) {
//			 System.out.println(i);
//		 }
		 //System.out.println(Arrays.toString(parent));
		 
		 for(int depth=n-1; depth>0; depth--) {
			 
			 maxpotions[] parentinfo = new maxpotions[n];
			 for(maxpotions i: nodeswithpotions[depth]) {
				 int parentid = parent[i.nodeid];
				 int parentpotioncnt = potions.containsKey(parentid)? potions.get(parentid):0;
				 if(parentinfo[parentid] == null) {
					 parentinfo[parentid] = new maxpotions(parentid, i.leafcnt, parentpotioncnt+i.potioncnt); 
				 }
				 else {
					 parentinfo[parentid]= new maxpotions(parentid, parentinfo[parentid].leafcnt + i.leafcnt, parentinfo[parentid].potioncnt+i.potioncnt); 
				 }
			 }
			 for(maxpotions i: parentinfo) {
				 if(i==null) continue;
				 if(i.potioncnt > i.leafcnt) i.potioncnt = i.leafcnt;
				 nodeswithpotions[depth-1].add(i);
			 }
//			 System.out.println("depth = "+depth);
//			 System.out.println(Arrays.toString(parentinfo));
//			 System.out.println(nodeswithpotions[depth]);
		 }
//		 System.out.println("depth = "+0);
//		 System.out.println(nodeswithpotions[0]);
		 for(maxpotions i: nodeswithpotions[0]) {
			 System.out.println(i.potioncnt);
			 break;
		 }
	}
	static void dfsFindLeaves(int node, int depth) {

		boolean haschildren = false;
		v[node] = true;
		for(int i: edges[node]) {
			if(!v[i]) {
				haschildren=true;
				dfsFindLeaves(i, depth+1);
				parent[i] = node;
			}
		}
		v[node] = false;
		if(!haschildren) {
			int potioncnt = potions.containsKey(node)? potions.get(node):0;
			nodeswithpotions[depth].add(new maxpotions(node, 1, potioncnt));
		}
	}
	static void dfsCountLeaves(int node, int depth) {

		boolean haschildren = false;
		v[node] = true;
		for(int i: edges[node]) {
			if(!v[i]) {
				haschildren=true;
				dfsCountLeaves(i, depth+1);
				parent[i] = node;
			}
		}
		v[node] = false;
		if(!haschildren) {
			leaves.add(node);
		}
	}
	static class maxpotions {
		int nodeid, leafcnt, potioncnt;
		maxpotions(int a, int b, int c){
			this.nodeid = a;
			this.leafcnt = b;
			this.potioncnt = c;
		}
		public String toString() {
			return nodeid+" "+leafcnt+" "+potioncnt;
		}
	}
}
