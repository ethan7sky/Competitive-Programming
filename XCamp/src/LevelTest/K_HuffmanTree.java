package LevelTest;
import java.util.*;
import java.io.*;

public class K_HuffmanTree {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, currId;
	static PriorityQueue<node> weights;
	static HashMap<Integer, pair> c;
	static long ans=0;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		weights = new PriorityQueue<node>(new comparator());
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			weights.add(new node(currId, Integer.parseInt(st.nextToken()), true));
			currId++;
		}

		if(n==1) {
			System.out.println(0);
			return;
		}
		
		c = new HashMap<Integer, pair>();
		
		while(weights.size()>1) {
			node a = weights.remove();
			node b = weights.remove();
			
			currId++;
			c.put(currId, new pair(a, b));
			weights.add(new node(currId, a.weight+b.weight, false));
		}
		
		findAns(currId, 0);
		
		System.out.println(ans);
	}
	static void findAns(int id, int depth) {
		pair curr = c.get(id);
		node a = curr.first;
		node b = curr.second;
		
		if(a.isLeaf) {
			ans += a.weight*(depth+1);
		}
		else {
			findAns(a.id, depth+1);
		}
		if(b.isLeaf) {
			ans += b.weight*(depth+1);
		}
		else {
			findAns(b.id, depth+1);
		}
	}
	static class node {
		int id, weight;
		boolean isLeaf;
		public node(int a, int b, boolean c) {
			this.id = a;
			this.weight = b;
			this.isLeaf = c;
		}
	}
	static class pair {
		node first, second;
		public pair(node a, node b) {
			this.first = a;
			this.second = b;
		}
		public String toString() {
			return first.weight+" "+second.weight;
		}
	}
	static class comparator implements Comparator<node> {
		
		public int compare(node x, node y) {
			return x.weight-y.weight;
		}
	}
}
