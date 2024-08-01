package CS400H;
import java.util.*;
import java.io.*;

public class CS400H_BlowholeBlues {
	
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
			int min = n+1;
			if(n%2==0) {
				int cnt1=0;
				int cnt2=0;
				int median1 = a[n/2-1];
				int median2 = a[n/2];
				for(int i=0; i<n; i++){
					if(Math.abs(a[i]-median1)>k) cnt1++;
					if(Math.abs(a[i]-median2)>k) cnt2++;
				}
				min = Math.min(min, Math.min(cnt1, cnt2));
			}
			else {
				int cnt=0;
				int median = a[n/2];
				for(int i=0; i<n; i++) {
					if(Math.abs(a[i]-median)>k) cnt++;
				}
				min = Math.min(min, cnt);
			}
			res.append(min).append("\n");
		}
		System.out.print(res);
		
	}
}
