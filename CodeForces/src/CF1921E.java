import java.util.*;
import java.io.*;

public class CF1921E {
	
	static int t, h, w, ax, ay, bx, by;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder ans;
	
	public static void main(String[] args) throws IOException {
			
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		ans = new StringBuilder();
		while(t-->0) {
			st = new StringTokenizer(in.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			ax = Integer.parseInt(st.nextToken());
			ay = Integer.parseInt(st.nextToken());
			bx = Integer.parseInt(st.nextToken());
			by = Integer.parseInt(st.nextToken());
			
			solve();
		}
		System.out.print(ans);
	}
	static void solve() {
		
		if(ax>=bx) {
			ans.append("DRAW\n");
			return;
		}
		
		int xdist = Math.abs(ax-bx);
		int ydist = Math.abs(ay-by);
		
		if(xdist%2==1) {
			
			if(Math.abs(ydist)<=1) {
				ans.append("ALICE\n");
				return;
			}
			else{
				ydist--; xdist--;
				int turns = xdist/2;
				int distfromwall = by-1;
				if(by > ay) {
					distfromwall = w-by;	
				}
				
				if(turns-distfromwall < ydist) {
					ans.append("DRAW\n");
					return;
				}
				else {
					ans.append("ALICE\n");
					return;
				}
			}
		}
		else {
			if(ydist==0) {
				ans.append("BOB\n");
				return;
			}
			else {
				int turns = xdist/2-1;
				
				int distfromwall = ay-1;
				if(ay > by) {
					distfromwall = w-ay;
				}
				
				if(turns-distfromwall < ydist-1) {
					ans.append("DRAW\n");
					return;
				}
				else {
					ans.append("BOB\n");
					return;
				}
			}
		}
		
	}
}
