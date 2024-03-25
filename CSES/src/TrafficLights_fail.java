import java.util.*;
import java.io.*;

public class TrafficLights_fail {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int x, n;
	static TreeSet<Integer> lights;
	static final int VALUE_5 = 5;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
//		x = Integer.parseInt(st.nextToken());
//		
//		lights = new TreeSet<Integer>();
//		lights.add(0);
//		lights.add(x);
//		
//		n = Integer.parseInt(st.nextToken());
//		
//		st = new StringTokenizer(in.readLine());
//		while(n-->0) {
//			int idx = Integer.parseInt(st.nextToken());
//			Integer lower = lights.lower(idx);
//			Integer upper = lights.higher(idx);
//			
//			break;
//		}
		System.out.println(x());
		
	}
	private static int x() {
		return 10;
	}
}