import java.util.*;
import java.io.*;

public class CF539266A {
	
	static int n, m;
	static TreeMap<Integer, vessel> a;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] maxCapacity;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		a = new TreeMap<Integer, vessel>();
		st = new StringTokenizer(in.readLine());
		maxCapacity = new int[n+1];
		for(int i=1; i<=n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			a.put(i, new vessel(0, temp));
			maxCapacity[i] = temp;
		}
		m = Integer.parseInt(in.readLine());
		
		sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int t = Integer.parseInt(st.nextToken());
			if(t==1) {
				int p = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				while(x>0) {
					if(a.ceilingKey(p)==null) break;
					int idx = a.ceilingKey(p);
					if(x + a.get(idx).volume < a.get(idx).maxCapacity) {
						a.get(idx).volume += x;
						break;
					}
					else {
						x -= a.get(idx).maxCapacity - a.get(idx).volume;
						a.remove(idx);
					}
				}
			}
			else if(t==2) {
				int k = Integer.parseInt(st.nextToken());
				if(!a.containsKey(k)) sb.append(maxCapacity[k]).append("\n");
				else {
					sb.append(a.get(k).volume).append("\n");
				}
			}
		}
		System.out.print(sb);
		
	}
	
	static class comparator implements Comparator<vessel> {
		@Override
		public int compare(vessel a, vessel b) {
			// TODO Auto-generated method stub
			return a.idx-b.idx;
		}
	}
	
	static class vessel {
		int idx, volume, maxCapacity;
		public vessel(int a, int b) {
			this.volume = a;
			this.maxCapacity = b;
		}
		public vessel(int a, int b, int c) {
			this.idx = a;
			this.volume = b;
			this.maxCapacity = c;
		}
	}
}
