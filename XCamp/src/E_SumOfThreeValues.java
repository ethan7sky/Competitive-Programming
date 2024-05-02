import java.util.*;
import java.io.*;

public class E_SumOfThreeValues {
	
	static int n, x;
	static int[] a;
	static HashMap<Integer, ArrayList<Integer>> idx;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		a = new int[n];
		idx = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i=0; i<n; i++) {
			int t = Integer.parseInt(st.nextToken());
			a[i] = t;
			if(!idx.containsKey(t)) {
				idx.put(t, new ArrayList<Integer>());
			}
			idx.get(t).add(i);
		}
		
		for(int i=0; i<n; i++) {
			int targetSum = x-a[i];
			for(int j=0; j<n; j++) {
				if(j==i) continue;
				if(!idx.containsKey(targetSum-a[j])) continue;
				for(int k: idx.get(targetSum-a[j])) {
					if(k!=j&&k!=i) {
						System.out.println((i+1)+" "+(j+1)+" "+(k+1));
						return;
					}
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}
}
