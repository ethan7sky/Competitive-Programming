import java.util.*;
import java.io.*;

public class USACOModernArt2 {
	
	static Scanner in;
	static PrintWriter out;
	static int n;
	static char a[][];
	static HashSet<Character> set;
	static HashMap<Character, point> map;
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new FileReader("art.in"));
		out = new PrintWriter("art.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	
	static void init() throws IOException {
		
		n = in.nextInt();
		a = new char[n][];
		set = new HashSet<Character>();
		map = new HashMap<Character, point>();
		
		for(int i = 0; i < n; i++) {
			a[i] = in.next().toCharArray();
			for(int j = 0; j < n; j++) {
				char p = a[i][j];
				if(p!='0')set.add(p);
			}
		}
		
		for(char p: set) {
			map.put(p, new point(n, n, 0, 0));
		}
		
		System.out.println(set);
		System.out.println(map);
	}
	
	static void solve() {
		
		for(int i =0; i<n; i++) {
			for(int j =0; j<n; j++) {
				
				char p = a[i][j];
				if(p=='0') continue;
				int x1 = Math.min(i, map.get(p).x1);
				int y1 = Math.min(j,  map.get(p).y1);
				int x2 = Math.max(i, map.get(p).x2);
				int y2 = Math.max(j, map.get(p).y2);
				
				map.put(p,  new point(x1, y1, x2, y2));
			}
		}
		
		System.out.println(map);
		
		for(char p: map.keySet()) {
			int x1 = map.get(p).x1;
			int y1 = map.get(p).y1;
			int x2 = map.get(p).x2;
			int y2 = map.get(p).y2;
			
			for(int i = x1; i<=x2; i++) {
				for(int j=y1; j<=y2; j++) {
					if(a[i][j] != p) set.remove(a[i][j]);
				}
			}
			
		}
		
		System.out.println(set);
		out.println(set.size());
		
		
	}
	static class point{
		int x1, y1, x2, y2;
		point(int a, int b, int c, int d){
			x1 = a;
			y1 = b;
			x2 = c;
			y2 = d;
		}
		
		public String toString() {
			return x1+" "+y1+" "+x2+" "+y2;
		}
	}
}
