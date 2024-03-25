import java.util.*;
import java.io.*;

public class Problem1 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, k;
	static int ans;	
	static ArrayList<Integer> weights;
	static HashMap<Integer, Integer> remaining;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		weights = new ArrayList<Integer>();
		remaining = new HashMap<Integer, Integer>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			weights.add(a);
			remaining.put(a, b);
			ans += b;
		}
		Collections.sort(weights, Collections.reverseOrder());
		
}
	static void solve() {
		
		recurse(Integer.MAX_VALUE, m);
		
		for(int i: remaining.keySet()) {
			ans -= remaining.get(i);
		}
		System.out.println(ans);
	}
	static void recurse(int preval, int space) {
		
		if(space==0) return;
		
		int idx = binarySearch(preval-k);
		if(idx==-1) return;
		
		int currweight = weights.get(idx);
		int available = remaining.get(currweight);
		
		if(available<space) {
			remaining.remove(currweight);
			weights.remove(idx);
			recurse(currweight, available);
			recurse(preval, space-available);
		}
		else if(available>space){
			remaining.put(currweight, available-space);
			recurse(currweight, space);
		}
		else {
			remaining.remove(currweight);
			weights.remove(idx);
			recurse(currweight, available);
		}
		
	}
	static int binarySearch(int x) {
		//find index of x in weights
		if(weights.get(weights.size()-1) > x) return -1;
		int low = 0;
		int high = weights.size()-1;
		while(low < high) {
			int idx = (low+high)/2;
			if(x>weights.get(idx)) {
				high = idx;
			}
			else if(x<weights.get(idx)) {
				low = idx+1;
			}
			else {
				return idx;
			}
		}
		return low;
		
	}
	
}
