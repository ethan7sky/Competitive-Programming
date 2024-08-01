import java.util.*;
import java.io.*;

public class CampContestT {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		int idx = 0;
		String find = "hello";
		for(char c: s.toCharArray()) {
			if(c==find.charAt(idx)) {
				idx++;
				if(idx>=5) break;
			}
		}
		if(idx>=5) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}
