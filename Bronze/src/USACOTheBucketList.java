import java.util.*;
import java.io.*;

public class USACOTheBucketList {

	static BufferedReader in;
	static PrintWriter out;
	static int[] a;
	static int n, s, t, b;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("blist.in"));
		out = new PrintWriter("blist.out");
		
		a = new int[1000];
		n = Integer.valueOf(in.readLine());
		
		for(int i = 0; i < n; i++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			s = Integer.valueOf(st.nextToken());
			t = Integer.valueOf(st.nextToken());
			b = Integer.valueOf(st.nextToken());
			
			for(int j = s; j < t; j++) {
				a[j] += b;
			}
		}
		
		int max = -1;
		for(int i = 0; i < 1000; i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		
		out.println(max);
		
		in.close();
		out.close();
	}
}
