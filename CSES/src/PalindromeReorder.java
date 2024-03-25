import java.util.*;
import java.io.*;

public class PalindromeReorder {
	
	public static void main(String[] args) {
		
		int[] cnt = new int[26];
		
		Scanner in = new Scanner(System.in);
		String s = in.next();
		for(int i=0; i<s.length(); i++) {
			cnt[s.charAt(i)-'A'] ++;
		}
		boolean odd = false;
		StringBuilder sb = new StringBuilder();
		StringBuilder middle = new StringBuilder();
		
		for(int i=0; i<26; i++) {
			String c = Character.toString(i+'A');
			if(cnt[i]%2==0) {
				for(int j=0; j<cnt[i]; j+=2) {
					sb.append(c);
				}
			}
			else {
				if(odd) {
					System.out.println("NO SOLUTION");
					return;
				}
				odd = true;
				for(int j=0; j<cnt[i]; j++) {
					middle.append(c);
				}
			}
		}
		StringBuilder ans = new StringBuilder();
		ans.append(sb).append(middle).append(sb.reverse());
		System.out.println(ans);
	}
}
