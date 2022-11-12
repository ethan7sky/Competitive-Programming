import java.util.*;
import java.io.*;

public class USACOModernArt {
	
	static int n, ans;
	static char canvas[][];
	static HashSet<Character> colors;
	static boolean[] works;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new FileReader("art.in"));
		out = new PrintWriter("art.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	
	}
	
	static void init() throws IOException {
		
		n = Integer.parseInt(in.nextLine());
		
		canvas = new char[n][];
		for(int i=0; i<n; i++) {
			canvas[i] = in.nextLine().toCharArray();
		}
		
		colors = new HashSet<Character>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				colors.add(canvas[i][j]);
			}
		}
		colors.remove('0');
		
		works = new boolean[9];
		for(char i: colors) works[i-'0'-1] = true;
	}
	
	static void solve() {
		
		for(char i: colors) {
			
			HashSet<Integer> inside = overlap(i);
			
			for(int j: inside) {
				works[j-1] = false;
			}
		}
		
		ans = 0;
		for(int i=0; i<9; i++) {
			if(works[i]) ans++;
		}
		out.println(ans);
	}
	
	static HashSet<Integer> overlap(char a){
		
		HashSet<Integer> inside = new HashSet<Integer>();
		
		int l = 9;
		int r = 0;
		int u = 0;
		int d = 9;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(canvas[i][j] == a) {
					l = Math.min(l, j);
					r = Math.max(r, j);
					u = Math.max(u, i);
					d = Math.min(d, i);
				}
			}
		}
		for(int i=d; i<=u; i++) {
			for(int j=l; j<=r; j++){
				inside.add(canvas[i][j]-'0');
			}
		}
		inside.remove(a-'0');
		return inside;
	}
	
}
