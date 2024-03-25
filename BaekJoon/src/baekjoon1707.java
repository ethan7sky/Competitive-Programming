import java.util.*;
import java.io.*;

public class baekjoon1707 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int k, v, e;
	static ArrayList<Integer>[] a;
	static int nodes[];
	static boolean isBipartite;
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[v+1];
		for(int i=1; i<=v; i++) a[i] = new ArrayList<Integer>();
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x].add(y);
			a[y].add(x);
		}
		nodes = new int[v+1];
	}
	
	static String solve() {
		
		isBipartite = true;
		for(int i=1; i<=v; i++) {
			if(nodes[i]==0) nodes[i]=1;
			isBipartite = bfs(i);
			if(!isBipartite) return "NO";
		}
		return "YES";
	}
	
	static boolean bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		
		while(!q.isEmpty()) {
			
			int curr = q.poll();
			
			for(int i: a[curr]) {
				if(nodes[i]!=0 && nodes[curr]==nodes[i]) return false;
				else if(nodes[i] == 0) {
					nodes[i] = nodes[curr]*-1;
					q.add(i);
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(in.readLine());
		
		for(int i=0; i<k; i++) {
			init();
			System.out.println(solve());
		}
	}
}
