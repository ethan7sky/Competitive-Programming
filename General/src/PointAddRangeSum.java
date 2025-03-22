import java.util.*;
import java.io.*;

public class PointAddRangeSum {
	
	
	static long BIT[], arr[];
	static int n, q;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		BIT = new long[n+1];
		arr = new long[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			set(i, Integer.parseInt(st.nextToken()));
		}
		
		sb = new StringBuilder();
		while(q-->0) {
			st = new StringTokenizer(in.readLine());
			
			int t, a, b;
			t = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(t==1) {
				sb.append(rangeSum(a+1, b))
				.append("\n");
			}else {
				add(a, b);
			}
		}
		System.out.print(sb);
	}
	
	static void set(int i, long v) {
		add(i, v-arr[i]);
	}
	
	static void add(int i, long v) {
		arr[i] += v;
		i++;
		for(; i<=n; i+=i&-i) {
			BIT[i] += v;
		}
	}
	
	static long rangeSum(int s, int e) {
		return sum(e) - sum(s-1);
	}
	static long sum(int i) {
		long ans = 0;
		for(; i>0;  i-=i&-i) {
			ans += BIT[i];
		}
		return ans;
	}

}
