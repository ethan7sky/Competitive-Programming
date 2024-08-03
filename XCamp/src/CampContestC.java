import java.util.*;
import java.io.*;

public class CampContestC {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String temp = in.next();
		char[] s = temp.toCharArray();
		
		long left = 0;
		long right = 0;
		long equals = 0;
		
		boolean metEqual = false;
		boolean metPlus = false;
		
		for(int i=0; i<s.length; i++) {
			char c = s[i];
			if(c=='+') {
				metPlus = true;
				continue;
			}
			if(c=='=') {
				metEqual = true;
				continue;
			}
			else {
				if(!metEqual && !metPlus) {
					left++;
				}
				else if(!metEqual) {
					right++;
				}
				else {
					equals++;
				}
			}
		}
		
		if(left+right==equals) {
			System.out.println(temp);
		}
		else if(left+right+1 == equals-1) {
			
			left++;
			equals--;
			
			String ans = "";
			for(int i=0; i<left; i++) {
				ans += "|";
			}
			ans += "+";
			for(int i=0; i<right; i++) {
				ans += "|";
			}
			ans += "=";
			for(int i=0; i<equals; i++) {
				ans += "|";
			}
			System.out.println(ans);
		}
		else if(left+right-1 == equals+1) {
			if(left>right) left--;
			else right--;
			equals ++;
			
			String ans = "";
			for(int i=0; i<left; i++) {
				ans += "|";
			}
			ans += "+";
			for(int i=0; i<right; i++) {
				ans += "|";
			}
			ans += "=";
			for(int i=0; i<equals; i++) {
				ans += "|";
			}
			System.out.println(ans);
		}
		
		else {
			System.out.println("Impossible");
		}
	}
}
