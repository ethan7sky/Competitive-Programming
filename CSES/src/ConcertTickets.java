import java.util.*;
import java.io.*;

public class ConcertTickets {
	
	static int n, m;
	static TreeMap<Integer, Integer> t;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static Map.Entry<Integer, Integer> val;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		t = new TreeMap<Integer, Integer>();
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(t.containsKey(x)) 
				t.put(x, t.get(x)+1);
			else t.put(x, 1);
		}
		sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<m; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			val = t.lowerEntry(x+1);
			
			if(val!=null) {
				sb.append(val.getKey()).append("\n");
				
				if(val.getValue()==1) t.remove(val.getKey());
				else t.put(val.getKey(), val.getValue()-1);
			}
			else {
				sb.append("-1\n");
			}
		}
		System.out.print(sb);
		
	}
	
}
