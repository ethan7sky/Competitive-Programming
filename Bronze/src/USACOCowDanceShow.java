import java.util.*;
import java.io.*;

public class USACOCowDanceShow {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, t, a[], ans;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("cowdance.in"));
		out = new PrintWriter("cowdance.out");
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		for(int i=0; i<n; i++) 
			a[i] = Integer.parseInt(in.readLine());
		
		int low = 1;
		int high = n;
		int mid;
		
		while(low <= high) {
			mid = (low+high)/2;
			
			if(check(mid)) {
				ans = mid;
				high = mid-1;
			}
			else low = mid+1;
		}
		out.println(ans);
		
		in.close();
		out.close();
	}
	
	static boolean check(int k) {
		
		PriorityQueue<Integer> stage = new PriorityQueue<Integer>();
		for(int i=0; i<k; i++) {
			stage.add(a[i]);
		}
		for(int i=k; i<n; i++) {
			//1. check which cow ends the earliest in stage
			//2. we can add the next cows time to that 
			//cow's time
			int finishesfirst = stage.poll();
			int nextcow = a[i];
			if(finishesfirst + nextcow > t) return false;
			stage.add(finishesfirst+nextcow);			
		}
		return true;
		
	}
	
	
}