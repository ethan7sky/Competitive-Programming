import java.util.*;
import java.io.*;

public class USACOWhydidTheCowCrossTheRoad2 {

	static Scanner in;
	static PrintWriter out;
	static String line;
	static int cows[], pairs;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("circlecross.in"));
		out = new PrintWriter("circlecross.out");
		
		line = in.next();
		
		
		for(int i = 0; i < 50; i++) {
			
			cows = new int[26];
			char curr = line.charAt(i);
			
			if(line.indexOf(curr) != i) {
				continue;
			}
			
			int idx = i+1;
			while(line.charAt(idx) != curr) {
				cows[line.charAt(idx)-65]++;
				idx++;
			}
			
			for(int j = 0; j < 26; j++) {
				if(cows[j] == 1) {
					pairs++;
				}
			}
			
		}
		out.println(pairs/2);
		
		in.close();
		out.close();
	}
}
