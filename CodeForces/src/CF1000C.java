import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class CF1000C {
	
	static int n;
	static c[] a;
	static TreeMap<Long, Integer> change;
	static long[] ans;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder res;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		change = new TreeMap<Long, Integer>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			long s = Long.parseLong(st.nextToken());
			long e = Long.parseLong(st.nextToken()) + 1;

			change.put(s, change.getOrDefault(s, 0)+1);
			change.put(e, change.getOrDefault(e, 0)-1);
		}
		
		
		ans = new long[n+1];
		long prevIdx = change.firstKey();
		int cnt = 0;
		
		for(long idx: change.keySet()) {
			ans[cnt] += idx - prevIdx;
			cnt += change.get(idx);
			prevIdx = idx;
		}
		
		res = new StringBuilder();
		for(int i=1; i<n; i++) {
			res.append(ans[i]).append(" ");
		}res.append(ans[n]);
		System.out.println(res);
		
	}
	
	static class c {
		long idx;
		int x;
		public c(long a, int b) {
			this.idx = a;
			this.x = b;
		}
		public String toString() {
			return idx+" "+x;
		}
	}
	
}
