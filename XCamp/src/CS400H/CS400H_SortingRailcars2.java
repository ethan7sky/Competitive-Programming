package CS400H;
import java.util.*;
import java.io.*;

public class CS400H_SortingRailcars2 {
	
	static int n;
	static HashSet<Integer> seen;
	static int[] a;
	static int[] ans;
	static BufferedReader in;
	static StringTokenizer st;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		seen = new HashSet<Integer>();
		ans = new int[n+1];
		for(int i=0; i<n; i++) {
			if(seen.contains(a[i]-1)) {
				ans[a[i]] = ans[a[i]-1]+1;
			}
			else {
				ans[a[i]] = 1;
			}
			seen.add(a[i]);
		}
		for(int i=1; i<n+1; i++) {
			min = Math.min(min, n-ans[i]);
		}
		System.out.println(min);
	}
}
