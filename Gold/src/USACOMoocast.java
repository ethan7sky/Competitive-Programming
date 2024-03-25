import java.util.*;
import java.io.*;

public class USACOMoocast {
	
	static int n;
	static int ans, power;
	static cow[] cows;
	static HashSet<Integer> reached;
	static int[][] dist;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("moocast.in"));
		out = new PrintWriter("moocast.out");
		
		n = Integer.parseInt(in.readLine());
		cows = new cow[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			cows[i] = new cow(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));	
		}
		dist = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				dist[i][j] = (int) (Math.pow(cows[j].x-cows[i].x, 2)+Math.pow(cows[j].y-cows[i].y, 2));
			}
		}
		
		reached = new HashSet<Integer>();
		
		int low = 0;
		int high = Integer.MAX_VALUE;
		while(low <= high) {
			power = (int)((low+high)/2);
			reached.clear();
			cntConnected(0);
			if(reached.size() == n) {
				high = power-1;
				ans = power;
			}
			else {
				low = power+1;
			}
		}
		out.println(ans);
		
		in.close();
		out.close();
	}
	static void cntConnected(int node) {
		reached.add(node);
		for(int i=0; i<n; i++) {
			if(i==node) continue;
			if(dist[node][i] <= power) {
				if(!reached.contains(i)) {
					cntConnected(i);
				}
			}
		}
	}
	
	static class cow {
		int x, y;
		public cow(int a, int b) {
			this.x = a;
			this.y = b;
		}
		
	}
	
	
}
