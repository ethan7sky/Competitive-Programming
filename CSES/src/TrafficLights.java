import java.util.*;
import java.io.*;

public class TrafficLights {
	
	static int x, n, p[], max;
	static BufferedReader in;
	static StringTokenizer st;
	static TreeSet<Integer> lights;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		x = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		p = new int[n];
		lights = new TreeSet<Integer>();
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
			lights.add(p[i]);
		}
		
		int prev = 0;
		for(Integer value: lights) {
			max = Math.max(max, value-prev);
			prev = value;
		} max = Math.max(max, x-prev);
		
		lights.add(0);
		lights.add(x);
		
		sb = new StringBuilder();
		
		for(int i=n-1; i>=0; i--) {
			sb.append(max).append(" ");
			
			int light = p[i];
			lights.remove(light);
			
			Integer lower = lights.lower(light);
			Integer higher = lights.higher(light);
						
			max = Math.max(max, higher-lower);
		}
		sb.reverse();
		System.out.println(sb.substring(1));
	}
	
}
