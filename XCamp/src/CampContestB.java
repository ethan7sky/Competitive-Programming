import java.util.*;
import java.io.*;

public class CampContestB {
	
	static Scanner in;
	static int n;
	static request[] people;
	static TreeMap<Integer, Integer> tables;
	static ArrayList<Integer> tableId[];
	static StringBuilder sb;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		n = in.nextInt();
		people = new request[n];
		for(int i=0; i<n; i++) {
			people[i] = new request(in.nextInt(), in.nextInt(), i+1);
		}
		Arrays.sort(people);
		
		tables = new TreeMap<Integer, Integer>();
		tableId = new ArrayList[1000+1];
		for(int i=1; i<=1000; i++) tableId[i] = new ArrayList<Integer>();
		int k = in.nextInt();
		for(int i=0; i<k; i++) {
			int j = in.nextInt();
			tableId[j].add(i+1);
			tables.put(j, tables.getOrDefault(j, 0)+1);
		}
		
		
		sb = new StringBuilder();
		
		long sum=0;
		long acceptedCnt=0;
		int idx=0;
		
		while(tables.size()>0 && idx<n) {
			request curr = people[idx];
			idx++;
			
			if(tables.higherKey(curr.size) == null) continue; 
			
			int next = tables.higherKey(curr.size);
			acceptedCnt++;
			sum += curr.money;
			tables.put(next, tables.get(next)-1);
			if(tables.get(next)==0) tables.remove(next);
			//System.out.println(tableId[next]);
			//System.out.println(next);
			sb.append(curr.idx).append(" ").append(tableId[next].remove(0)).append("\n");
		}
		
		System.out.println(acceptedCnt+" "+sum);
		System.out.print(sb);
		
		
		
	}
	
	
	
	
	
	static class request implements Comparable<request>{
		int size, money, idx;
		public request(int a, int b, int c) {
			this.size = a;
			this.money = b;
			this.idx = c;
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
