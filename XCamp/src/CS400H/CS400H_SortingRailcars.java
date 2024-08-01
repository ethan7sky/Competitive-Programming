package CS400H;
import java.util.*;
import java.io.*;

public class CS400H_SortingRailcars {
	
	static int n;
	static ArrayList<Integer> a;
	static BufferedReader in;
	static StringTokenizer st;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		a = new ArrayList<Integer>();
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		int curr=1;
		while(curr<=n) {
			int cnt=0;
			for(int i=0; i<a.size(); i++) {
				if(a.get(i)==curr) {
					curr++;
					cnt++;
					a.remove(i);
					i--;
				}
			}
			min = Math.min(min, n-cnt);
//			for(int i=0; i<n; i++) {
//				if(a[i]==curr) {
//					curr++;
//					cnt++;
//				}
//				min = Math.min(min, n-cnt);
//			}
		}
//		for(int i=0; i<n; i++) {
//			if(a[i]==curr) curr++;
//		}
//		min = n-(curr-1);
//		curr = n;
//		for(int i=n-1; i>=0; i--) {
//			if(a[i]==curr) curr--;
//		}
//		min = Math.min(min, curr);
		System.out.println(min);
	}
}
