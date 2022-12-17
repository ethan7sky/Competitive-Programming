import java.util.*;

public class ACSLNumeralTriangles {
	
	static Scanner in;
	static int start, delta, rows, res;
	static String ans;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			start = in.nextInt();
			delta = in.nextInt();
			rows = in.nextInt();
			solve();
		}
	}
	
	static void solve() {
		
		start = Integer.parseInt(start+"", 8);
		delta = Integer.parseInt(delta+"", 8);
		
		ans = "";
		
		start = start + delta*((rows-1)*rows/2);
		
		for(int i=0; i<rows; i++) {
			
			ans += Integer.toOctalString(start+i*delta);
			
		}
		
		res=0;
		for(int i=0; i<ans.length(); i++) {
			res += ans.charAt(i)-'0';
		}
		System.out.println(res);
		
	}
	
}
