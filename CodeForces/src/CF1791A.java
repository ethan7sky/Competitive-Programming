import java.util.*;
import java.io.*;

public class CF1791A {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String s = "codeforces";
		int t = in.nextInt();
		for(int i=0; i<t; i++) {
			if(s.contains(in.next())) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
