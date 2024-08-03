import java.util.*;
import java.io.*;

public class CampContestB3 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		request requests[] = new request[n+1];
		for(int i=1; i<=n; i++) {
			requests[i] = new request(in.nextInt(), in.nextInt());
		}
		
		int k = in.nextInt();
		table[] tables = new table[k];
		for(int i=0; i<k; i++) {
			tables[i] = new table(in.nextInt(), i+1);
		}
		Arrays.sort(tables);
		
		StringBuilder sb = new StringBuilder();
		
		int cnt=0;
		long net=0;
		
		boolean[] v = new boolean[n+1];
		for(table i: tables) {
			int ansIdx = -1;
			int maxProfit = 0;
			for(int j=1; j<=n; j++) {
				if(v[j]) continue;
				if(requests[j].size <= i.capacity) {
					if(requests[j].money > maxProfit) {
						maxProfit = requests[j].money;
						ansIdx = j;
					}
				}
			}
			if(ansIdx == -1) continue;
			
			else {
				net += maxProfit;
				cnt++;
				sb.append(ansIdx+" "+i.idx+"\n");
				v[ansIdx] = true;
			}
		}
		System.out.println(cnt+" "+net);
		System.out.print(sb);
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
	
	static class request {
		int size, money;
		public request(int a, int b) {
			this.size = a;
			this.money = b;
		}
	}
}
