
import java.util.*;
import java.io.*;

public class MilkSum {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static long i, j;
	static long input[], a[], q;
	static long milksum, p[];
	static TreeMap<Long, Integer> idxs;
	static HashMap<Long, Integer> sortedidxs;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));

		init();
	}
	static void init() throws IOException {

		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		input = new long[n];
		for(int i=0; i<n; i++) input[i] = Long.parseLong(st.nextToken());

		a=input.clone(); Arrays.sort(a);
		idxs = new TreeMap<Long, Integer>();

		milksum=0L;
		p = new long[n+1];
		for(int i=0; i<n; i++) {
			p[i+1] = p[i]+a[i];
			milksum += a[i]*(i+1);
			idxs.put(a[i], i);
		}
		idxs.put(Long.MIN_VALUE, -1);
		
		sb = new StringBuilder();
		
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(p));
//		System.out.println(idxs);
		
		q = Integer.parseInt(in.readLine());
		while(q-->0) {
			st = new StringTokenizer(in.readLine());
			i = Long.parseLong(st.nextToken());
			j = Long.parseLong(st.nextToken());
			solve();
		}
		
		System.out.print(sb);
		
	}
	static void solve() {
		
		int oldidx = idxs.get(input[(int)i-1]);
		int newidx = idxs.lowerEntry(j).getValue()+1;
		
		//System.out.println(oldidx+" "+newidx+" "+milksum);
		
		long ans = milksum;
		ans -= a[oldidx]*(oldidx+1);
		if(newidx > oldidx) {
			ans += j*newidx;
		}else ans += j*(newidx+1);
		if(newidx>oldidx) {
			ans -= p[newidx] - p[oldidx+1];
		}else ans -= p[newidx] - p[oldidx];
		
		sb.append(ans).append("\n");
	}
	
}
