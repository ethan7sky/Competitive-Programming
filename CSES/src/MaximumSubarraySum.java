import java.util.*;
import java.io.*;

public class MaximumSubarraySum { //KADANE'S ALGORITHM 
	
	static int n, a[], ans;
	static long p[];
	static long prev, max;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		a=new int[n];
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		prev = a[0];
		max = a[0];
		
		for(int i=1; i<n; i++) {
			
			if(prev>0) prev += a[i];
			else prev = a[i];
			
			max = Math.max(max, prev);		
		}
		System.out.println(max);
	}
}
