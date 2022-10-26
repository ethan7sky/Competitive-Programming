import java.util.*;
import java.io.*;

public class USACOMilkFactory {
	
	static int n, a[][];
	static Scanner in;
	static PrintWriter out;
	static HashMap<Integer, String> map;
	static boolean stations[];
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new FileReader("factory.in"));
		out = new PrintWriter("factory.out");
		
		init();
		solve();
		
		in.close();
		out.close();		
	}
	
	static void init() throws IOException {
		
		n = in.nextInt();
		a = new int[n-1][2];
		map = new HashMap<Integer, String>();
		for(int i = 0; i < n-1; i++) {
			String s = in.next();
			int e = in.nextInt();
			if(map.containsKey(e)) {
				map.put(e, map.get(e)+"-"+s);
			}
			else {
				map.put(e, s);
			}
		}
		
	}
	static void solve() {
		
		int ans = Integer.MAX_VALUE;
		
		for(int i = 1; i < n; i++) {
			stations = new boolean[n];
			HashSet<Integer> hs = new HashSet<Integer>();
			findpaths(i, hs);
			boolean works = true;
			for(boolean t: stations) {
				if(!t) works = false;
			}
			
			if(works) ans = Math.min(ans, i);
		}
		if(ans == Integer.MAX_VALUE) ans = -1;
		
		out.println(ans);
		
	}
	static void findpaths(int curr, HashSet<Integer> hs) { //stations f t f
		stations[curr-1] = true;
		if(map.containsKey(curr)) {
			
			String[] c = map.get(curr).split("-");
			
			for(int i=0; i<c.length; i++) {
				if(hs.contains(c[i])) {
					break;
				}
				HashSet<Integer> hs2 = hs;
				hs2.add(curr);
				findpaths(Integer.parseInt(c[i]), hs2);
			}	
		}
	}
}
