import java.util.*;
import java.io.*;

public class CF538367B {
	
	static int n, q;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static boolean v[];
	static int heights[];
	static cactus[] minHeights;
	static long[] p;
	static ArrayList<range> ranges;
	static range[] a;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		v = new boolean[n];
		minHeights = new cactus[n];
		heights = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			heights[i] = x;
			minHeights[i] = new cactus(i, x);
		}
		Arrays.sort(minHeights);
		
		ranges = new ArrayList<range>();
		
		for(cactus c: minHeights) {
			if(v[c.idx]) continue;
			
			findRange(c.idx);
		}
		
		Collections.sort(ranges);
		
		//create prefix sum of ranges
		
		int size = ranges.size();
		p = new long[size+1];
		a = new range[size];
		int idx=0;
		for(range i: ranges) {
			a[idx] = i;
			p[idx+1] = p[idx] + i.x;
			idx++;
		}
		
		sb = new StringBuilder();
		
		while(q-->0) {
			st = new StringTokenizer(in.readLine());
			int qL = Integer.parseInt(st.nextToken())-1;
			int qR = Integer.parseInt(st.nextToken())-1;
			
			//binary search for idx
			
			int leftAns = Integer.MAX_VALUE;
			int rightAns = -1;
			
			//find idx of first range with l >= qL
			int left = 0;
			int right = size-1;
			int mid=0;
			while(left<=right) {
				mid = (left+right)/2;
				if(a[mid].l > qL) {
					leftAns = mid;
					right = mid-1;
				}
				else {
					left = mid+1;
				}
			}
			
			//find idx of last range with r <= qR
			left = 0;
			right = size-1;
			while(left<=right) {
				mid = (left+right)/2;
				if(a[mid].r < qR) {
					rightAns = mid;
					left = mid+1;
				}
				else {
					right = mid-1;
				}
			}
			
			if(leftAns > rightAns) sb.append(0).append("\n");
			else {
				long ans = p[rightAns+1] - p[leftAns];
				sb.append(ans).append("\n");
			}
		}
		System.out.print(sb);
		
	}
	static void findRange(int idx) {
		
		v[idx] = true;
		
		int l = idx-1;
		int r = idx+1;
		
		if(l<0 || r>=n) return;
		if(heights[idx] > heights[l] || heights[idx] > heights[r]) return;
		
		long sum = Math.min(heights[l] - heights[idx], heights[r] - heights[idx]);
		int currWaterHeight = Math.min(heights[l], heights[r]);
		//System.out.println("currWaterHeight = "+currWaterHeight);
		int currLeftMaxHeight = heights[l];
		int currRightMaxHeight = heights[r];
		long cnt = 1;
		
		while(true) {
			if(l-1>=0 && heights[l-1]>=currLeftMaxHeight) {
				v[l] = true;
				l--;
				currLeftMaxHeight = heights[l];
				int newWaterHeight = Math.min(currLeftMaxHeight, currRightMaxHeight);
				cnt++;
				sum += (long)cnt*(newWaterHeight - currWaterHeight);
				currWaterHeight = newWaterHeight;			
			}
			else if(r+1 < n && heights[r+1] >= currRightMaxHeight) {
				v[r] = true;
				r++;
				currRightMaxHeight = heights[r];
				int newWaterHeight = Math.min(currLeftMaxHeight, currRightMaxHeight);
				cnt++;
				sum += (long)cnt*(newWaterHeight-currWaterHeight);
				currWaterHeight = newWaterHeight;
			}
			else break;
		}
		
		ranges.add(new range(l+1, r-1, sum));	
		
	}
	
	static class range implements Comparable<range> {
		int l, r;
		long x;
		public range(int a, int b, long c) {
			this.l = a;
			this.r = b;
			this.x = c;
		}
		@Override
		public int compareTo(range that) {
			return this.r - that.r;
		}
		public String toString() {
			return l+" "+r+" "+x;
		}
		
	}
	
	
	static class cactus implements Comparable<cactus> {
		int idx, height;
		public cactus(int a, int b) {
			this.idx = a;
			this.height = b;
		}
		@Override
		public int compareTo(cactus that) {
			return this.height - that.height;
		}
		
	}
}
