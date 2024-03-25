import java.util.*;
import java.io.*;

public class SumOfThreeValues {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		pair[] a = new pair[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = new pair(Integer.parseInt(st.nextToken()), i);
		}
		Arrays.sort(a);
		
		boolean found = false;
		search:
		for(int i=0; i<n; i++) {
			int target = x-a[i].val;
			int idx = a[i].idx;
			
			int s=0, e=n-1;
			
			while(s<e) {
				if(a[s].val+a[e].val==target&&a[s].idx!=idx&&a[e].idx!=idx) {
					System.out.println(idx+1+" "+(a[s].idx+1)+" "+(a[e].idx+1));
					found = true;
					break search;
				}
				if(a[s+1].val+a[e].val > target) {
					e--;
				}
				else {
					s++;
				}
			}
		}
		if(!found) System.out.println("IMPOSSIBLE");
		
		
	}
	static class pair implements Comparable<pair> {

		int val, idx;
		pair(int a, int b){
			val = a;
			idx = b;
		}
		
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.val-o.val;
		}
		
		public String toString() {
			return val+"="+idx;
		}
		
	}
	
}
