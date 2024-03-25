import java.util.*;
import java.io.*;

public class USACOWormholeSort {
	
	static int n, m;
	static e[] wormholes;
	static boolean[] v;
	static HashSet<Integer> sortable;
	static HashSet<Integer> unsorted;
	static ArrayList<Integer>[] edges;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader("wormsort.in"));
		//out = new PrintWriter("wormsort.out");
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		unsorted = new HashSet<Integer>();
		sortable = new HashSet<Integer>();
		v = new boolean[n+1];
		wormholes = new e[m];
		
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++) {
			if(Integer.parseInt(st.nextToken())!=i) {
				unsorted.add(i);
			}
		}
		if(unsorted.size()==0) {
			out.println(-1);
			in.close();
			out.close();
			return;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			wormholes[i] = new e(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(wormholes);
		
		edges = new ArrayList[n+1];
		for(int i=1; i<=n; i++) edges[i] = new ArrayList<Integer>();
		
		for(e i: wormholes) {
			edges[i.s].add(i.e);
			edges[i.e].add(i.s);
			dfs(i.s);
			dfs(i.e);
			if(sortable.size()==unsorted.size()) {
				System.out.println(sortable);
				System.out.println(unsorted);
				System.out.println(i.size);
				break;
			}
		}
		in.close();
		//out.close();
	}
	static void dfs(int node) {
		v[node] = true;
		if(unsorted.contains(node)) sortable.add(node);
		
		for(int i: edges[node]) {
			if(!v[i]) dfs(i);
		}
		
	}
	
	
	static class e implements Comparable<e>{
		int s, e, size;
		public e(int a, int b, int c) {
			this.s = a;
			this.e = b;
			this.size = c;
		}
		@Override
		public int compareTo(e that) {
			return that.size-this.size;
		}
	}
	
}
