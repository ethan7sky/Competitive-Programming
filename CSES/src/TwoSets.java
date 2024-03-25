import java.util.*;
import java.io.*;

public class TwoSets {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long sum = (long)n*(n+1)/2;
		if(sum%2==1) {
			System.out.println("NO");
			return;
		}
		
		boolean[] used = new boolean[n+1];
		sum /= 2;
		
		for(int i=n; i>=0; i--) {
			if(sum-i<0) continue;
			sum -= i;
			used[i] = true;
		}
		used[(int)sum] = true;
		
		int cnt1=0;
		int cnt2=0;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			if(used[i]) {
				cnt1++;
				sb1.append(i).append(" ");
			}
			else {
				cnt2++;
				sb2.append(i).append(" ");
			}
		}
		System.out.println("YES");
		System.out.println(cnt1);
		System.out.println(sb1.toString().substring(0,sb1.length()-1));
		System.out.println(cnt2);
		System.out.println(sb2.toString().substring(0,sb2.length()-1));
		
	}
}
