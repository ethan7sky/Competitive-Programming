import java.util.*;
import java.io.*;

public class USACODeforestation {

	static BufferedReader in;
	static StringTokenizer st;
	static int T, N, K;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(in.readLine());
		while(T-->0) {
			
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			

			TreeMap<Integer, Integer> diff = new TreeMap<Integer, Integer>();
			
			HashMap<Integer, Integer> trees = new HashMap<Integer, Integer>();
			
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++) {
				int x = Integer.parseInt(st.nextToken());
				trees.put(x, trees.getOrDefault(x, 0)+1);
			}
			
			range[] ranges = new range[K];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(in.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				ranges[i] = new range(l, r, t);
				diff.put(l, diff.getOrDefault(l, 0)+1);
				diff.put(r+1, diff.getOrDefault(r+1, 0)-1);
			}
			
			for(int i: trees.keySet()) {
				if(!diff.containsKey(i)) {
					diff.put(i, 2*(int)1e9-trees.get(i));
				}
			}
			
			ArrayList<pair> sortedTrees = new ArrayList<pair>(); // #overlap, position
			
			int currRangeCnt = 0;
			for(int i: diff.keySet()) {
				int k = diff.get(i);
				if(Math.abs(2*(int)1e9-k) <= (int)1e5) {
					for(int j=k; j<2*(int)1e9; j++) {
						 sortedTrees.add(new pair(currRangeCnt, i));
					}
				} else {
					currRangeCnt += k;
					if(trees.containsKey(i)) {
						for(int j=0; j<trees.get(i); j++) {
							sortedTrees.add(new pair(currRangeCnt, i));
						}
					}
				}
			}
			
			Collections.sort(sortedTrees);
			
			int keepCnt=0;
			while(sortedTrees.size()>0) {
				boolean works = false;
				for(range i: ranges) {
					if(i.t>0) works = true;
				}if(!works) break;
//				System.out.println(sortedTrees);
				pair tree = sortedTrees.remove(0);
//				System.out.println(tree);
				if(tree.rangeCnt==0) break;
				if(tree.rangeCnt<=0) throw new IOException();
				keepCnt++;
				
				for(range i: ranges) {
					if(i.t==0) continue;
//					if(i.t<0) throw new IOException();
					if(tree.pos >= i.l && tree.pos <= i.r) {
						i.t--;
						if(i.t==0) {
							for(pair j: sortedTrees) {
								if(j.pos >= i.l && j.pos <= i.r) {
									j.rangeCnt--;
								}
							}
						}
					}
				}
				
//				System.out.println(tree.pos);
				
				Collections.sort(sortedTrees);
			}
			System.out.println(N-keepCnt);
//			System.out.println();
			
		}
		
	}
	
	static class range {
		int l, r, t;
		public range(int a, int b, int c) {
			this.l = a;
			this.r = b;
			this.t = c;
		}
	}
	static class pair implements Comparable<pair> {
		int rangeCnt, pos;
		public pair(int a, int b) {
			this.rangeCnt = a;
			this.pos = b;
		}
		public String toString() {
			return rangeCnt+" "+pos;
		}
		@Override
		public int compareTo(USACODeforestation.pair that) {
			return that.rangeCnt-this.rangeCnt;
		}
	}
}
