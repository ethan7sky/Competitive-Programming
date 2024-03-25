import java.util.*;
import java.io.*;

public class MeetInTheMiddle {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, x, a[];
	static long ans;
	static HashMap<Long, Integer> left, right;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
		

		left = new HashMap<Long, Integer>();
		right = new HashMap<Long, Integer>();
		countleftsums(0, n/2, 0);
		countrightsums(n/2, n, 0);
		left.put(0L, 1);
		right.put(0L, 1);

		ans = 0;
		for(long key: left.keySet()) {
			if(right.containsKey(x-key)) {
				ans += left.get(key)*right.get(x-key);
			}
		}
		System.out.println(ans);
		
	}
	static void countleftsums(int idx, int lim, long prevsum) {
		
		if(idx==lim) return;
		int add = a[idx];
		long newsum = prevsum+idx;
		
		if(left.containsKey(newsum)) left.put(newsum, left.get(newsum)+1);
		else left.put(newsum, 1);
		
		countleftsums(idx+1, lim, prevsum);
		countleftsums(idx+1, lim, prevsum+add);
	}
	static void countrightsums(int idx, int lim, long prevsum) {
		
		if(idx==lim) return;
		int add = a[idx];
		long newsum = prevsum+idx;
		
		if(right.containsKey(newsum)) right.put(newsum, right.get(newsum)+1);
		else right.put(newsum, 1);
		
		countrightsums(idx+1, lim, prevsum);
		countrightsums(idx+1, lim, prevsum+add);
	}
}
