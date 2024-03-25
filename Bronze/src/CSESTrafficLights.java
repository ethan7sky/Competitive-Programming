import java.util.*;
import java.io.*;

public class CSESTrafficLights {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int x, n;
	static long max, prevhigh, prevlow;
	static TreeSet<Integer> ts;
	
	public static void main(String args[]) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		x = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		ts = new TreeSet<Integer>();
		ts.add(0); ts.add(x);
		
		prevlow = 0;
		prevhigh = x;
		st = new StringTokenizer(in.readLine());
		sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			
			int idx = Integer.parseInt(st.nextToken());
			long low = ts.lower(idx);
			long high = ts.higher(idx);
			
			long range1 = Math.abs(idx-low);
			long range2 = Math.abs(idx-high);
			
			if(range1 > max) {
				max = range1;
				prevhigh = high; prevlow = low;				
			}
			if(range2 > max) {
				max = range2;
				prevhigh = high; prevlow = low;
			}
			if(idx>prevlow && idx<prevhigh) {
				if(range1>range2) max = range1;
				else max = range2;
				prevhigh = high; prevlow = low;				
			}

			sb.append(max).append("\n");
			ts.add(idx);
		}
		System.out.print(sb);
	}
}