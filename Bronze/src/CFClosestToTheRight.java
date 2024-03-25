//hi 
import java.util.*;
import java.io.*;

public class CFClosestToTheRight {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static PrintWriter out;
	static int n, k;
	static TreeMap<Integer, Integer> map;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new TreeMap<Integer, Integer>();
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(map.containsKey(a)) continue;
			map.put(a, i);
		}
		sb = new StringBuilder();
		st = new StringTokenizer(in.readLine());
		while(k-->0) {
			solve(Integer.parseInt(st.nextToken()));
		}
		System.out.print(sb);
	}
	static void solve(int num) {
		
		if(map.containsKey(num)) sb.append(map.get(num)).append("\n");
		else {
			Integer a = map.higherKey(num);
			if(a==null)sb.append(n+1).append("\n");
			else {
				if(a<0) a = -a-1;
				sb.append(map.get(a)).append("\n");
			}
		}
	}
	
}
