import java.util.*;
import java.io.*;

public class USACOModernArt {
	
	static int n, ans;
	static char canvas[][], colors[];
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("art.in"));
		out = new PrintWriter("art.out");
		
		init();
		solve();
		
		in.close();
		out.close();
		
	}
	
	static void init() {
		n = in.nextInt(); in.nextLine();
		
		canvas = new char[n][n];
		for(int i = 0; i < n; i++) {
			String temp = in.nextLine();
			for(int j = 0; j < n; j++) {
				canvas[i][j] = temp.charAt(j);
			}
		}
	}
	
	static void solve() {
		
		colors = findcolors();
		
		for(int i = 0; i < colors.length; i++) {
			
			boolean first = true;
			
			for(int j = 0; j < colors.length; j++) {
				if(i==j) continue;
				if(over(colors[i], colors[j])) {
					first=false;
					break;
				}
			}
			if(first) {
				ans++;			
			}
		}
		
		out.println(ans);
		
	}
	
	static boolean over(char a, char b) {
		
		int l = 11;
		int r = -1;
		int u = -1;
		int d = 11;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(canvas[i][j] == b) {
					l = Math.min(l, j);
					r = Math.max(r, j);
					u = Math.max(u, i);
					d = Math.min(d, i);
				}
			}
		}
		for(int i = d; i <= u; i++) {
			for(int j = l; j <= r; j++) {
				if(canvas[i][j] == a) return true;
			}
		}
		return false;
	}
	
	static char[] findcolors() {
		
		HashSet<Character> hs = new HashSet<Character>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				hs.add(canvas[i][j]);
			}
		}

		char[] colors = new char[hs.size()-1];
		if(!hs.contains('0')) {
			colors = new char[hs.size()];
		}
		int idx = 0;
		for(char c: hs) {
			if(c == '0') continue;
			colors[idx] = c;
			idx++;
		}
		
		return colors;
	}
}
