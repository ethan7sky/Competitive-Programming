/* 
ID: ethan7s1
LANG: JAVA
PROB: barn1
*/ 

import java.util.*;
import java.io.*;

public class barn1 {
	
	static int m, s, c, diff[], min, max, res;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new FileReader("barn1.in"));
		out = new PrintWriter("barn1.out");
		//in = new Scanner(System.in);
		
		m = in.nextInt();
		s = in.nextInt();
		c = in.nextInt();
		
		if(m>=c) {
			out.println(c);
			in.close();
			out.close();
			return;
		}
		
		int[] input = new int[c];
		for(int i=0; i<c; i++) input[i] = in.nextInt();
		Arrays.sort(input);
		
		diff = new int[c-1];
		int prev = input[0];
		min = prev;
		max = prev;
		for(int i=1; i<c; i++) {
			int next = input[i];
			diff[i-1] = next-prev-1;
			prev = next;
			
			min = Math.min(prev, min);
			max = Math.max(prev, max);
		}
		
		res = max-min+1;
		Arrays.sort(diff);
		
		for(int i=1; i<m; i++) {
			res -= diff[c-i-1];
		}
		out.println(res);
		
		in.close();
		out.close();
	}
	
}
