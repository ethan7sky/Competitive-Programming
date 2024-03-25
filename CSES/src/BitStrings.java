import java.util.*;
import java.io.*;

public class BitStrings {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		long ans = 1;
		while(n-->0) {
			ans*=2;
			if(ans>=Math.pow(10, 9)+7) {
				ans -= Math.pow(10, 9)+7;
			}
		}
		System.out.println(ans);
	}
}
