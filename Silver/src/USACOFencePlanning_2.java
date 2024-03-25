import java.util.*;
import java.io.*;

public class USACOFencePlanning_2 {
	
	static int n, m;
	static ArrayList<Integer>[] edges;
	static boolean[] v;
	static cow[] cows;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int xMin, xMax, yMin, yMax;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("fenceplan.in"));
		out = new PrintWriter("fenceplan.out");
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cows = new cow[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			cows[i] = new cow(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		edges = new ArrayList[n];
		for(int i=0; i<n; i++) edges[i] = new ArrayList<Integer>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			edges[x].add(y);
			edges[y].add(x);
		}
		
		v = new boolean[n];
		
		for(int i=0; i<n; i++) {
			if(!v[i]) {
				xMin = Integer.MAX_VALUE;
				yMin = Integer.MAX_VALUE;
				xMax = 0;
				yMax = 0;
				dfs(i);
				min = Math.min(min, 2*(xMax-xMin+yMax-yMin));
			}
		}
		out.println(min);
		
		in.close();
		out.close();
		
	}
	static void dfs(int node) {
		v[node] = true;
		update(node);
		for(int i: edges[node]) {
			if(!v[i]) dfs(i);
		}
	}
	static void update(int i) {
		xMin = Math.min(cows[i].x, xMin);
		xMax = Math.max(cows[i].x, xMax);
		yMin = Math.min(cows[i].y, yMin);
		yMax = Math.max(cows[i].y, yMax);
	}
	
	static class cow {
		int x, y;
		public cow(int a, int b) {
			x = a;
			y = b;
		}
	}
	
}
