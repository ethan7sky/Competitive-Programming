import java.util.*;
import java.io.*;

public class CFBinarySearch {
	
	static int n, k, a[];
	static Scanner in;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = in.nextInt();
		
		sb = new StringBuilder();
		for(int i=0; i<k; i++) {
			if(Arrays.binarySearch(a, in.nextInt())>=0) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.print(sb);
	}
}
