import java.util.*;
import java.io.*;

public class USACOLoanRepayment {
	
	static Scanner in;
	static PrintWriter out;
	static long n, k, m, ans;
	
	public static void main(String[] args) throws IOException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("loan.in"));
		out = new PrintWriter("loan.out");
		
		n = in.nextLong();
		k = in.nextLong();
		m = in.nextLong();
		
		long low = 1;
		long high = n;
		long mid;
		while(low <= high) {
			mid = (low+high)/2;
			
			if(check(mid)) {
				ans = mid;
				low = mid+1;
			}
			else high = mid-1;
		}
		out.println(ans);
		
		in.close();
		out.close();
	}
	
	static boolean check(long x) {
		
		long remain = n;
		long day = k;
		while(day > 0 && remain > 0) {
			long y = remain/x;
			if(y<=m) {
				return m*day >= remain;
			}
			
			long samedays = (remain%x)/y+1;
			
			day -= samedays;
			remain -= y*samedays;
		}
		return remain <= 0;
	}
}