import java.util.*;
import java.io.*;

public class BaekJoon2042 {
	
	static Scanner in;
	static int n, m, k, a[];
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		n = in.nextInt();
		m = in.nextInt()+in.nextInt();
		
		a = new int[n+1];
		for(int i=1; i<=n; i++) {
			a[i] += in.nextInt();
			int next = i+(i&-i);
			if(next <= n) a[next] += a[i];
		}
		System.out.println(Arrays.toString(a));
		
		while(m-->0) solve();
	}
	static void solve() {
		
		int x = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		if(x==1) update(b, c-a[b]);
		else System.out.println(sum(c)-sum(b-1));
		
	}
	static void update(int i, int k) {
		
		while(i<=n) {
			a[i] += k;
			i+=i&-i;
		}
		
	}
	static int sum(int i) {
		int ans = 0;
		while(i > 0) {
			ans += a[i];
			i-=i&-i;
			
		}
		return ans;
	}
}
