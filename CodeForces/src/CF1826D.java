import java.util.*;
import java.io.*;

public class CF1826D {
	
	static int t, n, a[];
	static ArrayList<pair> max;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			n = Integer.parseInt(in.readLine());
			a = new int[n];
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
			solve();
			System.out.println("----------");
		}
	}
	static void solve() {
		
		int ans = 0;
		max = new ArrayList<pair>();
		
		for(int i=0; i<n; i++) {
			
			//case 1: expand the array, replace the smallest maximum value
			//case 2: delete the first maximum value
			//case 3: delete the first and second maximum values, use the 4th max value
			//case 4: make a new array with only curr
			
			
		}
		System.out.println(max);
		
	}
	static int findmin(ArrayList<pair> e) {
		int min = Math.min(e.get(0).val, 
				Math.min(e.get(1).val, e.get(2).val));
		for(int i=0; i<3; i++) {
			if(e.get(i).val==min) return i;
		}
		return -1;
	}
	static class pair {
		int val, idx;
		pair(int a, int b){
			val = a;
			idx = b;
		}
		public String toString() {
			return val+" "+idx;
		}
	}
	
	
}
