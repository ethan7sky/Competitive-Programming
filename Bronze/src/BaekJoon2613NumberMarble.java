import java.util.*;
import java.io.*;

public class BaekJoon2613NumberMarble {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, sum, a[], ans,low, high;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();		
	}
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		a = new int[n];
		sum=0;
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			sum += a[i];
		}
		ans = 1;
		
		low = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			low = Math.max(low, a[i]);
			high += a[i];
		}
	}
	static void solve() {
		
		int mid;
		while(low <= high) {
			mid = (low+high)/2;
			if(check(mid)) {
				ans = mid;
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		System.out.println(ans);
		
		int s = 0;
		int t = 0;
		for(int i=0; i<n; i++) {
			s += a[i];
			if(s>ans) {
				s = a[i];
				m--;
				System.out.print(t+" ");
				t=0;
			}
			t++;
			if(n-i == m) break;
		}
		
		while(m-- > 0) {
			System.out.print(t+" ");
			t=1;
		}
	
	}	
	static boolean check(int mid) {
		
		int currsum = 0;
		int cnt = 1;
		
		for(int i=0; i<n; i++) {
			if(currsum + a[i] <= mid) {
				currsum += a[i];
			}
			else {
				currsum = a[i];
				cnt++;
			}
		}
		
		return cnt <= m;
	}	
}
