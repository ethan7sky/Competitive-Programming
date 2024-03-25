import java.util.*;
import java.io.*;

public class USACOBessiesInterview {
	
	static int n, k;
	static long currTime;
	static TreeMap<Long, ArrayList<Integer>> farmers;
	//key is time, values are ids of cows
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		farmers = new TreeMap<Long, ArrayList<Integer>>();
		
		st = new StringTokenizer(in.readLine());
		//init
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<k; i++) {
			Long temp = Long.parseLong(st.nextToken());
			if(!farmers.containsKey(temp)) farmers.put(temp, new ArrayList<Integer>());
			farmers.get(temp).add(i);
		}
		DSU union = new DSU(k);
		
		ArrayList<Integer> search = farmers.get(farmers.firstKey());
		int toUnifyTo = search.get(0);
		for(int i=1; i<search.size(); i++) {
			union.unify(toUnifyTo, search.get(i));
		}
//		System.out.println(farmers);
//		System.out.println(Arrays.toString(union.parent));
		
		
		currTime = 0;
		while(st.hasMoreTokens()) {
			currTime = farmers.firstKey();
			int removeCnt = 0;
			for(int toRemove: farmers.get(farmers.firstKey())) {
				if(st.hasMoreTokens()) {
					Long newVal = Long.parseLong(st.nextToken()) + currTime;
					if(!farmers.containsKey(newVal))
						farmers.put(newVal, new ArrayList<Integer>());
					farmers.get(newVal).add(toRemove);
					removeCnt++;
				}
			}
			if(removeCnt == farmers.get(farmers.firstKey()).size()) {
				farmers.remove(farmers.firstKey());	
			}
			else {
				for(int i=0; i<removeCnt; i++) {
					farmers.get(farmers.firstKey()).remove(0);
				}
			}
			
			search = farmers.get(farmers.firstKey());
			toUnifyTo = search.get(0);
			for(int i=1; i<search.size(); i++) {
				union.unify(toUnifyTo, search.get(i));
			}
		}
		
		System.out.println(farmers.firstKey());
		System.out.println(union.printStringWithParents(union.find(farmers.get(farmers.firstKey()).get(0))));
		
	}
	static class DSU {
		
		private int size;
		private int[] sz;
		private int[] parent;
		private int numComponents;
		
		public DSU(int size) {
			
			this.size = numComponents = size;
			sz = new int[size];
			parent = new int[size];
			
			for(int i=0; i<size; i++) {
				parent[i] = i;
				sz[i] = 1;
			}
		}
		public String printStringWithParents(int p) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<size; i++) {
				if(find(i)==p) sb.append(1);
				else sb.append(0);
			}
			return sb.toString();
		}
		
		
		public int find(int p) {
			
			int root = p;
			while(root != parent[root]) {
				root = parent[root];
			}
			
			while(p!=root) {
				int to = parent[p];
				parent[p] = root;
				p = to;
			}
			return root;
		}
		public void unify(int p, int q) {
			
			int root1 = find(p);
			int root2 = find(q);
			
			if(root1==root2) return;
			
			if(sz[root1] < sz[root2]) {
				sz[root2] += sz[root1];
				parent[root1] = root2;
			} 
			else {
				sz[root1] += sz[root2];
				parent[root2] = root1;
			}
			
			numComponents--;
		}
	}

}
