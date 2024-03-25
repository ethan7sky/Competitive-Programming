import java.util.*;
import java.io.*;

public class RestaurantCustomers2 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static TreeMap<Integer, Integer> times;
	static int n, max;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		times = new TreeMap<Integer, Integer>();
		
		while(n-->0) {
			st = new StringTokenizer(in.readLine());
			times.put(Integer.parseInt(st.nextToken()), 1);
			times.put(Integer.parseInt(st.nextToken()), -1);
		}
		
		int cnt=0;
		for(int key: times.keySet()) {
			cnt += times.get(key);
			max = Math.max(max, cnt);
		}
		System.out.println(max);
		
	}
	
}
