import java.util.*;
import java.io.*;

public class BaekJoon1697 {
	
	static Scanner in;
	static int n, k;
	static HashSet<Integer> visited;
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		
		visited = new HashSet<Integer>();
		q = new LinkedList<Integer>();
		
		bfs();
	}
	
	static void bfs() {
		
		q.add(n); q.add(0);
		visited.add(n);
		
		while(!q.isEmpty()) {
			
			int curr = q.poll();
			int depth = q.poll();
			
			if(curr == k) {
				System.out.println(depth);
				break;
			}
			
			int[] c = {curr+1, curr-1, 2*curr};
			
			for(int i=0; i<3; i++) {
				if(!visited.contains(c[i]) && c[i]>=0 && c[i]<=100000) {
					visited.add(c[i]);
					q.add(c[i]); q.add(depth+1);
				}
			}
		}
	}
}
