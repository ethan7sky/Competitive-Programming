import java.util.*;
import java.io.*;

public class USACOOutOfSorts {

	static BufferedReader in;
	static int n, a[], b[], max;
	static HashMap<Integer, Integer> idx;
	static ArrayList<Integer> s, e;

	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));

		init();
		solve();
	}
	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		a = new int[n];
		b = new int[n];
		idx = new HashMap<Integer, Integer>();
		
		for(int i=0; i<n; i++){
			a[i] = Integer.parseInt(in.readLine());
			b[i] = a[i];
		}
		Arrays.sort(b);
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
//		for(int i=0; i<n; i++) idx.put(b[i], i);
//		
//		System.out.println(idx);
//
//		s = new ArrayList<Integer>();
//		e = new ArrayList<Integer>();
//		
//		for(int i=0; i<n; i++) {
//			int idx1 = i;
//			int idx2 = idx.get(a[i]);
//			s.add(Math.min(idx1, idx2));
//			e.add(Math.max(idx1, idx2));
//		}
	}
	static void solve() {
//		for(int i=0; i<n; i++){
//			s.add(a[i]);
//			e.add(idx.get(a[i]));
//		}
		
		HashSet<Integer> pool = new HashSet<Integer>();
		for(int i=0; i<n; i++){
			int val1 = a[i];
			int val2 = b[i];
			boolean containsa = pool.contains(val1);
			boolean containsb = pool.contains(val2);
			
			if(val1==val2) continue;
			
			if(!containsa) pool.add(val1);
			if(!containsb) pool.add(val2);
			
			//System.out.println(pool);
			max = Math.max(max, pool.size());
			
			if(containsa) pool.remove(val1);
			if(containsb) pool.remove(val2);
			
		}
		System.out.println(max+1);


	}
}
