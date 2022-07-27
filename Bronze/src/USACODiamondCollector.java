import java.util.*;
import java.io.*;

public class USACODiamondCollector {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, k, diamonds[];
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("diamond.in"));
		out = new PrintWriter("diamond.out");
		
		st = new StringTokenizer(in.readLine());
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		
		diamonds = new int[n];
		
		for(int i = 0; i < n; i++) {
			diamonds[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(diamonds);
		
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			
			int current = diamonds[i];
			
			int len = 0;
			int index = i;
			while(index < n && Math.abs(diamonds[index] - current) <= k) {
				index++;
				len++;
			}
			
			max = Math.max(max, len);
		}
		out.println(max);
		
		in.close();
		out.close();
	}
}
