import java.util.*;
import java.io.*;

public class CFMaximumDistance {
	
	static Scanner in;
	static int N, x[], y[], max;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		N = in.nextInt();
		x = new int[N];
		y = new int[N];
		
		for(int i = 0; i < N; i++) {
			x[i] = in.nextInt();
		}
		for(int i = 0; i < N; i++) {
			y[i] = in.nextInt();
		}
		
		max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				int len1 = x[i]-x[j];
				int len2 = y[i]-y[j];
				
				max = Math.max(max, len1*len1+len2*len2);
			}
		}
		
		System.out.println(max);		
	}
}
