import java.util.*;
import java.io.*;

public class USACOCowCollege_withmath {
	
	static Scanner in;
	static StringTokenizer st;
	static int n, a[];
	static long avg;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		n = in.nextInt(); in.nextLine();
		a = new int[n];
		st = new StringTokenizer(in.nextLine());
		avg = 0;
		
		
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			avg += a[i];
		}
		avg /= n;
		
		
		int avg1 = -1;
		int avg2 = 10000000;
		
		for(int i=0; i<n; i++) {
			if(a[i]>=avg) {
				avg2 = Math.min(a[i], avg2);
			}
			if(a[i] <= avg) {
				avg1 = Math.max(avg1,  a[i]);
			}
		}
		
		long res = 0;

		long cnt1 = 0;
		for(int i=0; i<n; i++) {
			if(a[i] >= avg1) cnt1+= avg1;
		}

		long cnt2 = 0;
		for(int i=0; i<n; i++) {
			if(a[i] >= avg2) cnt2+= avg2;
		}
		
		res = Math.max(cnt1, cnt2);
		
		if(cnt1 > cnt2) {
			System.out.println(res+" "+avg1);	
		}
		else {
			System.out.println(res+" "+avg2);
		}
		
		
	}
}
