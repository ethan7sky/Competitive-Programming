import java.util.*;
import java.io.*;

public class CF104114N {
	
	static int[] a;
	static boolean[] v;
	static pair[] sorted;
	static int n, m;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		v = new boolean[n];
		sorted = new pair[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			int val = Integer.parseInt(st.nextToken());
			a[i] = val;
			sorted[i] = new pair(val, i);
		}
		
		Arrays.sort(sorted);
		
		for(pair i: sorted) {
			if(v[i.idx]) continue;
			else {
				recurse(i.val, i.idx+1, 1);
				recurse(i.val, i.idx-1, -1);
			}
		}
		
		StringBuilder ans = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			ans.append(a[i]);
			if(i!=n-1) ans.append(" ");
		}
		
		System.out.println(ans.toString());
	}
	static void recurse(int lastValue, int currIdx, int step) {
		
		if(outOfBounds(currIdx)) return;
		
		if(a[currIdx] >= lastValue-m) return;
		
		a[currIdx] = Math.max(a[currIdx], lastValue-m);
		//v[currIdx] = true;
		
		recurse(a[currIdx], currIdx+step, step);
	}
	
	static boolean outOfBounds(int idx) {
		if(idx<0 || idx>=n) return true;
		return false;
	}
	
	
	static class pair implements Comparable<pair>{ 
		int val, idx;
		public pair(int a, int b) {
			this.val = a;
			this.idx = b;
		}
		@Override
		public int compareTo(pair that) {
			return that.val-this.val;
		}
	}
}
