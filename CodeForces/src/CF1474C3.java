import java.util.*;
import java.io.*;

public class CF1474C3 {
	
	static int t, n;
	static TreeMap<Integer, Integer> nums, pool;
	static Stack<pair> path;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(in.readLine());
		
		testcases:
		while(t-->0) {
			
			n = Integer.parseInt(in.readLine())*2;
			st = new StringTokenizer(in.readLine());
			
			nums = new TreeMap<Integer, Integer>();	
			for(int i=0; i<n; i++) {
				int x = Integer.parseInt(st.nextToken());
				nums.put(x, nums.getOrDefault(x, 0)+1);
			}
			
			int max = nums.lastKey();
			nums.put(max, nums.get(max)-1);
			if(nums.get(max)==0) nums.remove(max);
			
			search:
			for(int i: nums.keySet()) {

				pool = new TreeMap<>(nums);
				removeFromPool(i);
				
				path = new Stack<pair>();
				path.push(new pair(i, max));
				
				int lastMax = max;
				
				for(int j=0; j<n/2-1; j++) {
					
					int a = pool.lastKey();
					removeFromPool(a);
					
					int b = lastMax - a;
					if(!pool.containsKey(b)) continue search;
					removeFromPool(b);
					
					path.push(new pair(a, b));
					lastMax = a;
				}
				
				printAns(path);
				continue testcases;
			}
			
			System.out.println("NO");
		}
	}
	
	static void printAns(Stack<pair> path) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("YES\n");
		sb.append(path.get(0).a + path.get(0).b).append("\n");
		for(pair i: path) sb.append(i.toString()).append("\n");
		
		System.out.print(sb);
		
	}
	
	static void removeFromPool(int x) {
		pool.put(x, pool.get(x)-1);
		if(pool.get(x)==0) pool.remove(x);
	}
	
	static class pair {
		int a, b;
		pair(int x, int y) {
			this.a = x;
			this.b = y;
		}
		public String toString() {
			return a+" "+b;
		}
	}
	
}
