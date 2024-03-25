import java.util.*;
import java.io.*;

public class USACOOutOfSorts2 {

	static BufferedReader in;
	static PrintWriter out;
	static int n, a[], b[], max;
	static HashMap<Integer, Integer> idx;
	static ArrayList<Integer> s, e;

	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("sort.in"));
		out = new PrintWriter("sort.out");
		init();
		solve();
		in.close();
		out.close();
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
		for(int i=0; i<n; i++) idx.put(b[i], i);
//		
//		System.out.println(Arrays.toString(a));
//		System.out.println(idx);
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
		
		int max = 1;
		for(int i=0; i<n; i++){
			max = Math.max(max, i-idx.get(a[i])+1);
		}
		out.println(max);


	}
}
