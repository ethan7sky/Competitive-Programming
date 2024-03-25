import java.util.*;

public class bipartite {
	
	static int graph[][] = 
		{{0,0,0,0,1,1,1,0},
		{0,0,0,0,0,0,0,1},
		{0,0,0,0,0,0,0,1},
		{0,0,0,0,0,0,1,0},
		{1,0,0,0,0,0,0,0},
		{1,0,0,0,0,0,0,0},
		{1,0,0,1,0,0,0,1},
		{0,1,1,0,0,0,1,0}};
	
	static int v = 8;
	static int nodes[] = new int[v];
	
	public static void main(String[] args) {
		
		boolean isBipartite = true;
		String ans = "Bipartite Graph";
		for(int i=0; i<v; i++) {
			if(nodes[i]==0) isBipartite = bfs(i);
			if(!isBipartite) ans = "Not a Bipartite Graph";
		}
		System.out.println(ans);
	}

	static boolean bfs(int s) {
		
		nodes[s] = 1;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		
		while(!q.isEmpty()) {
			
			int curr = q.poll();
			if(graph[curr][curr]==1) return false;
			for(int i=0; i<v; i++) {
				
				if(graph[curr][i]==1&&nodes[i]==0) {
					nodes[i] = nodes[curr]*-1;
					q.add(i);
				}
				else if(graph[curr][i]==1&&nodes[i]==nodes[curr]) {
					return false;
				}
			}
		}
		return true;
	}
}
