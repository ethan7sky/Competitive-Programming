import java.util.*;
import java.io.*;

public class DigitQueries {
	
	static int q;
	static long k;
	static BufferedReader in;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		q = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		
		while(q-->0) {
			
			k = Long.parseLong(in.readLine());
			
			long digits = 1;
			long amt = 9;
			while(k - digits*amt > 0) {
				k-=digits*amt;
				digits++;
				amt*=10L;
			}

			
			long num = pow(10L, digits-1) - 1;
			
			long quot = k/(digits);
			int rmdr = (int)(k-quot*(digits));
			num += quot;
			
			if(rmdr==0) {
				String s = Long.toString(num);
				sb.append(s.charAt((int)digits-1)).append("\n");
			}
			else {
				num++;
				String s = Long.toString(num);
				sb.append(s.charAt((int)rmdr-1)).append("\n");
			}
		}
		System.out.print(sb);
	}
	static long pow(long n, long k) {
		if(k==0) return 1;
		
		long res = n;
		while(k-->1) {
			res *= n;
		}
		return res;
	}
}
