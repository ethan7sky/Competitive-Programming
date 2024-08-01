import java.util.*;
import java.io.*;
public class CF538367C {
	
	static int t, n, m;
	static ArrayList<Integer> adj2[];
	static ArrayList<Integer> adj[];
	static Stack<Integer> s;
	static ArrayList<Integer> tsort;
	static Queue<Integer> nextToAdd;
	static int dists[];
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] parentCnt;
	static int[] graphSize;
	static boolean v[];
	static int cnt;
	static ArrayList<Integer> tempNodes;
	static boolean hasCycle;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		
		t = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		testcases:
		while(t-->0) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n+1];
			adj2 = new ArrayList[n+1];
			parentCnt = new int[n+1];
			for(int i=0; i<=n; i++) {
				adj[i] = new ArrayList<Integer>();
				adj2[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(in.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				adj[from].add(to);
				parentCnt[to]++;
				adj2[from].add(to);
				adj2[to].add(from);
			}
			
			hasCycle = false;
			v = new boolean[n+1];
			graphSize = new int[n+1];
			//System.out.println(Arrays.toString(adj2));
			for(int i=1; i<=n; i++) {
				if(v[i]) continue;
				tempNodes = new ArrayList<Integer>();
				cnt=0;
				cntNodes(i, -1);
				for(int j: tempNodes) {
					graphSize[j] = cnt;
				}
			}
			if(hasCycle) {
				for(int i=0; i<n; i++) sb.append("0");
				sb.append("\n");
				continue testcases;
			}
			
			dists = new int[n+1];
			for(int i=0; i<=n; i++) {
				dists[i] = 0;
			}
			//first number is minDist, second number is maxDist
			nextToAdd = new LinkedList<Integer>();
			//System.out.println(Arrays.toString(parentCnt));
			for(int i=1; i<=n; i++) {
				if(parentCnt[i]==0) {
					nextToAdd.add(i);
					//dists[i] = 0;
				}
			}
			
			while(!nextToAdd.isEmpty()) {
				int curr = nextToAdd.poll();
				//dists[curr]++;
				for(int i: adj[curr]) {
					dists[i] += dists[curr]+1;
					parentCnt[i]--;
					if(parentCnt[i]==0) nextToAdd.add(i);
				}
			}
			
			double half = (double)n/2;
			//System.out.println(half);
			
			for(int i=1; i<=n; i++) {
				//System.out.println(dists[i] + " " +graphSize[i]);
				if(dists[i] <= half && graphSize[i]-dists[i]-1 <= half) {
					sb.append(1);
				}
				else sb.append(0);
			}
			sb.append("\n");
			
		}
		System.out.print(sb);
	}
	static void cntNodes(int curr, int prev) {
		v[curr] = true;
		cnt++;
		tempNodes.add(curr);
		for(int i: adj2[curr]) {
			if(i==prev) continue;
			if(v[i]) {
				hasCycle = true;
			}
			if(!v[i]) {
				cntNodes(i, curr);
			}
		}
	}
	
	static class node{
		int minDist, maxDist;
		public node(int a, int b) {
			this.minDist = a;
			this.maxDist = b;
		}
	}
}
