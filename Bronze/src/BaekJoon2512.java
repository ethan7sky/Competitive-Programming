import java.util.*;
import java.io.*;

public class BaekJoon2512 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, a[], max, ans, maxint;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			maxint = Math.max(maxint, a[i]);
		}
		
		max = Integer.parseInt(in.readLine());
		
		int low=0;
		int high=maxint;
		int mid;
		while(low <= high) {
			
			mid = (low+high)/2;
			if(check(mid)) {
				ans = mid;
				low = mid+1;
			}
			else high = mid-1;
		}
		System.out.println(ans);
			
	}
	static boolean check(int mid) {
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += Math.min(a[i], mid);
		}
		return sum <= max;
	}
}
