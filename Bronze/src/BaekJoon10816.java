import java.util.*;
import java.io.*;

public class BaekJoon10816 {
	
	static int n, m;
	static HashMap<Integer, Integer> map;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		map = new HashMap<Integer, Integer>();
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(map.containsKey(a)) map.put(a, map.get(a)+1);
			else map.put(a, 1);
		}
		
		m = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			int b = Integer.parseInt(st.nextToken());
			if(!map.containsKey(b)) sb.append("0 ");
			else sb.append(map.get(b)).append(" ");
		}
		System.out.println(sb.substring(0,sb.length()-1));
	}
}
