import java.util.*;
import java.io.*;

public class USACOAngryCows {
	
	static BufferedReader in;
	static PrintWriter out;
	static int bales[], n, max, sum;
	static boolean exploded[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("angry.in"));
		out = new PrintWriter("angry.out");
		//in = new BufferedReader(new InputStreamReader(System.in));
		
		
		init();
		solve();
		
		in.close();
		out.close();
		
	}
	
	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		bales = new int[n];
		for(int i = 0; i < n; i++) {
			bales[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(bales);
	}
	
	static void solve() {
	
		for(int i = 0; i < n; i++) {
			max = Math.max(max, getidx(i, false)-getidx(i, true)+1);
		}
		out.println(max);
	}
	
	static int getidx(int curr, boolean left) {
		
		int r = 1;
		int d = left? -1:1;
		
		while(curr >= 0 && curr < n) {
			int next = curr;
			while(true) {
				if(next+d<0 || next+d >= n || Math.abs(bales[next+d] - bales[curr]) > r) break; 
				next += d;
			}
			if(next == curr) break;
			curr = next; 
			r++;
		}
		
		return curr;
		
	}
	
	static void explode(int idx, int radius) {
		
		int area = radius;
		while(true) {
			if(area >= 0 && area < n && Math.abs(bales[area] - bales[idx]) <= radius) {
				exploded[area] = true;
				explode(area, radius+1);
				area--;
			}
			else break;
		}
		area = radius+1;
		while(true) {
			if(area < n && Math.abs(bales[area] - bales[idx]) <= radius) {
				exploded[area] = true;
				explode(area, radius+1);
				area++;
			}
			else break;
		}		
		
		
	}
	
	
}
