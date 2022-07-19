import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class CFWhiteSheet {
	 
	static Scanner in;
	static int x1, x2, y1, y2, x3, x4, y3, y4, x5, x6, y5, y6;
	static long area2, area3, overlap;
	static BigInteger area1;
	
	public static void main(String[] args) {
		
		init();
		
		area1 = BigInteger.valueOf(Math.abs(x2-x1)).multiply(BigInteger.valueOf(Math.abs(y2-y1)));
		
		area2 = findarea2();
		area3 = findarea3();
		overlap = findoverlap();
		
		
		BigInteger res = BigInteger.valueOf(area2+area3-overlap);
		
		if(res.compareTo(area1) < 0) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	
	static long findarea2() {
		long l = Math.max(x1, x3);
		long r = Math.min(x2, x4);
		long b = Math.max(y1, y3);
		long u = Math.min(y2, y4);
		if(l>r|| b>u) {
			return 0;
		}
		return (u-b) * (r-l);
		
		
	}
	
	static long findarea3() {
		long l = Math.max(x1, x5);
		long r = Math.min(x2, x6);
		long b = Math.max(y1, y5);
		long u = Math.min(y2, y6);
		
		if(l>r || b>u) {
			return 0;
		}
		return (u-b) * (r-l);
	}
	
	
	static long findoverlap() {
		long l = Math.max(x1, Math.max(x3, x5));
		long r = Math.min(x2, Math.min(x4, x6));
		long b = Math.max(y1, Math.max(y3, y5));
		long u = Math.min(y2, Math.min(y4, y6));
		if(l>r|| b>u) {
			return 0;
		}
		return (u-b) * (r-l);
	}
	
	static void init() {
		Scanner in = new Scanner(System.in);
		x1 = in.nextInt();
		y1 = in.nextInt();
		x2 = in.nextInt();
		y2 = in.nextInt();
		x3 = in.nextInt();
		y3 = in.nextInt();
		x4 = in.nextInt();
		y4 = in.nextInt();
		x5 = in.nextInt();
		y5 = in.nextInt();
		x6 = in.nextInt();
		y6 = in.nextInt();
		
	}
}
