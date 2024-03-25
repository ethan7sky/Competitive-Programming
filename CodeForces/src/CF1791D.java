import java.util.*;
import java.io.*;

public class CF1791D {
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		while(t-->0) {
			int n = Integer.parseInt(in.readLine());
			String s = in.readLine();

			HashSet<Character> a = new HashSet<Character>();
			HashSet<Character> b = new HashSet<Character>();
			
			for(int i=0; i<n; i++) {
				if(a.contains(s.charAt(i))) b.add(s.charAt(i));
				else a.add(s.charAt(i));
			}
			System.out.println(a.size()+b.size());
		}
	}
}
