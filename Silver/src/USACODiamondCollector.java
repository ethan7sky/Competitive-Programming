import java.util.*;
import java.io.*;

public class USACODiamondCollector {
	
	static int n, k;
	static int[] a;
	static int[] maxForwards, maxBackwards;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("diamond.in"));
		out = new PrintWriter("diamond.out");
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n];
		
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(in.readLine());
		
		Arrays.sort(a);
		
		maxForwards = twoPointer(0, 1);
		maxBackwards = twoPointer(n-1, -1);
		
		int ans = 0;
		for(int i=0; i<n-1; i++) {
			ans = Math.max(maxForwards[i]+maxBackwards[i+1], ans);
		}
		ans = Math.max(ans, maxBackwards[0]);
		ans = Math.max(ans, maxForwards[n-1]);
		
		out.println(ans);
		
		in.close();
		out.close();
	}
	
	static int[] twoPointer(int idx, int step) {
		
		int s = idx;
		int e = idx;
		
		int[] ans = new int[n];
		
		while(true) {
			if(Math.abs(a[e]-a[s])>k) s+=step;
			if(Math.abs(a[e]-a[s])<=k) {
				if(e-step<0 || e-step>=n) ans[e] = Math.abs(s-e)+1;
				else ans[e] = Math.max(ans[e-step], Math.abs(s-e)+1);
				e+=step;
			}
			if(e<0&&step==-1||e>=n&&step==1) break;
		}
		return ans;
	}
}
