import java.util.*;
import java.io.*;

public class USACOClosingTheFarm_2 {
	
	static int n, m, nodeCnt;
	static ArrayList<Integer>[] edges;
	static boolean[] v, c;
	static int[] order;
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("closing.in"));
		out = new PrintWriter("closing.out");
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList[n+1];
		v = new boolean[n+1];
		c = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			edges[x].add(y);
			edges[y].add(x);
		}
		
		order = new int[n+1];
		for(int i=0; i<n; i++) order[i] = Integer.parseInt(in.readLine());
		
		for(int i=0; i<n; i++) {
			
			v = new boolean[n+1];
			nodeCnt = 0;
			
			cntConnected(order[n-1]);
			
			if(nodeCnt==n-i) out.println("YES");
			else out.println("NO");
			
			c[order[i]] = true;
		}
		
		in.close();
		out.close();
		
	}
	static void cntConnected(int node) {
		if(v[node] || c[node]) return;
		
		nodeCnt++;
		v[node] = true;
		for(int i: edges[node]) cntConnected(i);
	}
	
	
}
