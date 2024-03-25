/* 
ID: ethan7s1
LANG: JAVA
PROB: milk2
*/ 


import java.util.*;
import java.io.*;

public class milk2 {
	
	public static void main(String[] args) throws IOException {
		
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter("milk2.out");

		HashMap<Integer, Integer> start = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> leave = new HashMap<Integer, Integer>();
		
		int limit = 0;
		int minimum = 1000000;
		
		int n = Integer.parseInt(in.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int enter = Integer.parseInt(st.nextToken());
			if(start.containsKey(enter)) start.put(enter, start.get(enter)+1);
			else start.put(enter, 1);
			minimum = Math.min(enter, minimum);
			
			int left = Integer.parseInt(st.nextToken());
			if(leave.containsKey(left)) leave.put(left, leave.get(left)+1);
			else leave.put(left, 1);
			limit = Math.max(limit, left);
		}
		
		int ans1=0;
		int cnt=0;
		int size=0;
		for(int i=minimum; i<limit; i++) {
			if(start.containsKey(i)) size+=start.get(i);
			if(leave.containsKey(i)) size-=leave.get(i);
			
			if(size>0) {
				cnt++;
				ans1 = Math.max(ans1, cnt);
			}
			else cnt=0;
		}
		
		int ans2=0;
		cnt=0;
		size=0;
		for(int i=minimum; i<limit; i++) {
			if(start.containsKey(i)) size+=start.get(i);
			if(leave.containsKey(i)) size-=leave.get(i);
			
			if(size==0) {
				cnt++;
				ans2 = Math.max(ans2, cnt);
			}
			else cnt=0;
		}
		
		out.println(ans1+" "+ans2);
		
		in.close();
		out.close();
	}
	
}
