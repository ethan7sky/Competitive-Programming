import java.util.*;
import java.io.*;

public class baekjoon1463 {
	
	static long a[], n, ans;
	static Scanner in;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		n = in.nextLong();
		a = new long[(int)n+1];
		
		for(int i=2; i<=n; i++) {
			a[i] = a[i-1]+1;
			if(i%2==0) a[i] = Math.min(a[i], a[i/2]+1);
			if(i%3==0) a[i] = Math.min(a[i], a[i/3]+1);
		}
		System.out.println(a[(int)n]);
		
		
		
	}
	
	
}
