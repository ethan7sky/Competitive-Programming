package CS302C;
import java.util.*;
import java.io.*;

public class CS302C_TreeWidth {
	
	static int n;
	static ArrayList<Integer>[] adj;
	static int[] widths;
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
		
		widths = new int[n];
		findWidths(-1, 0, 0);
		
		for(int i: widths) max = Math.max(max, i);
		System.out.println(max);
	}
	static void findWidths(int p, int c, int d) {
		
		widths[d]++;
		
		for(int i: adj[c]) {
			if(i != p) findWidths(c, i, d+1);
		}
	}
}
