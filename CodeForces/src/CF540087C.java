import java.util.*;
import java.io.*;

public class CF540087C {
	
	static int n;
	static int h[], b[];
	static building a[];
	static HashSet<Integer> idx;
	static long ans;
	static BufferedReader in;
	static StringTokenizer st1, st2;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		st1 = new StringTokenizer(in.readLine());
		st2 = new StringTokenizer(in.readLine());
		
		a = new building[n];
		h = new int[n];
		b = new int[n];
		idx = new HashSet<Integer>();
		
		for(int i=0; i<n; i++) {
			h[i] = Integer.parseInt(st1.nextToken());
			b[i] = Integer.parseInt(st2.nextToken());
			a[i] = new building(h[i], b[i], i);
			idx.add(i);
		}
		Arrays.sort(a);
		
		for(building i: a) {
			if(!idx.contains(i.idx)) continue; 
			int beauty = i.beauty;
			int index=i.idx;
			int l = index-1;
			int r = index+1;
			while(l>=0) {
				if(!idx.contains(l)) break;
				if(b[l]<=0) {
					idx.remove(l);
					l--;
				}
				else {
					break;
				}
			}
			while(r<n) {
				if(!idx.contains(r)) break;
				if(b[r]<=0) {
					idx.remove(r);
					r++;
				}
				else {
					break;
				}
			}
//			System.out.println(idx);
			ans += (long)beauty;
		}
		System.out.println(ans);
		
	}
	
	
	static class building implements Comparable<building> { 
		int height, beauty, idx;
		public building(int a, int b, int c) {
			this.height = a;
			this.beauty = b;
			this.idx = c;
		}
		@Override
		public int compareTo(building that) {
			return this.height - that.height;
		}
		
	}
}
