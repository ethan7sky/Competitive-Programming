import java.util.*;
import java.io.*;

public class USACOConventionII {
	
	static int n, max;
	static cow[] cows;
	static Stack<cow> next;
	static PriorityQueue<cow> waiting;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader(new File("convention2.in")));
		out = new PrintWriter(new File("convention2.out"));
		
		n = Integer.parseInt(in.readLine());
		
		cows = new cow[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			cows[i] = new cow(Integer.parseInt(st.nextToken()),
			                  Integer.parseInt(st.nextToken()),
			                  i+1);
		}
		Arrays.sort(cows);
		
		
		next = new Stack<cow>();
		for(cow i: cows) next.push(i);
		
		waiting = new PriorityQueue<cow> (new SeniorityComparator());
		
		int max = 0;
		int lastEndTime = 0;
		
		while(!next.isEmpty() || !waiting.isEmpty()) {
			
			while(!next.isEmpty() && next.peek().arr <= lastEndTime) {
				waiting.add(next.pop());
			}
			
			
			if(waiting.isEmpty()) {
				cow remove = next.pop();
				lastEndTime = remove.arr+remove.tim;
			}
			
			else {
				cow remove = waiting.poll();
				max = Math.max(max, lastEndTime - remove.arr);
				lastEndTime+=remove.tim;
			}
		}
		
		out.println(max);
		
		in.close();
		out.close();
	}
	static class SeniorityComparator implements Comparator<cow> {
		
		public int compare(cow a, cow b) {
			return a.sen-b.sen;
		}

	}
	
	static class cow implements Comparable<cow>{
		int arr, tim, sen;
		public cow(int x, int y, int z) {
			this.arr = x;
			this.tim = y;
			this.sen = z;
		}
		
		@Override
		public int compareTo(cow that) {
			return that.arr-this.arr;
		}
		public String toString() {
			return arr+" "+tim+" "+sen;
		}
	}
	
}
