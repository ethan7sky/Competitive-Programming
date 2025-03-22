import java.util.*;
import java.io.*;

public class CF1092F {
	
	static BufferedReader in;
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	static int n, a[];
	static long sum[], ans, cost;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		sum = new long[n];
		a = new int[n];
		adj = new ArrayList[n];
		for(int i=0; i<n; i++) adj[i] = new ArrayList<Integer>();
		
		
		
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		} for(int i=1; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			adj[x].add(y);
			adj[y].add(x);			
		}
		
		sumDfs(0, -1, 0);
		calc(0, -1);
		
		System.out.println(ans);
		
	}
	
	static void sumDfs(int idx, int parent, int depth) {
		cost += (long) depth*a[idx];
		sum[idx] = a[idx];
		
		for(int child: adj[idx]) {
			if(child == parent) continue;
			sumDfs(child, idx, depth+1);
			sum[idx] += sum[child];
		}
	}
	
	static void calc(int idx, int parent) {
		ans = Math.max(ans, cost);
		
		for(int child: adj[idx]) {
			if(child == parent) continue;
			
			else {
				cost -= sum[child];
				sum[idx] -= sum[child];
				cost += sum[idx];
				sum[child] += sum[idx];
				
				calc(child, idx);
				
				//reverse the damage
				// (revert tree)
				
				sum[child] -= sum[idx];
				cost -= sum[idx];
				sum[idx] += sum[child];
				cost += sum[child];
			}
		}
	}
}
