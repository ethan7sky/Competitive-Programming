import java.util.*;
import java.io.*;

public class CampContestH2 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long pow = 1;
		long sum=0;
		String s = in.next();
		for(int i=0; i<n; i++) {
			if(s.charAt(i)=='B') {
				sum += pow;
			}
			pow *= 2;
		}
		System.out.println(sum);
	}
}
