/* 
ID: ethan7s1
LANG: JAVA
PROB: ride 
*/ 

import java.util.*;
import java.io.*;

public class train_usaco_YourRideIsHere {
	
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new FileReader("ride.in"));
		out = new PrintWriter("ride.out");
		
		long multi1 = 1;
		long multi2 = 1;
		
		String input = in.next().toLowerCase();
		for(int i = 0; i < input.length(); i++) {
			int temp = input.charAt(i) - 'a' + 1;
			multi1 *= temp;
		}
		
		input = in.next().toLowerCase();
		for(int i = 0; i < input.length(); i++) {
			int temp = input.charAt(i) - 'a' + 1;
			multi2 *= temp;
		}
		
		if(multi1%47 == multi2%47) {
			out.println("GO");
		}
		else {
			out.println("STAY");
		}
		
		in.close();
		out.close();
		
	}
}
