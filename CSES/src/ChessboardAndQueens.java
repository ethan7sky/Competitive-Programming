import java.util.*;
import java.io.*;

public class ChessboardAndQueens {
	
	static Scanner in;
	static int ans = 0;
	static char[][] a;
	static boolean d1[], d2[], col[];
	
	public static void main(String[] args) { 
		
		in = new Scanner(System.in);
		a = new char[8][];
		for(int i=0; i<8;  i++) {
			a[i] = in.next().toCharArray();
		}
		d1 = new boolean[15];
		d2 = new boolean[15];
		col = new boolean[8];
		
		recurse(0);
		
		System.out.println(ans);
	}
	static void recurse(int row) {
		if(row==8) {
			ans++;
			return;
		}
		for(int i=0; i<8; i++) {
			if(a[row][i] == '.' && !d1[row-i+7] && !d2[row+i] && !col[i]) {
				d1[row-i+7] = true;
				d2[row+i] = true;
				col[i] = true;
				recurse(row+1);
				d1[row-i+7] = false;
				d2[row+i] = false;
				col[i] = false;
			}
		}
	}
	
}