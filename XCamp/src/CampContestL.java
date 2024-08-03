import java.io.*;
import java.util.*;

public class CampContestL {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0) {
			long n = in.nextLong();
			long l = in.nextLong();
			long r = in.nextLong();
			
			long div = (long)n/l;
			if(r*div>=n) System.out.println("Yes");
			else System.out.println("No");
		}
	}
}
