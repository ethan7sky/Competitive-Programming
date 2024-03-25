/* 
ID: ethan7s1
LANG: JAVA
PROB: namenum
*/ 

import java.util.*;
import java.io.*;

public class train_usaco_namenum {
	
	static BufferedReader in, dict;
	static PrintWriter out;
	static HashSet<String> dictionary;
	static ArrayList<String> names;
	static String number;
	static String[] letters = {"","","ABC","DEF","GHI","JKL","MNO","PRS","TUV","WXY"};
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader("namenum.in"));
		//out = new PrintWriter("namenum.out");
		
		number = in.readLine();
		dict = new BufferedReader(new FileReader("dict.txt"));
		dictionary = new HashSet<String>();
		
		String s;
		while((s=dict.readLine())!=null) dictionary.add(s);
		
		names = new ArrayList<String>();
		combinations(0, "");
		
		for(int i=10; i<20; i++) {
			System.out.println(names.get(i));
		}
		
		StringBuilder sb = new StringBuilder();
		for(String name: names) {
			if(dictionary.contains(name)) {
				sb.append(name).append("\n");
			}
		}
		if(sb.length()==0) sb.append("NONE\n");
		System.out.print(sb);
		
		in.close();
		out.close();
		
	}
	
	static void combinations(int idx, String s) {
		
		if(idx==number.length()) {
			names.add(s);
			return;
		}
		int num = number.charAt(idx)-'0';
		String letter = letters[num];
		for(int i=0; i<3; i++) {
			combinations(idx+1,s+Character.toString(letter.charAt(i)));
		}
	}
}
