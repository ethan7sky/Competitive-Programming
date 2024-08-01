package LevelTest;
import java.util.*;
import java.io.*;

public class L_IntersectionPoints {
	
	static BufferedReader in;
	static StringTokenizer st;
	
	static int MAX_N = 1000000;
	static ArrayList<vertex> a;
	static FenwickTree BIT;
	static long n, ans;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Long.parseLong(in.readLine());
		a = new ArrayList<vertex>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken())+MAX_N;
			int y1 = Integer.parseInt(st.nextToken())+MAX_N;
			int x2 = Integer.parseInt(st.nextToken())+MAX_N;
			int y2 = Integer.parseInt(st.nextToken())+MAX_N;
			
			if(x1==x2) {
				//vertical
				a.add(new vertex(x1, y1, x2, y2, false));
			}
			else {
				a.add(new vertex(x1, y1, x2, y2, true));
				a.add(new vertex(x2, y2, x1, y1, false));
			}
		}
		Collections.sort(a);
		
		ans = 0;
		
		BIT = new FenwickTree(new int[2*MAX_N+1]);
		for(vertex i: a) {
			if(i.dir==lineType.h) {
				if(i.isHorizontalStart) {
					BIT.update(i.y1, 1);
				}
				else {
					BIT.update(i.y1, -1);
				}
			}
			else {
				ans += BIT.rangeQuery(i.y1, i.y2);
			}
		}
		System.out.println(ans);
	}
	
	static class vertex implements Comparable<vertex> {
		
		int x1, y1, x2, y2;
		lineType dir;
		boolean isHorizontalStart;
		
		public vertex(int a, int b, int c, int d, boolean isHorizontalStart) {
			this.x1 = a;
			this.y1 = b;
			this.x2 = c;
			this.y2 = d;
			if(a==c) this.dir = lineType.v;
			else this.dir = lineType.h;
			this.isHorizontalStart = isHorizontalStart;
		}
		public String toString() {
			return x1+":"+y1+":"+x2+":"+y2+":"+(dir==lineType.h?"h":"v");
		}
		
		@Override
		public int compareTo(vertex that) { 
			if(this.x1==that.x1) {
				if(this.dir==lineType.h) {
					if(this.isHorizontalStart)return 1;
					else return -1;
				}
				if(this.dir==lineType.v) {
					return 1;
				}
				return 0;
			}
			return this.x1-that.x1;
		}
	}
	static enum lineType{
		h, v;
	}
	
	
	static class FenwickTree {
		
		int[] bit;
		int SIZE;
		
		FenwickTree(int[] array){
			this.bit = array.clone();
			this.SIZE = array.length;
		}
		
		public void init() {
			for(int i=1; i<SIZE; i++) {
				int next = i+(i&-i);
				if(next<SIZE) {
					bit[next] += bit[i];
				}
			}
		}
		public void update(int idx, int val) {
			while(idx<SIZE) {
				bit[idx] += val;
				idx += idx&-idx;
			}
		}
		public int query(int idx) {
			int sum=0;
			while(idx>0) {
				sum += bit[idx];
				idx -= idx&-idx;
			}
			return sum;
		}
		public int rangeQuery(int a, int b) {
			return query(b)-query(a-1);
		}
	}
}
