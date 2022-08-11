import java.util.*;
import java.io.*;

public class USACOSleepingInClass {
	
	static BufferedReader in;
	static int t, n, sum, ans, a[];
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.valueOf(in.readLine());
		
		while(t-->0) {
			init();
			solve();			
		}
		in.close();
	}
	
		
	static void init() throws IOException {
		
		n = Integer.valueOf(in.readLine());
		a = new int[n];
		st = new StringTokenizer(in.readLine());
		sum = 0;
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.valueOf(st.nextToken());
			sum += a[i];
		}
		
	}
	
	
	static void solve() {
		
		ans = Integer.MAX_VALUE;
		
		for(int i = 1; i <= sum; i++) { 
			
			if(sum%i != 0) continue;
			
			int add = 0;
			int cnt = 0;
			
			for(int j = 0; j < n; j++) {
				
				if(a[j] > i ) { add = -1; break; }
				if(a[j] == i && add == 0)  continue; 
				
				if(a[j] <= i) {
					add += a[j];
					
					if(add > i) { 
						add = -1; 
						break; 
					}
					if(add == i) {
						add = 0;
						continue;
					}
					else if(add < i){
						cnt++;
					}
				}
				
			}
			if(add != -1) {
				ans = Math.min(ans, cnt);
			}
		}
		
		if(ans == Integer.MAX_VALUE) {
			ans = 0;
		}
		System.out.println(ans);
	}
}
