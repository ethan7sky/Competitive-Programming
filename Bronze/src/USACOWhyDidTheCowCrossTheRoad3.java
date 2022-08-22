import java.util.*;
import java.io.*;

public class USACOWhyDidTheCowCrossTheRoad3 {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, ans;
	static queue a[];

	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("cowqueue.in"));
		out = new PrintWriter("cowqueue.out");
		
		n = Integer.parseInt(in.readLine());
		
		a = new queue[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = new queue(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(a);
		
		ans = 0;
		for(int i = 0; i < n; i++) {
			if(a[i].s > ans) ans += a[i].s-ans;
			ans += a[i].t;
		}
		
		out.println(ans);
		
		in.close();
		out.close();
	}
	static class queue implements Comparable<queue>{

		int s, t;
		queue(int a, int b){
			s = a;
			t = b;
		}
		
		public String toString() {
			return s + " " + t;
		}
		
		@Override
		public int compareTo(USACOWhyDidTheCowCrossTheRoad3.queue o) {
			
			return this.s-o.s;
		}
		
	}
}
