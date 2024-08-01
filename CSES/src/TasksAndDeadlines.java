import java.util.*;
import java.io.*;

public class TasksAndDeadlines {
	
	static int n;
	static task[] a;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		a = new task[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = new task(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(a);
		long currTime=0;
		long reward=0;
		for(task i: a) {
			currTime += i.duration;
			reward += i.deadline - currTime;
		}
		System.out.println(reward);
	}
	
	
	
	
	static class task implements Comparable<task>{
		int duration, deadline;
		public task(int a, int b) {
			this.duration = a;
			this.deadline = b;
		}
		@Override
		public int compareTo(task that) {
			return this.duration-that.duration;
		}
	}
}
