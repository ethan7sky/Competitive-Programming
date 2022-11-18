import java.util.*;
import java.io.*;

public class USACOClockwiseFence {
	
	static Scanner in;
	static int n, lcnt, rcnt;
	static String path;
	static HashMap<String, Character> map;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		solve();
		
	}
	static void solve() {
		
		for(int i=0; i<n; i++) {
			
			path = in.next();
			lcnt = 0;
			rcnt = 0;
			
			for(int j=0; j<path.length()-1; j++) {
				
				String dir = path.substring(j,j+2);
				if(map.get(dir) == 'r') rcnt++;
				else if(map.get(dir) == 'l') lcnt++;
			}
			
			if(rcnt>lcnt) System.out.println("CW");
			else System.out.println("CCW");
			
		}
	}
	static void init() {
		
		n = in.nextInt();
		
		map = new HashMap<String, Character>();
		map.put("NE", 'r');
		map.put("NW", 'l');
		map.put("ES", 'r');
		map.put("EN", 'l');
		map.put("SW", 'r');
		map.put("SE", 'l');
		map.put("WN", 'r');
		map.put("WS", 'l');
		map.put("NN", '_');
		map.put("SS", '_');
		map.put("EE", '_');
		map.put("WW", '_');
	}
}
