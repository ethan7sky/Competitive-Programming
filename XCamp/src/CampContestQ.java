import java.util.*;
import java.io.*;

public class CampContestQ {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		
		String s = in.readLine();
		//YES or NO
		if(s.contains("H") || s.contains("Q") || s.contains("9")) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}
