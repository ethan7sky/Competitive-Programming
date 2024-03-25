import java.util.*;
import java.io.*;

public class CF1791C {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		while(n-->0) {
			
			int a = Integer.parseInt(in.readLine());
			String s = in.readLine();
			while(s.length() > 1 && 
					(s.charAt(0) == '1' && s.charAt(s.length()-1) == '0' ||
					s.charAt(0) == '0' && s.charAt(s.length()-1) == '1' )){
				s = s.substring(1, s.length()-1);
				
			}
			System.out.println(s.length());
		}
	}
}
