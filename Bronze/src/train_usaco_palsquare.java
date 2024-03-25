/* 
ID: ethan7s1
LANG: JAVA
PROB: palsquare
*/ 
import java.util.*;
import java.io.*;

public class palsquare {
	
	static int b;
	static Scanner in;
	static PrintWriter out;
	static StringBuilder ans;
	
	public static void main(String[] args) throws IOException {
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("palsquare.in"));
		out = new PrintWriter("palsquare.out");
		
		b = in.nextInt();
		
		ans = new StringBuilder();
		for(int n=1; n<=300; n++) {
			String n2 = Integer.toString(n,b).toUpperCase();
			String num = Integer.toString(n*n,b).toUpperCase();
			String reverse = (new StringBuilder(num).reverse()).toString();
			if(num.equals(reverse)) {
				ans.append(n2).append(" ").append(num).append("\n");
			}
		}
		out.print(ans);
		
		in.close();
		out.close();
	}
}
