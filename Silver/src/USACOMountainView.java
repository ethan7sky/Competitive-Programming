import java.util.*;
import java.io.*;

public class USACOMountainView {
	
	static int n;
	static pair[] a;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("mountains.in"));
		out = new PrintWriter("mountains.out");
		
		n = Integer.parseInt(in.readLine());
		a = new pair[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[i] = new pair(x-y, x+y);
		}
		Arrays.sort(a);
		
		int maxr = -1;
		int ans=0;
		for(pair i: a) {
			if(i.rx>maxr) {
				maxr = i.rx;
				ans++;
			}
		}
		out.println(ans);
		
		in.close();
		out.close();
	}
	
	static class pair implements Comparable<pair> {
		
		int lx, rx;
		public pair(int a, int b) {
			this.lx = a;
			this.rx = b;
		}
		
		@Override
		public int compareTo(pair that) {
			if(this.lx==that.lx)return that.rx-this.rx;
			return this.lx-that.lx; 
		}
	}
	
}
