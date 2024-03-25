import java.util.*;
import java.io.*;

public class HammingCode {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n-->0) {
			int m = in.nextInt();
			while(m-->0) {
				
				String s = in.next();
				int[] a = new int[s.length()+(int)(Math.log(s.length())/Math.log(2))+1];
				
				int powerof2 = 1;
				while(powerof2<=a.length) {
					a[powerof2-1]=-1;
					powerof2*=2;
				}
				int idx=0;
				for(int i=0; i<a.length; i++) {
					if(a[i]==-1) continue;
					a[i] = s.charAt(idx)-'0';
					idx++;
				}
				
				powerof2=1;
				while(powerof2<=a.length) {
					
					
				}
				
				
			}
		}
	}
}
