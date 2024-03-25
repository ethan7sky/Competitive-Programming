import java.util.*;
import java.io.*;

public class USACOSplittingTheField {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n;
	static ArrayList<pair> a1, a2;
	static int minx, maxx, miny, maxy;
	static long maxarea, ans;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		a1 = new ArrayList<pair>();
		a2 = new ArrayList<pair>();
		
		minx=Integer.MAX_VALUE;
		maxx=0;
		miny=Integer.MAX_VALUE;
		maxy=0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a1.add(new pair(x, y));
			a2.add(new pair(x, y));
			
			minx = Math.min(minx, x);
			maxx = Math.max(maxx, x);
			miny = Math.min(miny, y);
			maxy = Math.max(maxy, y);
		}
				
		Collections.sort(a1, new compx());
		Collections.sort(a2, new compy());
		
		maxarea = (long)(maxx-minx)*(long)(maxy-miny);
		

	}
	
	
	static class pair {
		int x, y;
		public pair(int a, int b) {
			x = a;
			y = b;
		}
		public String toString() {
			return x+" "+y;
		}
	}
	static class compx implements Comparator<pair>{
		public int compare(pair a, pair b) {
			return Integer.compare(a.x, b.x);
		}
	}
	static class compy implements Comparator<pair> {
		public int compare(pair a, pair b) {
			return Integer.compare(a.y, b.y);
		}
	}
}
