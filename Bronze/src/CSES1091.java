import java.util.*;
import java.io.*;

public class CSES1091 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, a[], price;
	static TreeMap<Integer, Integer> map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new TreeMap<>();
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			int price = Integer.parseInt(st.nextToken());
			if(map.containsKey(price)) map.put(price, map.get(price)+1);
			else map.put(price, 1);
		}
		
		st = new StringTokenizer(in.readLine());
		sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			
			Integer price = Integer.parseInt(st.nextToken());
			price = map.lowerKey(price+1);
			
			if(price==null) sb.append("-1\n");
			else {
				sb.append(price).append("\n");
				map.put(price, map.get(price)-1);
				if(map.get(price)==0) map.remove(price);
			}
		}System.out.print(sb);
	}
}
