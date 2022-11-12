import java.util.*;
import java.io.*;

public class USACOLonelyPhoto {
	
	static Scanner in;
	static ArrayList<Integer> a;
	static int n;
	static long ans;
	static String line;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		init();
		solve();
	}
	
	static void init() {
		
		int n = in.nextInt();
		String line = in.next();
		
		a = new ArrayList<Integer>();
		
		int cnt=0;
		char prev = line.charAt(0);
		
		for(int i=0; i<n; i++) {
			if(line.charAt(i) == prev) cnt++;
			else {
				a.add(cnt);
				cnt=1;
				prev = line.charAt(i);
			}
		}
		a.add(cnt);
		
	}
	
	static void solve() {
		
		ans = 0;
		for(int i=0; i<a.size(); i++) {
			
			int left = 0;
			if(i > 0) left = a.get(i-1);
			int right = 0;
			if(i < a.size() - 1) right = a.get(i+1);
			
			if(a.get(i) == 1) {
				
				int length = left+right+1;
				
				long sum = 0;
				for(int j=3; j<=length; j++) {
					
					int cnt = j;
					cnt -= Math.max(0, j-left-1);
					cnt -= Math.max(0, j-right-1);
					sum+=cnt;
				}
				ans += sum;
			}
			else {
				ans += Math.max(0, left-1);
				ans += Math.max(0, right-1);
			}
		}
		System.out.println(ans);
	}
}