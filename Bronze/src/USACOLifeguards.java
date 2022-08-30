import java.util.*;
import java.io.*;

public class USACOLifeguards {
	
	static BufferedReader in;
	static PrintWriter out;
	static int a[][], n, max;
	static boolean[] b;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("lifeguards.in"));
		out = new PrintWriter("lifeguards.out");
		n = Integer.valueOf(in.readLine());
		a = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			a[i][0] = Integer.valueOf(st.nextToken());
			a[i][1] = Integer.valueOf(st.nextToken());
		}
		
		max = 0;
		
		for(int i = 0; i < n; i++) {

			b = new boolean[1001];
			//i is fired
			
			for(int j = 0; j < n; j++) {
				if(i != j) {
					for(int k = a[j][0]; k < a[j][1]; k++) {
						b[k] = true;
					}
				}
					
				
			}
			int sum = 0;
			for(int j = 0; j < 1001; j++) {
				if(b[j]) sum++;
			}
			max = Math.max(sum, max);
		}
		out.println(max);
		
		in.close();
		out.close();
	}
}
