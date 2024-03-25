import java.util.*;
import java.io.*;

public class USACOCowCollege2 {
	
	static Scanner in;
	static StringTokenizer st;
	static int n, a[], maxcow;
	static long avg;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		n = in.nextInt(); in.nextLine();
		a = new int[n];
		st = new StringTokenizer(in.nextLine());
		
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			maxcow = Math.max(maxcow, a[i]);
		}
		
		int idx=0;
		int res=0;
		for(int i=maxcow; i>0; i--) {
			long ans = 0;
			for(int j=0; j<n; j++) {
				if(a[j] >= i) {
					ans += i;
				}
			}
			if(ans>=res) {
				idx=i;
				res=(int)ans;
			}
		}
		System.out.println(res+" "+idx);
		
		
		
	}
}
