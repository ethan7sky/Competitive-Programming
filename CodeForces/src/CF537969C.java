import java.util.*;
import java.io.*;

public class CF537969C {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static long a[], bit1[], bit2[];
	static int n, q;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		a = new long[n+1];
		bit1 = new long[n+1];
		bit2 = new long[n+1];
		
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++) {
			long x = Long.parseLong(st.nextToken());
			a[i] = x;
			update(bit1, i, (long)i*x);
			update(bit2, i, x);
		}
		
		sb = new StringBuilder();
		while(q-->0){
			st = new StringTokenizer(in.readLine());
			int t = Integer.parseInt(st.nextToken());
			if(t==1) {
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				long p1 = calc(bit1, r) - calc(bit1, l-1);
				long p2 = (l-1)*(calc(bit2,r) - calc(bit2, l-1));
				sb.append(p1-p2).append("\n");
			}
			if(t==2) {
				int i = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				update(bit1, i, -(long)i*a[i]);
				update(bit1, i, (long)x*i);
				update(bit2, i, -a[i]);
				update(bit2, i, x);
				a[i] = x;
			}
		}
		System.out.print(sb);
		
		
	}
	static long calc(long[] bit, int idx) {
		long ans = 0;
		while(idx > 0) {
			ans += bit[idx];
			idx -= idx&-idx;
		}
		return ans;
	}
	
	static void update(long[] bit, int idx, long val) {
		while(idx <= n) {
			bit[idx] += val;
			idx += idx&-idx;
		}
	}
}
