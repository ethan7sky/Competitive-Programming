import java.util.*;
import java.io.*;

public class USACOLifeguards_silver {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, alone[], pre, cur, id, status, total;
	static HashSet<Integer> pool;
	static events a[];
	
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("lifeguards.in"));
		out = new PrintWriter("lifeguards.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static class events implements Comparable<events>{

		int time, id, status;
		events(int a, int b, int c){
			time = a;
			id = b;
			status = c;
		}
		
		public String toString() {
			return time+" "+id+" "+status;
		}
		
		@Override
		public int compareTo(events o) {
			return this.time-o.time;
		}
		
	}
	
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());
		a = new events[n*2];
		alone = new int[n];
		pool = new HashSet<Integer>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			a[i*2] = new events(Integer.parseInt(st.nextToken()), i, 1);
			a[i*2+1] = new events(Integer.parseInt(st.nextToken()), i, 0);
		}
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
	}
	static void solve() {
		
		total = 0;
		pre = a[0].time;
		
		for(events d: a) {
			cur = d.time;
			id = d.id;
			status = d.status;
			
			if(!pool.isEmpty()) {
				total += cur-pre;
			}
			if(pool.size()==1) {
				alone[pool.hashCode()] += cur-pre;
			}
			if(status==1) pool.add(id);
			else pool.remove(id);
			
			pre = cur;
		}
		
		Arrays.sort(alone);
		
		out.println(total-alone[0]);
		
	}
}
