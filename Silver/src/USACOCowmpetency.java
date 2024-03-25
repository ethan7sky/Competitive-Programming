import java.util.Arrays;
import java.util.*;
import java.io.*;

public class USACOCowmpetency {
	
	static int t;
	static int n, q, c, a[];
	static pair[] pairs;
	static Queue<Integer> zeros;
	static BufferedReader in;
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			init();
			solve();
		}
	}
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		a = new int[n+1];
		st = new StringTokenizer(in.readLine());
		zeros = new ArrayDeque<Integer>();
		for(int i=1; i<=n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			if(a[i]==0) zeros.add(i);
		}
		pairs = new pair[q];
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(in.readLine());
			pairs[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(pairs);
		System.out.println();
	}
	static void solve() {
		
		FenwickTreeMax BIT = new FenwickTreeMax(a);
		BIT.init();
		
		
		for(pair query: pairs) {

			
			while(zeros.peek()<=query.s&&zeros.peek()<query.e) {
				int idx = zeros.poll();
				System.out.println(idx);
				a[idx] = 1;
				BIT.update(idx, 1);
				System.out.println(Arrays.toString(a));
			}
			
			int smax = BIT.findMaximumUpToIdx(query.s);
			int emax = BIT.findMaximumUpToIdx(query.e-1);
			
			System.out.println(query.toString()+" "+smax+" "+emax);
			
			if(emax>smax) {
				System.out.println(-1);
				return;
			}
			
			if(a[query.e]==0) {
				if(emax+1>c) {
					System.out.println(-1);
					return;
				}
				BIT.update(query.e, emax+1);
				a[query.e]=emax+1;
				if(zeros.peek() == query.e) zeros.poll(); 
			}
			else {
				if(a[query.e]<=smax) {
					System.out.println(-1);
					return;
				}
			}
			System.out.println(Arrays.toString(a)+"\n");
		}
		
		System.out.println(BIT.toString());
		
		System.out.println(Arrays.toString(a));
	}
	
	static class FenwickTreeMax {
		
		int a[], bit[];
		int LENGTH;
		
		FenwickTreeMax(int[] array){
			this.a = array.clone();
			this.LENGTH = array.length;
			this.bit = array.clone();
		}
		
		public void init() {
			for(int i=1; i<LENGTH; i++) {
				int next = i+(i&-i);
				if(next<LENGTH) {
					bit[next] = Math.max(bit[next], bit[i]);
				}
			}
		}
		
		public String toString() {
			return Arrays.toString(a)+"\n"+Arrays.toString(bit);
		}
		
		public int findMaximumUpToIdx(int idx) {
			int ans = Integer.MIN_VALUE;
			while(idx!=0) {
				ans = Math.max(ans, bit[idx]);
				idx -= idx&-idx;
			}
			return ans;
		}
		public void update(int idx, int val) {
			while(idx<LENGTH) {
				bit[idx] = Math.max(bit[idx], val);
				idx += idx&-idx;
			}
		}
	}
	
	static class pair implements Comparable<pair> {
		
		int s, e;
		pair(int a, int b){
			this.s = a;
			this.e = b;
		}
		
		public String toString() {
			return s+":"+e;
		}
		
		@Override
		public int compareTo(pair that) {
			// TODO Auto-generated method stub
			if(this.e == that.e) return that.s-this.s;
			return this.e-that.e;
		}
		
	}
}
