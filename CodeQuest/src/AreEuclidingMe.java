import java.util.*;
import java.io.*;

public class AreEuclidingMe {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t=  in.nextInt(); in.nextLine();
		while(t-->0) {
			String[] s = in.nextLine().split(",");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			gcd(a, b);
			
		}
		
	}
	//gcd
	static void gcd(int a, int b) { 
		
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		System.out.println(max+"-"+min+"="+(max-min));
		
		if(a==b) {
			if(a==1) {
				System.out.println("COPRIME");
			}
			else System.out.println("NOT COPRIME");
			return;
		}
		
		gcd(max-min, min);
	}
		
	
}
