import java.util.*;
import java.io.*;

public class USACOCowCollege {
	
	static BufferedReader in;
	static int a[], n, maxcow;
	static long ans[];
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));

		init();
		
		int first = 1;
		int last = maxcow;
		int mid = (first+last)/2;
		
		while(first <= last) {
			
			int tuit1 = (mid+first)/2;
			int tuit2 = (int)Math.ceil((double)(mid+last)/2);
			
			long cnt1=0;
			long cnt2=0;
			long midcnt = 0;
		
			for(int i=0; i<n; i++) {
				if(a[i] >= tuit1) {
					cnt1++;
				}
				if(a[i] >= tuit2) {
					cnt2++;
				}
				if(a[i] >= mid) {
					midcnt++;
				}
			}
			
			//System.out.println(first+" "+mid+" "+last+" "+tuit1+"="+cnt1+" "+tuit2+"="+cnt2);
			
			cnt1 *= tuit1;
			cnt2 *= tuit2;
			midcnt *= mid;
			
			ans[mid] = midcnt;
			ans[tuit1] = cnt1;
			ans[tuit2] = cnt2;
			
			if(cnt2 == cnt1) {
				first = tuit1;
				last = tuit2;
			}			
			if(cnt2>cnt1) {
				first = mid+1;
			}
			else {
				last = mid-1;
			}
			mid = (first+last)/2;
		}
		
		long res = 0;
		int idx = 0;
		for(int i=0; i<=maxcow; i++) {
			res = Math.max(ans[i], res);
		}
		for(int i=0; i<=maxcow; i++) {
			if(ans[i] == res) {
				idx=i;
				break;
			}
		}
		
		System.out.println(res+" "+ idx);
	}
	static void init() throws IOException {

		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		
		a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			maxcow = Math.max(maxcow, a[i]);
		}
		ans = new long[maxcow+1];
		
	}
}
