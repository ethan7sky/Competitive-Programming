import java.util.*;
import java.io.*;

public class USACOLoanRepayment {
	
	static long n, k, m;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("loan.in"));
		out = new PrintWriter("loan.out");
		
		st = new StringTokenizer(in.readLine());
		n = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		long ans=-1;
		long l = 1;
		long h = (long)Math.pow(10, 12);
		
		while(l<=h) {
			long x = (l+h)/2;
			
			if(works(x)) {
				ans = x;
				l = x+1;
			}
			else {
				h = x-1;
			}
		}
		out.println(ans);
		
		in.close();
		out.close();
		
	}
	static boolean works(long x) {
		long milkRemaining = n;
		long daysRemaining = k;
		
		while(milkRemaining > 0 && daysRemaining > 0) {
			long y = milkRemaining/x;
			//System.out.println(x+" "+milkRemaining+" "+daysRemaining+" "+y);
			
			if(y <= m) {
				return m*daysRemaining >= milkRemaining;
			}
			
			//how many times can y be subtracted until milkRemaining/x = y-1?
			long multi = (milkRemaining%x)/y+1;
			//System.out.println(multi);
			
			milkRemaining -= y*multi;
			daysRemaining -= multi;
			
		}
		//System.out.println(milkRemaining+" "+daysRemaining);
		return milkRemaining <=0 && daysRemaining >=0;
		
	}
	
}
