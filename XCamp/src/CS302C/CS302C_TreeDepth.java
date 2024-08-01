package CS302C;
import java.util.*;
import java.io.*;

public class CS302C_TreeDepth {
	
	static int n;
	static ArrayList<Integer>[] adj;
	static int max=0;
	static BufferedReader in;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		adj = new ArrayList[n];
		for(int i=0; i<n; i++) adj[i] = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			char[] a = in.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				if(a[j]=='1') adj[i].add(j);
			}
		}
		
		findDepth(-1, 0, 0);
		System.out.println(max);
	}
	static void findDepth(int p, int c, int d) {
		max = Math.max(max, d);
		for(int i: adj[c]) {
			if(i != p) findDepth(c, i, d+1);
		}
	}
}
