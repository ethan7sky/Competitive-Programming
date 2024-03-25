//hi 
import java.util.*;
import java.io.*;

public class CFClosestToTheLeft {
	
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
			map.put(Integer.parseInt(st.nextToken()), i);
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
			Integer a = map.lowerKey(num);
			if(a==null)sb.append("0\n");
			else {
				if(a<0) a = -a-2;
				sb.append(map.get(a)).append("\n");
			}
		}
		
	}
	
}
