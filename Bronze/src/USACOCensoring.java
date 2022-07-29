import java.io.*;
import java.util.*;

public class USACOCensoring {
	
	static Scanner in;
	static PrintWriter out;
	static String s, t;
	
	public static void main(String[] args) throws IOException{
		
		in = new Scanner(new FileReader("censor.in"));
		out = new PrintWriter("censor.out");
		
		s = in.next();
		t = in.next();
		
		solve();
		
		in.close();
		out.close();
		
	}
	
	static void solve() {
		StringBuilder sb = new StringBuilder();
		
		int len = t.length();
		for(int i= 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if(sb.length() >= len && sb.substring(sb.length() -len).equals(t)) {
				sb.delete(sb.length()-len,  sb.length()+1);
			}
		}
		
		out.println(sb.toString());
	}
}
