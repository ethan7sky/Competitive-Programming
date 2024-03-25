import java.util.*;
import java.io.*;

public class RedistributingGifts2 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, a[][];
	static HashSet<Integer>[] before;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		a = new int[n][n];
		gifts = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				gifts.add(a[i][j]);
			}
		}
		
		
	}
	
	
}
