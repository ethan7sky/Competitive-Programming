/* 
ID: ethan7s1
LANG: JAVA
PROB: dualpal
*/ 

import java.util.*;
import java.io.*;

public class dualpal {
	
	static Scanner in;
	static int n, s, curr, cnt;
	static StringBuilder sb;
	static PrintWriter out;
	
	public static void main(String[] args) throws FileNotFoundException {
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("dualpal.in"));
		out = new PrintWriter("dualpal.out");
		
		n = in.nextInt();
		s = in.nextInt();
		
		cnt=0;
		curr = s+1;
		sb = new StringBuilder();
		while(cnt<n) {
			
			int palcnt=0;
			for(int i=2; i<=10; i++) {
				if(ispalindrome(Integer.toString(curr,i))) {
					palcnt++;
				}
			}
			if(palcnt>=2) {
				sb.append(curr).append("\n");
				cnt++;
			}
			curr++;
		}
		out.print(sb);
		
		in.close();
		out.close();
	}
	static boolean ispalindrome(String s) {
		String s2 = (new StringBuilder(s).reverse()).toString();
		return s.equals(s2);
	}
}
