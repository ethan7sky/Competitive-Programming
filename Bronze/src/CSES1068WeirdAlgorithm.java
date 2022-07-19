import java.util.*;
import java.io.*;

public class CSES1068WeirdAlgorithm {
	
	static BufferedReader in;
	static StringTokenizer st;
	static long n;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException { 
		
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		System.out.println(sb);
	}
	static void init() throws NumberFormatException, IOException {
		
		n = Long.parseLong(in.readLine());
		sb = new StringBuilder();
		sb.append(n).append(" ");
		
	}
	static void solve() {
		
		while(n != 1) {
			if(n%2==0) {
				n /=2;
			}
			else {
				n = n*3+1;
			}
			sb.append(n).append(" ");
		}
	}
}
