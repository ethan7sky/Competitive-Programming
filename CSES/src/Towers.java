import java.util.*;
import java.io.*;

public class Towers {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n;
	static TreeMap<Integer, Integer> towers;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		st = new StringTokenizer(in.readLine());
		towers = new TreeMap<Integer, Integer>();
		
		while(n-->0) {
			
			int x = Integer.parseInt(st.nextToken());
			Integer higher = towers.higherKey(x);
			
			if(higher==null) {
				if(towers.containsKey(x)) towers.put(x, towers.get(x)+1);
				else towers.put(x, 1);
			}
			else {
				towers.put(higher, towers.get(higher)-1);
				if(towers.get(higher)==0) towers.remove(higher);
				
				if(towers.containsKey(x)) {
					towers.put(x, towers.get(x)+1);
				} else towers.put(x, 1);
			}
		}
		long ans=0;
		for(int i: towers.keySet()) {
			ans += towers.get(i);
		}
		System.out.println(ans);
	}
	
}