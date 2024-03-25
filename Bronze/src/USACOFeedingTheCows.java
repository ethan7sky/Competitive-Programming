import java.util.*;
import java.io.*;

public class USACOFeedingTheCows {
	
	static Scanner in;
	static int t, n, k, cnt;
	static String cows;
	static char grass[];
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		
	}
	
	static void init() {
		
		t = in.nextInt();
		for(int i=0; i<t; i++) {
			
			cnt=0;
			n=in.nextInt();
			k=in.nextInt();
			cows=in.next();
			grass = new char[n];
			Arrays.fill(grass, '.');
			
			solve();
		}
	}
	static void solve() {
		
		int gidx = Integer.MIN_VALUE;
		int hidx = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			
			if(cows.charAt(i)=='G' && i>gidx+k) {
				
				gidx = Math.min(n-1, i+k);
				if(grass[gidx]!='.') gidx--;
				grass[gidx]='G';
				cnt++;
			}
			else if(cows.charAt(i)=='H' && i>hidx+k) {
				
				hidx = Math.min(n-1, i+k);
				if(grass[hidx]!='.') hidx--;
				grass[hidx]='H';
				cnt++;				
			}
		}
		
		System.out.println(cnt);
		System.out.println(grass);
		
		
	}
}