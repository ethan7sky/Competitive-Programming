import java.util.*;
import java.io.*;

public class USACOLonelyPhoto2 {
	
	static Scanner in;
	static ArrayList<Integer> a;
	static int n;
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
		
		char prev = line.charAt(0);
		int cnt=0;
		for(int i=0; i<n; i++) {
			if(line.charAt(i) == prev) {
				cnt++;
			}
			else {
				a.add(cnt);
				cnt = 1;
				prev = line.charAt(i);
			}
		}
		a.add(cnt);
	}
	
	static void solve() {
		
		long ans = 0;
		for(int i=0; i<a.size(); i++) {
			
			int l = 0;
			if(i > 0) l = a.get(i-1);
			int r = 0;
			if(i < a.size()-1) r = a.get(i+1);
			
			if(a.get(i) == 1) {
				
				int maxlen = l+r+1;
				
				long sum = 0;
				for(int j=3; j<=maxlen; j++) {
					long works = j;
					works -= Math.max(0,(j-1) - l);
					works -= Math.max(0, (j-1) - r);
					sum += works;
				}
				ans += sum;
			}
			else {
				ans += Math.max(0, l-1);
				ans += Math.max(0, r-1);
			}
		}
		System.out.println(ans);
	}
}
