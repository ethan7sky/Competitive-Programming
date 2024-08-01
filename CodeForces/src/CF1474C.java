import java.util.*;
import java.io.*;

public class CF1474C {
	
	static int t, n, a[];
	static HashMap<Integer, ArrayList<pair>> sums;
	static HashMap<Integer, Integer> pool;
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
			
			sums = new HashMap<Integer, ArrayList<pair>>();
			pool = new HashMap<Integer, Integer>();
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<i; j++) {
					int sum = a[i]+a[j];
					if(!sums.containsKey(sum)) sums.put(sum, new ArrayList<pair>());
					sums.get(sum).add(new pair(a[i], a[j])); 
				}
			}
			
			for(int i: a) {
				if(pool.containsKey(i)) pool.put(i, pool.get(i)+1);
				else pool.put(i, 1);
			}
			
			if(!findPath(a[n-1], new Stack<pair>())) {
				System.out.println("NO");
			}
		}
		
	}
	static void printAns(Stack<pair> path) {
		System.out.println("YES");
		int idx=0;
		int[] vals = new int[2];
		for(int i: pool.keySet()) {
			vals[idx] = i;
			idx++;
		}
		System.out.println(vals[0]+vals[1]);
		System.out.println(vals[0]+" "+vals[1]);
		for(pair i: path) {
			System.out.println(i.toString());
		}
	}
	static boolean findPath(int lastMax, Stack<pair> path) {
		
		
		if(pool.size()==2) {
			printAns(path);
			return true;
		}
		
		if(!sums.containsKey(lastMax)) return false;
		
		for(pair i: sums.get(lastMax)) {
			
			if(!poolContains(i.a, i.b)) continue; 
			
			path.add(i);
			remove(i.a);
			remove(i.b);
			
			if(findPath(Math.max(i.a, i.b), path)) {
				return true;
			}
			
			path.remove(i);
			add(i.a);
			add(i.b);
		}
		return false;
	}
	
	static boolean poolContains(int a, int b) {
		if(a==b) {
			return pool.containsKey(a) && pool.get(a)>=2;
		}
		else {
			return pool.containsKey(a) && pool.get(a)>=1
					&& pool.containsKey(b) && pool.get(b)>=1;
		}
	}
	
	static void remove(int x) {
		pool.put(x, pool.get(x)-1);
		if(pool.get(x)==0) pool.remove(x);
	}
	static void add(int x) {
		if(pool.containsKey(x)) pool.put(x, pool.get(x)+1);
		else pool.put(x, 1);
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
