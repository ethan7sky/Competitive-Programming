/* 
ID: ethan7s1
LANG: JAVA
PROB: namenum
*/ 

import java.util.*;
import java.io.*;

public class namenum {
	
	static BufferedReader in, dict;
	static PrintWriter out;
	static HashSet<String> dictionary;
	static String number;
	static HashMap<Character, Integer> nums;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("namenum.in"));
		out = new PrintWriter("namenum.out");
		number = in.readLine();
		
		nums = new HashMap<Character, Integer>();
		initnums();
		
		dict = new BufferedReader(new FileReader("dict.txt"));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s=dict.readLine())!=null) {
			
			if(s.length()!=number.length()) continue;
			boolean works = true;
			for(int i=0; i<s.length(); i++) {
				if(nums.get(s.charAt(i))!=number.charAt(i)-'0') works=false;
			}
			if(works)sb.append(s).append("\n");
			
		}
		if(sb.length()==0) sb.append("NONE\n");
		out.print(sb);
		
		in.close();
		out.close();
	}
	static void initnums() {
		nums.put('A', 2);
		nums.put('B', 2);
		nums.put('C', 2);
		nums.put('D', 3);
		nums.put('E', 3);
		nums.put('F', 3);
		nums.put('G', 4);
		nums.put('H', 4);
		nums.put('I', 4);
		nums.put('J', 5);
		nums.put('K', 5);
		nums.put('L', 5);
		nums.put('M', 6);
		nums.put('N', 6);
		nums.put('O', 6);
		nums.put('P', 7);
		nums.put('R', 7);
		nums.put('S', 7);
		nums.put('T', 8);
		nums.put('U', 8);
		nums.put('V', 8);
		nums.put('W', 9);
		nums.put('X', 9);
		nums.put('Y', 9);
		nums.put('Q', -1);
		nums.put('Z', -1);
	}
}
