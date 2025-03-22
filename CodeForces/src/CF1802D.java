import java.util.*;
import java.io.*;

public class CF1802D {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n;
	static pair a[];
	static int maxLeft[];
	static TreeSet<Integer> v;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		
		t = Integer.parseInt(in.readLine());
		testcases:
		while(t-->0) {
			n = Integer.parseInt(in.readLine());
			
			a = new pair[n];
			v = new TreeSet<Integer>();
			maxLeft = new int[n+1];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				a[i] = new pair(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(a);
			
			for(int i=n-1; i>=0; i--) {
				maxLeft[i] = Math.max(a[i].second, maxLeft[i+1]);
			}maxLeft[n] = -1;
			
			int min = Integer.MAX_VALUE;
			
			int minSoFar = Integer.MAX_VALUE;
			int maxSoFar = -1;
			
			for(int i=0; i<n; i++) {
				
				int leftMax = a[i].first;
				int rightMax = maxLeft[i+1];
				
				if(leftMax==rightMax) {
					sb.append("0\n");
					continue testcases;
				}
				if(i!=n-1) {
					min = Math.min(min, Math.abs(leftMax-rightMax));
				}
				
				if(i>0) {
					if(v.contains(leftMax) && leftMax >= rightMax) {
						sb.append("0\n");
						continue testcases;
					}
					if(minSoFar<leftMax) {
						int lower = v.lower(leftMax);
						if(lower>=rightMax) {
							min = Math.min(min, Math.abs(leftMax-lower));
						}
					}
					if(maxSoFar>leftMax) {
						int higher = v.higher(leftMax);
						if(higher>=rightMax) {
							min = Math.min(min, Math.abs(leftMax-higher));
						}
					}
				}
				
				v.add(a[i].second);
				minSoFar = Math.min(minSoFar, a[i].second);
				maxSoFar = Math.max(maxSoFar, a[i].second);
			}
			sb.append(min).append("\n");
		}
		System.out.print(sb);
	}
	
	static class pair implements Comparable<pair> {
		int first, second;
		public pair(int a, int b) {
			this.first = a;
			this.second = b;
		}
		public String toString() {
			return first+" "+second;
		}
		@Override
		public int compareTo(pair o) {
			if(this.first==o.first) {
				return this.second-o.second;
			}
			return this.first-o.first;
		}
		
	}
}
