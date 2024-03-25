import java.util.*;
import java.io.*;

public class AnagramChecker {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		whileloop:
		while(n-->0) {
			String input = in.next();
			String word1 = "", word2 = "";
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i)=='|') {
					word1 = input.substring(0, i);
					word2 = input.substring(i+1);
					break;
				}
			}
			
			if(word1.equals(word2)) {
				System.out.println(input+" = NOT AN ANAGRAM");
				continue;
			}
			if(word1.length()!=word2.length()) {
				System.out.println(input+" = NOT AN ANAGRAM");
				continue;
			}
			
			int[] cnt1 = new int[26];
			int[] cnt2 = new int[26];
			
			for(int i=0; i<word1.length(); i++) {
				cnt1[word1.charAt(i)-'A']++;
				cnt2[word2.charAt(i)-'A']++;
			}
			for(int i=0; i<26; i++) {
				if(cnt1[i] != cnt2[i]) {
					System.out.println(input+ " = NOT AN ANAGRAM");
					continue whileloop;
				}
			}
			System.out.println(input+" = ANAGRAM");
		}
	}
}
