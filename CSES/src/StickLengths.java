import java.util.*;
import java.io.*;

public class StickLengths {
	
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
		int median = a[n/2];
		
		long ans = 0;
		for(int i=0; i<n; i++) ans += Math.abs(a[i]-median);
		System.out.println(ans);
		
	}
	
	
}
