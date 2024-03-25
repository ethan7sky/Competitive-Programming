import java.util.*;
import java.io.*;

public class USACOMoocast_2 {
	
	static int n, cnt, max;
	static ArrayList<Integer>[] edges;
	static cow[] cows;
	static boolean[] v;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("moocast.in"));
		out = new PrintWriter("moocast.out");
		
		n = Integer.parseInt(in.readLine());
		edges = new ArrayList[n+1];
		for(int i=1; i<=n; i++) edges[i] = new ArrayList<Integer>();
		
		cows = new cow[n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(in.readLine());
			cows[i] = new cow(i, Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
				
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				if(canTransmit(cows[i], cows[j])) {
					edges[cows[i].id].add(cows[j].id);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			cnt=0;
			v = new boolean[n+1];
//			dfs(i);
			cnt = dfsTypeTwo(i);
			max = Math.max(max, cnt);
		}
		out.println(max);
		
		in.close();
		out.close();
		
		
	}
	static void dfs(int node) {
		cnt++;
		v[node] = true;
		for(int i: edges[node]) {
			if(!v[i]) dfs(i);
		}
	}
	
	static int dfsTypeTwo(int node) {
		v[node] = true;
		int reachable = 1;
		for(int i: edges[node]) {
			if(!v[i]) {
				reachable += dfsTypeTwo(i);
			}
		}
		return reachable;
	}
	
	static boolean canTransmit(cow a, cow b) {
		
		double distSquared = Math.pow(b.x-a.x, 2) + Math.pow(b.y-a.y, 2);
		return distSquared <= Math.pow(a.p, 2);
		
	}
	
	static class cow {
		int id, x, y, p;
		public cow(int num, int a, int b, int c) {
			id = num;
			x = a;
			y = b;
			p = c;
		}
		public String toString() {
			return id+" "+x+" "+y+" "+p;
		}
	}
}
