import java.util.*;
import java.io.*;

public class CoordinateCompression {
	
	static TreeMap<Integer, Integer> sortx, sorty;
	static BufferedReader in;
	static StringTokenizer st;
	static int n = 4;
	static int[] x, y;
	

	static void coordinateCompression() throws IOException {
		//coordinate compression
		sortx = new TreeMap<Integer, Integer>();
		sorty = new TreeMap<Integer, Integer>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			
			sortx.put(Integer.parseInt(st.nextToken()), i);
			sorty.put(Integer.parseInt(st.nextToken()), i);			
		}
		
		x = new int[n];
		y = new int[n];
		
		int compressed=1;
		for(int i: sortx.values()) {
			x[i] = compressed;
			compressed++;
		}
		compressed=1;
		for(int i: sorty.values()) {
			y[i] = compressed;
			compressed++;
		}
		
		System.out.println(Arrays.toString(x));
		System.out.println(Arrays.toString(y));
	}
}
