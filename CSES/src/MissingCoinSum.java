import java.util.*;
import java.io.*;

public class MissingCoinSum {
	
	static int n, a[];
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args)throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(a);
		
		long sum = 0;
		for(int i=0; i<n; i++) {
			if(sum+1<a[i]) {
				break;
			}
			sum += a[i];
		}
		System.out.println(sum+1);
		
	}
	
	
}
