/* 
ID: ethan7s1
LANG: JAVA
PROB: gift1
*/ 

import java.util.*;
import java.io.*;

public class train_usaco_GreedyGiftGivers {
	
	static Scanner in;
	static PrintWriter out;
	static String[] names;
	static int NP, money[];
	
	public static void main(String[] args) throws FileNotFoundException {
		
		in = new Scanner(new FileReader("gift1.in"));
		out = new PrintWriter("gift1.out");
		
		NP = in.nextInt();
		names = new String[NP];
		money = new int[NP];
		
		for(int i = 0; i < NP; i++) {
			names[i] = in.next();
		}
		
		for(int i = 0; i < NP; i++) {
			
			String name = in.next();
			int nameindex = index(names, name);
			
			int amt = in.nextInt();
			int NG = in.nextInt();
			
			int distribute = 0;
			if(NG != 0) distribute = amt/NG;
			
			money[nameindex] -= amt;
			
			for(int j = 0; j < NG; j++) {
				
				money[index(names, in.next())] += distribute;
			}
			if(NG != 0)	money[nameindex] += amt%NG;
			
		}
		for(int i = 0; i < NP; i++) {
			out.println(names[i]+" "+money[i]);
		}
		
		in.close();
		out.close();
	}
	
	static int index(String[] names, String name) {
		
		for(int i = 0; i < names.length; i++) {
			if(names[i].equals(name)) {
				return i;
			}
		}
		return -1;
	}
}
