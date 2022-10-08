import java.util.*;
import java.io.*;

public class CSES1622 {
	
	static Scanner in;
	static String s;
	static TreeSet<String> set;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		s = in.next();
		set = new TreeSet<String>();
		R("", s);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(set.size()).append("\n");
		for(String t: set) {
			sb.append(t).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void R(String left, String right) {
		if(right.length() == 0) set.add(left);
		for(int i = 0; i < right.length(); i++) {
			String l = left + right.charAt(i);
			String r = right.substring(0, i) + right.substring(i+1);
			R(l, r);
		}
	}
}
