import java.util.*;
import java.io.*;

public class USACOTriangles {
	static Scanner in;
	static PrintWriter out;
	static int n, x[], y[];
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		n = in.nextInt();
		for(int i = 0;i < 4; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			
		}
		
		int max = -1;
		
		for(int i = 0; i < 4; i++) {
			
			for(int j = 0; j < 4; j++) {
				
				for(int k = 0; k < 4; k++) {
					
					if(i == j || j == k || i == k) {
						continue;
					}
					
					if(check(i, j, k)) {
						max = Math.max(max, area(i, j, k));
					}
				
				}
			}
		}
	}
	static boolean check(int i1, int i2, int i3) {
		if(y[i1] == y[i2] || y[i2] == y[i3] || y[i1] == y[i3]) {
			if(x[i1] == x[i2] || x[i2] == x[i3] || x[i1] == x[i3]) {
				return true;
			}
		}
		return false;
	}
	static int area(int i1, int i2, int i3) {
		
	}
}
