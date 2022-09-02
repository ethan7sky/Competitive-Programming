import java.io.*;
import java.util.*;

public class CSES1094 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		long ans = 0;
		for(int i = 1; i < n; i++) {
			if(a[i]<a[i-1]) {
				ans += a[i-1]-a[i];
				a[i] = a[i-1];
			}
		}
		
		System.out.println(ans);
	}
}
