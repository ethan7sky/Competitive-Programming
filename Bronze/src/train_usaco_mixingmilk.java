/* 
ID: ethan7s1
LANG: JAVA
PROB: milk
*/ 

import java.util.*;
import java.io.*;

public class milk {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("milk.in"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		PrintWriter out = new PrintWriter("milk.out");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		farmer[] farmers = new farmer[m];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			farmers[i] = new farmer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(farmers);
		
		int res = 0;
		for(int i=0; i<m; i++) {
			int bought = Math.min(n, farmers[i].amt);
			res+=bought*farmers[i].cost;
			n-=bought;
			if(n==0) break;
		}
		out.println(res);
		
		in.close();
		out.close();
		
	}
	
	static class farmer implements Comparable<farmer> {
		
		int cost, amt;
		farmer(int a, int b) {
			cost = a;
			amt = b;
		}
		
		@Override
		public int compareTo(milk.farmer o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
		
	}
}
