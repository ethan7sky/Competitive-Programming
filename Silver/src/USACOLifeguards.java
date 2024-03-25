import java.util.*;
import java.io.*;

public class USACOLifeguards {
	
	static BufferedReader in;
	static StringTokenizer st;
	static HashSet<Integer> pool;
	static int n, cur, prev, status, alone[], total;
	static lifeguards[] a;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		a = new lifeguards[n*2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			a[i] = new lifeguards(Integer.parseInt(st.nextToken()), i, 1);
			a[i+n] = new lifeguards(Integer.parseInt(st.nextToken()), i, -1);
		}
		Arrays.sort(a);
		pool = new HashSet<Integer>();
		alone = new int[n];
		
		solve();
	}
	static void solve() {
		
		prev = a[0].time;
		total = 0;
		
		for(lifeguards event: a) {
			int time = event.time;
			int id = event.id;
			int status = event.status;
			
			if(pool.size()==1) alone[pool.hashCode()]+= time-prev;
			if(pool.size()!=0) total += time-prev;
			
			if(status==1) pool.add(id);
			if(status==-1) pool.remove(id);
			
			prev = time;
			
		}

		Arrays.sort(alone);
		System.out.println(total-alone[0]);
		
	}
	
	
	static class lifeguards implements Comparable<lifeguards> {
		
		int time, id, status;
		lifeguards(int a, int b, int c){
			time = a;
			id = b;
			status = c;
		}
		
		public String toString() {
			return time+" "+id+" "+status;
		}
		
		@Override
		public int compareTo(USACOLifeguards.lifeguards o) {
			// TODO Auto-generated method stub
			return this.time-o.time;
		}		
	}
}
