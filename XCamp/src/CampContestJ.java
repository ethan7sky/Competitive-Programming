import java.util.*;
import java.io.*;

public class CampContestJ {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean[] a = new boolean[101];
		int s = in.nextInt();
		int e = in.nextInt();
		for(int i=s; i<e; i++) {
			a[i] = true;
		}
		for(int i=1; i<n; i++) {
			s = in.nextInt();
			e = in.nextInt();
			for(int j=s; j<e; j++) {
				a[j] = false;
			}
		}
		int cnt=0;
		for(int i=0; i<=100; i++) {
			if(a[i]) cnt++;
		}
		System.out.println(cnt);
	}
}
