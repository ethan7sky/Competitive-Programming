import java.util.*;
import java.io.*;

public class USACOSearchingForSoulmates {
	
	static int n, ans;
	static long a, b;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		while(n-->0) {
			
			st = new StringTokenizer(in.readLine());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			
			solve(a, b);
		}
		
	}
	static void solve(long x, long y) {
		
		int ans = 0;
		while(x>y) {
			if(x%2==1) {
				x++;
				ans++;
			}
			x/=2;
			ans++;
		}
		
		if(x==y) {
			System.out.println(ans);
			return;
		}
		
		int add = Integer.MAX_VALUE;
		int operations = 0;
		while(x>1) {
			add = Math.min(add, test(operations, x, y));
			if(x%2==1) {
				x++;
				operations++;
			}
			else {
				x/=2;
				operations++;
			}
		}
		ans += add;
		System.out.println(ans);
	}
	static int test(int operations, long x , long y) {
		
		
		int multi = (int)Math.floor(Math.log(y/x)/Math.log(2));
		long multiple = x*(long)Math.pow(2, multi);
		long difference = y-multiple;
		
		int res = 0;
		
		for(long i = (long)Math.pow(2, multi); i>=1; i/=2) {
			res += difference/i;
			difference %= i;
		}
		
		return res+(int)multi+operations;
	}
}
