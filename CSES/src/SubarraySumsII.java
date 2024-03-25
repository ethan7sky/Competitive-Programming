import java.util.*;
import java.io.*;

public class SubarraySumsII {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, x, a[];
	static long ans;
	static HashMap<Long, Integer> map;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
		
		long sum = 0;
		map = new HashMap<Long, Integer>();
		map.put(0L, 1);
		for(int i=0;i<n; i++) {
			sum += a[i];
			if(map.containsKey(sum-x)) ans += map.get(sum-x);
			if(map.containsKey(sum)) map.put(sum, map.get(sum)+1);
			else map.put(sum, 1);
		}
		
		System.out.println(ans);
	}
	
}
