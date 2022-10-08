import java.io.*;
import java.util.*;

public class CSES1623 {
	
	static Scanner in;
	static int n, a;
	static boolean group[];
	static long min, apples[];
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		n = in.nextInt();
		
		apples = new long[n];
		for(int i = 0; i < n; i++) {
			apples[i] = in.nextLong();
		}
		
		min = Long.MAX_VALUE;
		a = (int)Math.pow(2, n);
		for(int i = 0; i < a; i++) {
			
			String b = Integer.toBinaryString(i);
			
			group = new boolean[n];
			for(int j = b.length()-1; j >= 0; j--) {
				group[j] = b.charAt(j)=='1';
			}
			
			long g1 = 0;
			long g2 = 0;
			
			for(int j = 0; j < n; j++) {
				if(group[j]) g1+= apples[j];
				else g2 += apples[j];
			}
			min = Math.min(min, Math.abs(g1-g2));
			
		}
		System.out.println(min);
	}
	
}
