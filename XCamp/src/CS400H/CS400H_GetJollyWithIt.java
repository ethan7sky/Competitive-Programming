package CS400H;
import java.util.*;
import java.io.*;

public class CS400H_GetJollyWithIt {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n;
	static pair a[];
	static TreeMap<Integer, Integer> notv;
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
			notv = new TreeMap<Integer, Integer>();
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				a[i] = new pair(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
				notv.put(a[i].second, notv.getOrDefault(a[i].second, 0)+1);
			}
			Arrays.sort(a);
			
			int min = Integer.MAX_VALUE;
			
			for(int i=0; i<n; i++) {
				
				int leftMax = a[i].first;
				
				notv.put(a[i].second, notv.get(a[i].second)-1);
				if(notv.get(a[i].second)==0) notv.remove(a[i].second);
				
				int rightMax = 0;
				
				if(!notv.isEmpty()) {
					rightMax = notv.lastKey();
					min = Math.min(min, Math.abs(leftMax-rightMax));
				}
				
				if(v.size()>0) {
					if(v.contains(leftMax) && leftMax >= rightMax) {
						sb.append("0\n");
						continue testcases;
					}
					if(v.first()<leftMax) {
						int lower = v.lower(leftMax);
						if(lower>=rightMax) {
							min = Math.min(min, Math.abs(leftMax-lower));
						}
					}
					if(v.last()>leftMax) {
						int higher = v.higher(leftMax);
						if(higher>=rightMax) {
							min = Math.min(min, Math.abs(leftMax-higher));
						}
					}
				}
				
				
				v.add(a[i].second);
				
				
			
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
