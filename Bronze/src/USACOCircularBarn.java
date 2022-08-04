import java.io.*;
import java.util.*;

public class USACOCircularBarn {
	
	static BufferedReader in;
	static PrintWriter out;
	static int n, a[];
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("cbarn.in"));
		out = new PrintWriter("cbarn.out");
		
		n = Integer.valueOf(in.readLine());
		
		a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = Integer.valueOf(in.readLine());
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			
			int distance = 0;
			int len = 1;
			
			for(int j = i+1; j < n+i; j++) {
				distance += a[j%n] * len;
				len++;
			}
			
			min = Math.min(distance, min);
		}
		
		out.println(min);
	
		in.close();
		out.close();
	}
}
