import java.util.*;
import java.io.*;

public class USACOSpeeding {
	
	static BufferedReader in;
	static PrintWriter out;
	static int[] a, b;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("speeding.in"));
		out = new PrintWriter("speeding.out");
		//in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		a = new int[100];
		b = new int[100];
		
		int index = 0;
		
		for(int i = 0; i < n; i++) {
			
			st = new StringTokenizer(in.readLine());
			int len = Integer.valueOf(st.nextToken());
			int limit = Integer.valueOf(st.nextToken());
			
			for(int j = index; j < index+len; j++) {
				a[j] = limit;
			}
			index += len;
		}
		
		index = 0;
		
		for(int i = 0; i < m; i++) {
			
			st = new StringTokenizer(in.readLine());
			int len = Integer.valueOf(st.nextToken());
			int limit = Integer.valueOf(st.nextToken());
			
			for(int j = index; j < index+len; j++) {
				b[j] = limit;
			}
			index += len;
		}
		
		int res = -1;
		for(int i = 0; i < 100; i++) {
			if(b[i] - a[i] > res) {
				res = b[i] - a[i];
			}
		}
		
		if(res < 0) {
			res = 0;
		}
		
		out.println(res);
		
		in.close();
		out.close();
	}
}
