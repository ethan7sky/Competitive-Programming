import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class CF1398C_2 {
	
	static int t, n, a[], p[];
	static long sum;
	static HashMap<Integer, Integer> vals;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		while(t-->0) {
			n = Integer.parseInt(in.readLine());
			p = new int[n+1];
			String s = in.readLine();
			for(int i=0; i<n; i++) {
				p[i+1] = p[i]+(s.charAt(i)-'0');
			}
			
			vals = new HashMap<Integer, Integer>();
			for(int i=0; i<=n; i++) {
				int diff = p[i]-i;
				if(vals.containsKey(diff)) vals.put(diff, vals.get(diff)+1);
				else vals.put(diff, 1);
			}
			sum=0;
			for(Entry<Integer, Integer> i: vals.entrySet()) {
				sum += ((long)i.getValue()*(i.getValue()-1))/2;
			}
			sb.append(sum).append("\n");
		}
		System.out.print(sb);
	}
	
}
