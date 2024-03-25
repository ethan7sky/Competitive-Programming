import java.util.*;
import java.io.*;

public class CF1288D {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, a[][], col[][];
	static int min, max, minval;
	static ArrayList<idxs[]> sorted;
	static HashSet<Integer> ans;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
	}
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n][m];
		col = new int[m][n];
		
		min = Integer.MAX_VALUE;
		max = -1;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<m; j++) {
				int temp = Integer.parseInt(st.nextToken());
				a[i][j] = temp;
				col[j][i] = temp;
				min = Math.min(min, temp);
				max = Math.max(max, temp);
			}
		}
		
		sorted = new ArrayList<idxs[]>();		
		for(int i=0; i<m; i++) {
			idxs temp[] = new idxs[n];
			for(int j=0; j<n; j++) temp[j] = new idxs(a[j][i], j);
			Arrays.sort(temp);
			sorted.add(temp);
		}
		for(int i=0; i<m; i++) {
			System.out.println(Arrays.toString(sorted.get(i)));
		}
		
		
		HashSet<Integer> ans = new HashSet<Integer>();
		
		int l1 = min;
		int r1 = max;
		while(l1 <= r1) {
			minval = (l1+r1)/2;
			System.out.println("minval = "+minval);
			HashSet<Integer> possible = new HashSet<Integer>();
			
			for(int i=0; i<m; i++) {
				
				//binary search
				int idx = search(sorted.get(i), 0, n-1, minval);
				
				HashSet<Integer> temp = new HashSet<Integer>();
				for(int j=idx; j<n; j++) {
					int id = sorted.get(i)[j].idx;
					if(i==0 || possible.contains(id)) temp.add(id);
				}
				System.out.println("tempura = "+temp);
				possible.clear();
				possible.addAll(temp);
			}
			System.out.println("possible pairs are "+possible);
			if(possible.size()>=2) {
				ans.clear();
				ans.addAll(possible);
				l1 = minval+1;
			}
			else {
				r1 = minval-1;
			}
		}
		System.out.println(ans);
		
	}
	static void solve() {
		
	}
	
	static class idxs implements Comparable<idxs> {
		
		int val, idx;
		
		idxs(int a, int b){
			val = a;
			idx = b;
		}
		
		public String toString() {
			return val+" "+idx;
		}
		
		@Override
		public int compareTo(CF1288D.idxs that) {
			// TODO Auto-generated method stub
			if(this.val==that.val) return this.idx-that.idx;
			return this.val-that.val;
		}
		
	}
	static int search(idxs[] vals, int low, int high, int key) {
		
		int mid=0;
		int ansidx = -1;
		while(low <= high) {
			mid=(low+high)/2;
			int value = vals[mid].val;
			
			if(value>=minval) {
				ansidx = mid;
				high=mid-1;
			}
			
			else if(value<minval) {
				low = mid+1;
			}
		}
		if(ansidx==-1) ansidx = low;
		return ansidx;
	}
}
