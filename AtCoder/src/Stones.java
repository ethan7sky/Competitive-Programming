import java.util.*;
import java.io.*;

public class Stones {
	
	static int n, k;
	static StringTokenizer st;
	static BufferedReader in;
	static int[] a;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[k+1];
		a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
		
		
	}
	
	
}
