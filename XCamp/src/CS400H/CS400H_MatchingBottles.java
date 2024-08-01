package CS400H;
import java.util.*;
import java.io.*;

public class CS400H_MatchingBottles {
	
	static int t, n, sum;
	static pair[] a;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		while(t-->0) {
			n = Integer.parseInt(in.readLine());
			a = new pair[n];
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<n; i++) {
				a[i] = new pair(Integer.parseInt(st.nextToken()), i+1);
			}
			Arrays.sort(a);
			sum=0;
			for(int i=0; i<n; i++) {
				sum += (n-i)*a[i].val;
			}
			sb.append(sum).append("\n");
			for(int i=0; i<n-1; i++) {
				sb.append(a[i].idx).append(" ");
			}sb.append(a[n-1].idx).append("\n");
		}
		System.out.print(sb);
		
	}
	
	static class pair implements Comparable<pair> {
		int val, idx;
		public pair(int a, int b) {
			this.val = a;
			this.idx = b;
		}
		@Override
		public int compareTo(pair that) {
			return this.val-that.val;
		}
	}
	
}
