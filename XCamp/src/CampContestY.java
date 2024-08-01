import java.util.*;
import java.io.*;

public class CampContestY {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static String s;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		
		int cnt = 0;
		for(char c: s.toCharArray()) {
			if(c=='4' || c=='7') cnt++;
		}
		if(cnt==4 || cnt==7) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}
