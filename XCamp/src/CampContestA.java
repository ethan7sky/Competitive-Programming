import java.util.*;
import java.io.*;
public class CampContestA {

	static int n;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] charCnt = new int[26];
		char[] s = in.next().toCharArray();
		for(char c: s) {
			charCnt[(int)c-'a']++;
		}
		System.out.println(Math.min(Math.min((charCnt['n'-'a']-1)/2, charCnt['i'-'a']), Math.min(charCnt['e'-'a']/3, charCnt['t'-'a'])));
	}
	
}
