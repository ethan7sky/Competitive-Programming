import java.util.*;
import java.io.*;

public class CampContestV {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static String s;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		String s = in.readLine();
		
		while(s.contains("WUB")) {
			int idx = s.indexOf("WUB");
			s = s.substring(0,idx) +" "+ s.substring(idx+3);
		}
		int idx=0;
		while(idx<s.length()-1) {
			if(s.charAt(idx)==' '&&s.charAt(idx+1)==' ') {
				s = s.substring(0, idx) + s.substring(idx+1);
			}
			else {
				idx++;
			}
		}
		
		System.out.println(s);
	}
}
