import java.util.*;

public class Snippet {
	
	static int h, c, hs[], cs[];
	static boolean visited[], a[][];
	
	static boolean dfs(int s) {
		
		if(visited[s]) return false;
		
		visited[s] = true;
		
		for(int i=0; i<3; i++) {
			if(a[s][i]) {
				
				if(cs[i]==-1||dfs(cs[i])) {
					hs[s] = i;
					cs[i] = s;
					return true;
				}
			}
		}
		return false;
	}
	
	static int bipartiteMatch() {
		
		
		hs = new int[h];
		Arrays.fill(hs, -1);
		cs = new int[c];
		Arrays.fill(cs, -1);
		
		int size = 0;
		for(int start = 0; start < h; start++) {
			
			visited = new boolean[h];
			if(dfs(start)) size++;
		}
		return size;
	}
	
	public static void main(String[] args) {
		
		h=3;
		c=3;
		
		a = new boolean[h][c];
		a[0][0] = true;
		a[0][1] = true;
		a[0][2] = true;
		a[1][0] = true;
		a[2][1] = true;
		
		System.out.println(bipartiteMatch());
	}
}
