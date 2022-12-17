import java.util.Scanner;

public class ACSLNumeralTriangles_JR {
	
	static Scanner in;
	static int start, delta, rows, res;
	static String pattern;
	
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
		
		pattern = findpattern();
		

		res=0;
		int startidx = (rows-1)*(rows)/2;
		for(int i=0; i<rows; i++) {
			
			res += pattern.charAt((startidx+i)%pattern.length())-'0';
			
		}
		System.out.println(res);
		
		
	}
	static String findpattern() {
		
		int s = sumofdigits(start+"");
		String ans = Integer.toString(s);
		int prev = s;
		
		while(true) {
			int temp = sumofdigits(prev+delta+"");
			if(!ans.contains(temp+"")) {
				ans+=temp;
				prev = temp;
			}
			else break;
		}
		
		return ans;
	}
	
	
	
	static int sumofdigits(String s) {
		
		int ans = 0;
		for(int i=0; i<s.length(); i++) ans += s.charAt(i)-'0';
		
		if(Integer.toString(ans).length() > 1) {
			return sumofdigits(ans+"");
		}
		return ans;
		
	}
}
