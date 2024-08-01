import java.util.*;
import java.io.*;

public class CampContestD {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		
		boolean allCaps = true;
		boolean restCaps = true;
		if(!s.substring(0, 1).equals(s.substring(0, 1).toLowerCase())) {
			restCaps = false;
		}
		for(int i=0; i<s.length(); i++) {
			if(!s.substring(i, i+1).equals(s.substring(i, i+1).toUpperCase())) {
				if(i!=0) {
					restCaps = false;
				}
				allCaps = false;
			}
		}
		
		if(allCaps) {
			String ans = "";
			for(int i=0; i<s.length(); i++) {
				ans += s.substring(i, i+1).toLowerCase();
			}System.out.println(ans);
		}
		else if(restCaps) {
			String ans = "";
			ans += s.substring(0,1).toUpperCase();
			for(int i=1; i<s.length(); i++) {
				ans += s.substring(i, i+1).toLowerCase();
			}System.out.println(ans);
		}
		else {
			System.out.println(s);
		}
	}
}
