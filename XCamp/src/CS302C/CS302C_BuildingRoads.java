package CS302C;
import java.util.*;
import java.io.*;

public class CS302C_BuildingRoads {
	
	static int n, m, cnt;
	static ArrayList<Integer>[] adj;
	static boolean[] v;
	static ArrayList<Integer> roots;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) adj[i] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		
		roots = new ArrayList<Integer>();
		v = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			if(!v[i]) {
				ff(i);
				roots.add(i);
				cnt++;
			}
		}
		
		System.out.println(cnt-1);
		for(int i=1; i<roots.size(); i++) {
			System.out.println(roots.get(i-1)+" "+roots.get(i));
		}
	}
	static void ff(int node) {
		if(v[node]) return;
		v[node] = true;
		
		for(int c: adj[node]) ff(c);
	}
}
