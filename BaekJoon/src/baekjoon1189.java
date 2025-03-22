import java.util.*;
import java.io.*;

public class baekjoon1189 {
	
	
	static int R, C, K, ans;
	static boolean v[][];
	static char a[][];
	static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		R = in.nextInt();
		C = in.nextInt();
		K = in.nextInt();
		
		v = new boolean[R][C];
		a = new char[R][];
		for(int i=0; i<R; i++) {
			a[i] = in.next().toCharArray();
		}
		
		bruteForce(R-1, 0, 1);
		
		System.out.println(ans);
	}
	
	static void bruteForce(int r, int c, int k) {
		if(outOfBounds(r, c)) return;
		if(v[r][c]) return;
		if(a[r][c] == 'T') return;
		else {
			if(k==K) {
				if(r==0 && c==C-1) {
					ans++;
				} return;
			}
			v[r][c] = true;
			bruteForce(r+1, c, k+1);
			bruteForce(r-1, c, k+1);
			bruteForce(r, c+1, k+1);
			bruteForce(r, c-1, k+1);
			v[r][c] = false;
		}
	}
	static boolean outOfBounds(int r, int c) {
		return r<0 || r>=R || c<0 || c>=C;
	}
}
