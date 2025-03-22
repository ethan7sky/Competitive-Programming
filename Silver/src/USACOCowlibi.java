import java.util.*;
import java.io.*;

public class USACOCowlibi {
	
	static int G, N;
	static data[] cows;
	static TreeMap<Long, data> grazings;
	static int ans;
	
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		G = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		cows = new data[N];
		grazings = new TreeMap<Long, data>();
		
		for(int i=0; i<G; i++) {
			st = new StringTokenizer(in.readLine());
			long a, b, c;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			grazings.put(c, new data(a, b, c));
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			cows[i] = new data(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
			);
		}
		
		
		ans = 0;
		
		for(data i: cows) {

			data a;
			if(grazings.lowerKey(i.t)==null) {
				a = i;
			} else {
				a = grazings.lowerEntry(i.t).getValue();
			}
			
			data b;
			if(grazings.higherKey(i.t)==null) {
				b = i;
			} else {
				b = grazings.higherEntry(i.t).getValue();
			}
			
			if((a.x-i.x)*(a.x-i.x) + (a.y-i.y)*(a.y-i.y) <= (i.t-a.t)*(i.t-a.t)){
				if((b.x-i.x)*(b.x-i.x) + (b.y-i.y)*(b.y-i.y) <= (i.t-b.t)*(i.t-b.t)){
					ans++;
				}
			}
		}
		System.out.println(N-ans);
	}

	
	
	static class data implements Comparable<data> {
		long x, y, t;
		public data(long a, long b, long c) {
			x = a;
			y = b;
			t = c;
		}
		@Override
		public int compareTo(data that) {
//			return this.t-that.t;
			return 0;
		}
		public String toString() {
			return x+" "+y+" "+t;
		}
	}
	
}	
