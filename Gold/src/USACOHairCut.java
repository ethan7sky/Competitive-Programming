import java.util.*;
import java.io.*;

public class USACOHairCut {
	
	static int n, a[];
	static int[] ft;
	static BufferedReader in;
	static StringTokenizer st;
	static HashMap<Integer, HashSet<Integer>> idx;
	
	public static void main(String[] args) throws IOException {
		
		 in = new BufferedReader(new InputStreamReader(System.in));
		 
		 n = Integer.parseInt(in.readLine());
		 st = new StringTokenizer(in.readLine());
		 idx = new HashMap<Integer, HashSet<Integer>>();
		 for(int i=0; i<n; i++) {
			 a[i] = Integer.parseInt(st.nextToken());
			 if(!idx.containsKey(a[i])) idx.put(a[i], new HashSet<Integer>());
			 idx.get(a[i]).add(i);
		 }
		 
		 initft();
		 
		 
		 
		
	}
	static void initft() {
		
		ft = new int[n];
		for(int i=n-1; i<=0; i--) {
			int c = a[i];
			int cidx = i;
			while(cidx>=1) {
				
			}
		}
		
	}
	
}
