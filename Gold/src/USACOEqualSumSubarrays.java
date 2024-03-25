import java.util.*;
import java.io.*;

public class USACOEqualSumSubarrays {
	
	static int n;
	static long[] a;
	static long[] p;
	static HashMap<pair, Long> sums;
	static TreeSet<Long> include, exclude;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		a = new long[n];
		sums = new HashMap<pair, Long>();
		include = new TreeSet<Long>();
		exclude = new TreeSet<Long>();
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}
		
		p = new long[n+1];
		for(int i=1; i<=n; i++) {
			p[i] = p[i-1]+a[i-1];
		}
		
		for(int s=0; s<n; s++) {
			for(int e=s; e<n; e++) {
				sums.put(new pair(s, e), p[e+1]-p[s]);
				exclude.add(sums.get(new pair(s, e)));
			}
		}
//		System.out.println(sums);
//		
//		System.out.println(include);
//		System.out.println(exclude);
		
		for(int i=0; i<n; i++) {
			for(int s=0; s<i; s++) {
				long sum = sums.get(new pair(s, i-1));
				include.remove(sum);
				exclude.add(sum);
			}
			for(int e=i; e<n; e++) {
				long sum = sums.get(new pair(i, e));
				include.add(sum);
				exclude.remove(sum);
			}
			
			List<Long> a1 = new ArrayList<Long>();
			a1.addAll(include);
			List<Long> a2 = new ArrayList<Long>();
			a2.addAll(exclude);
			
			long ans = findMinDifference(a1, a2);
			System.out.println(ans);
		}
	}
	static long findMinDifference(List<Long> a, List<Long> b) {
		
		int aIdx = 0;
		int bIdx = 0;
		
		long ans = Long.MAX_VALUE;
		
		int aSize = a.size();
		int bSize = b.size();
		
		while(aIdx<aSize && bIdx<bSize) {
			if(Math.abs(a.get(aIdx)-b.get(bIdx)) < ans) {
				ans = Math.abs(a.get(aIdx)-b.get(bIdx));
			}
			
			if(a.get(aIdx) < b.get(bIdx)) aIdx++;
			else bIdx++;
		}
		
		return ans;
	} 
	
	static class pair {
		int s, e;
		int hashCode;
		
		public pair(int a, int b) {
			s = a;
			e = b;
			hashCode = Objects.hash(s, e);
		}
		
		public String toString() {
			return s+"-"+e;
		}
		
		@Override
		public boolean equals(Object o) {
			if(this==o) return true;
			if(o==null || getClass() != o.getClass()) return false;
			pair that = (pair) o;
			return this.s==that.s && this.e==that.e;
		}
		
		@Override
		public int hashCode() {
			return this.hashCode;
		}
	}
}
