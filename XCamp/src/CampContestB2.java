import java.util.*;
import java.io.*;

public class CampContestB2 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		request[] groups = new request[n];
		for(int i=0; i<n; i++) {
			groups[i] = new request(in.nextInt(), in.nextInt(), i+1, false);
		}
		
		int k = in.nextInt();
		table[] sizes = new table[k];
		for(int i=0; i<k; i++) {
			sizes[i] = new table(in.nextInt(), i+1);
		}
		Arrays.sort(sizes);
		
		long sum=0;
		long netCost = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<k; i++) {
			table curr = sizes[i];
			//System.out.println(curr.capacity);
			int maxProfit = 0;
			int ansIdx = -1;
			for(int j=0; j<n; j++) {
				if(groups[j].used==true) continue;
				if(groups[j].size <= curr.capacity ) {
					if(groups[j].money > maxProfit) {
						maxProfit = groups[j].money;
						ansIdx = j;
					}
				}
			}
			//System.out.println(maxProfit);
			if(ansIdx==-1) break;
			else {
				sum++;
				netCost += maxProfit;
				groups[ansIdx].used = true;
				sb.append(groups[ansIdx].idx).append(" ").append(curr.idx).append("\n");
			}
		}
		System.out.println(sum+" "+netCost);
		if(sum>0) System.out.print(sb);
	}
	static class table implements Comparable<table> {
		int capacity, idx;
		public table(int a, int b) {
			this.capacity = a;
			this.idx = b;
		}
		@Override
		public int compareTo(table that) {
			return this.capacity - that.capacity;
		}
		
	}
	static class request implements Comparable<request>{
		int size, money, idx;
		boolean used;
		public request(int a, int b, int c, boolean d) {
			this.size = a;
			this.money = b;
			this.idx = c;
			this.used = d;
		}
		@Override
		public int compareTo(request that) {
			if(this.money==that.money) {
				return this.size-that.size;
			}
			return that.money - this.money;
		}
	}
}
