import java.util.*;
import java.io.*;

public class baekjoon2839 {
	
	static long a[], n, ans;
	static Scanner in;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		n = in.nextLong();
		a = new long[(int)n+1];
		
		for(int i=1; i<=n; i++) {
			long x = Integer.MAX_VALUE;
			if(i-3 >= 0 && a[i-3] != -1) x = Math.min(a[i-3]+1, x);
			if(i-5 >= 0 && a[i-5] != -1) x = Math.min(a[i-5]+1, x);
			if(x == Integer.MAX_VALUE) a[i] = -1;
			else a[i] = x;
		}
		System.out.println(Arrays.toString(a));
		System.out.println(a[(int)n]);
		
		
		
	}
	
	
}
