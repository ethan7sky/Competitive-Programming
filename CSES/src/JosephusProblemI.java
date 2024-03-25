import java.util.*;
import java.io.*;

public class JosephusProblemI {
	
	static int n;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		
		int[] a = new int[n];
		for(int i=0; i<n; i++) a[i] = i+1;
		
		StringBuilder sb = new StringBuilder();
		while(a.length>1) {
			
			int[] b = new int[a.length-a.length/2];
			for(int i=0; i<a.length; i++) {
				if(i%2==0) {
					if(a.length%2==0) {
						b[i/2] = a[i];
					}
					else {
						if(i==a.length-1) b[0] = a[i];
						else b[i/2+1] = a[i];
					}
				}
				else {
					sb.append(a[i]).append(" ");
				}
			}
			a = b.clone();
		}
		sb.append(a[0]);
		System.out.println(sb);
	}
}
