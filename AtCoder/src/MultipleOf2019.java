import java.util.*;
import java.io.*;

public class MultipleOf2019 {
	
	static BufferedReader in;
	static int[] modCnt = new int[2019];
	static long ans;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		
		int currModPow10 = 1;
		int prevMod = 0;
		int len = s.length();
		
		for(int i=len-1; i>=0; i--) {
			int currDigit = s.charAt(i)-'0';
			int currMod = (prevMod + currModPow10*currDigit) %2019;
			
			modCnt[currMod]++;
			prevMod = currMod;
			
			currModPow10 *= 10;
			currModPow10 %= 2019;
		}
		modCnt[0]++;
		
		ans=0;
		for(int i=0; i<2019; i++) {
			ans += choose2(modCnt[i]);
		}
		System.out.println(ans);
		
	}
	static long choose2(int x) {
		return (long)x*(x-1)/2;
	}
	
}
