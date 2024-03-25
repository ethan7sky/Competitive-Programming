/* 
ID: ethan7s1
LANG: JAVA
PROB: gift1
*/ 

import java.util.*;
import java.io.*;

public class gift1 {
	
	static Scanner in;
	static PrintWriter out;
	static LinkedHashMap<String, Integer> map;
	static int np;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("gift1.in"));
		out = new PrintWriter("gift1.out");
		init();
		
		in.close();
		out.close();
		
	}
	static void init() {
		np = in.nextInt();
		
		map = new LinkedHashMap<String, Integer>();
		for(int i=0; i<np; i++) {
			map.put(in.next(), 0);
		}
		
		while(np-->0) solve();
		for(String key: map.keySet()) {
			out.println(key+" "+map.get(key));
		}
	}
	static void solve() {
			
		String giver = in.next();
		int money = in.nextInt();
		int cnt = in.nextInt();
		if(cnt==0) return;
		
		int divide = money/cnt;
		int remain = money%cnt;
		
		map.put(giver, map.get(giver)-money+remain);
		
		for(int j=0; j<cnt; j++) {
			String name = in.next();
			map.put(name, map.get(name)+divide);
		}
	}
}
