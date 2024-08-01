import java.util.*;
import java.io.*;

public class CF1474C2 {
	
	static int t, n, a[];
	static PriorityQueue<Integer> pool;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t=Integer.parseInt(in.readLine());
		while(t-->0) {
			
			n = Integer.parseInt(in.readLine())*2;
			st = new StringTokenizer(in.readLine());
			a = new int[n];
			for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(a);
			
			pool = new PriorityQueue<Integer>(Collections.reverseOrder());
			
			for(int i: a) pool.add(i);
			
			boolean works = false;
			for(int i: a) {
				
				if(i==a[n-1]) continue;
				
				pool.remove(i);
				pool.remove(a[n-1]);
				
				Stack<pair> path = new Stack<pair>();
				path.add(new pair(a[n-1], i));
				
				if(findPath(a[n-1], path)) {
					works = true;
					printAns(path);
					break;
				}
				
				pool.add(i);
				pool.add(a[n-1]);
			}
			if(!works) {
				System.out.println("NO");
			}
		}
	}
	
	static void printAns(Stack<pair> path) {
		StringBuilder sb = new StringBuilder();
		sb.append("YES\n");
		sb.append(path.get(0).a + path.get(0).b).append("\n");
		for(pair i: path) {
			sb.append(i.toString()).append("\n");
		}
		System.out.print(sb);
	}
	
	static boolean findPath(int lastMax, Stack<pair> path) {
		
		if(pool.isEmpty()) {
			return true;
		}
		
		int a = pool.poll();
		int b = lastMax-a;
		
		if(pool.contains(b)) {
			
			path.add(new pair(a, b));
			pool.remove(b);
			
			if(findPath(a, path)) {
				return true;
			}
			
			path.pop();
			pool.add(b);
			
		}
		pool.add(a);
		
		return false;
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
