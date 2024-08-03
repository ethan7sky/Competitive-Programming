import java.util.*;
import java.io.*;

public class CF540094A {
	
	static long n;
	static int t, k;
	static long costs[], netCost;
	static PriorityQueue<plan> opt;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Long.parseLong(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		costs = new long[k];
		for(int i=0; i<k; i++) {
			costs[i] = Integer.parseInt(in.readLine());
		}
		
		netCost = 0;
		
		opt = new PriorityQueue<plan>(new comp());
		opt.add(new plan(costs[0], 4, type.expand, 0, 0));
		
		while(n>0) {
			//System.out.println(n);
			//System.out.println(opt);
			plan next = opt.poll();
			
			long price = next.price;
			long amt = next.amt;
			
			long max = Math.min(amt, n);
			n-=max;
			netCost += price*max;
			
			if(next.t == type.expand) {
				opt.add(new plan(costs[0]+t*(next.dist+1), next.amt+4, type.expand, 0, next.dist+1));
				if(k>1) {
					opt.add(new plan(costs[1]+t*(next.dist), next.amt, type.build, 1, next.dist));
				}
			}
			else {
				int level = next.floorLevel;
				if(level+1 >= k) continue;
				opt.add(new plan(costs[level+1]+t*(next.dist), next.amt, type.build, level+1, next.dist));
			}
			//System.out.println(netCost);
		}
		System.out.println(netCost);
	}
	
	
	
	static enum type{
		expand, build;
	}
	
	static class comp implements Comparator<plan> {

		@Override
		public int compare(CF540094A.plan o1, CF540094A.plan o2) {
			if(o1.price==o2.price) {
				if(o1.amt < o2.amt) {
					return 1;
				}
				if(o1.amt > o2.amt) {
					return -1;
				}
//				if(o1.t==type.expand && o2.t!= type.expand) {
//					return -1;
//				}
//				else if(o1.t!=type.expand && o2.t== type.expand) {
//					return 1;
//				}
				return 0;
			}
			if(o1.price > o2.price) {
				return 1;
			}
			return -1;
			
		}
		
	}
	
	static class plan {
		long price, amt;
		type t;
		int floorLevel;
		long dist;
//		public plan(long a, long b, type c) {
//			this.price = a;
//			this.amt = b;
//			this.t = c;
//		}
		public plan(long a, long b, type c, int d, long e) {
			this.price = a;
			this.amt = b;
			this.t = c;
			this.floorLevel = d;
			this.dist = e;
		}
		public String toString() {
			return "price = "+price+" amt = "+amt+" t = "+t+" floorLevel = "+floorLevel;
		}
	}
}
