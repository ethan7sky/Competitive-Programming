import java.util.*;
import java.io.*;

public class AEIOU {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		String vowels = "AEIOUaeiou";
		while(n-->0) {
			String s = in.nextLine();
			int cnt = 0;
			for(int i=0; i<s.length(); i++) {
				if(vowels.contains(s.substring(i,i+1))) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
