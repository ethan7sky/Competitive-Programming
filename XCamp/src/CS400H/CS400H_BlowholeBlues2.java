package CS400H;
import java.util.*;
import java.io.*;

public class CS400H_BlowholeBlues2 {
	
	static int t, n, k, ans;
	static int[] a;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder res;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		res = new StringBuilder();
		while(t-->0) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			a = new int[n];
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			int l=0;
			int r=0;
			int currIdx = 0;
			int min = n+1;
			while(currIdx<n) {
				while(l<currIdx && a[currIdx]-a[l] > k) {
					l++;
				}
				while(r<n&&Math.abs(a[r]-a[currIdx])<=k) {
					r++;
				}
				min = Math.min(min, l+(n-r));
				currIdx++;
			}
			res.append(min).append("\n");
		}
		System.out.print(res);
		
	}
}
