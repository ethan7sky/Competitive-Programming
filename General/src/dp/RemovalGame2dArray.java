package dp;
import java.util.*;

public class RemovalGame2dArray {

	static int a[], n, k[][];
	
	static void solve() {
		
		k = new int[n][n];
		
		for(int gap=0; gap<n; gap++) {
			for(int i=0, j=gap; j<n; i++,j++) {
				
				int x = (i+2)<=j? k[i+2][j] : 0;
				int y = (i+1)<=(j-1)? k[i+1][j-1]:0;
				int z = i<=(j-2)? k[i][j-2]:0;
				
				k[i][j] = Math.max(a[i]+Math.min(x, y), a[j]+Math.min(y, z));
				
				
			}
		}
		
	}
	
	public static void main(String[] args) { 
		n = 4;
		a = new int[] {8, 15, 3, 7};
		solve();
		System.out.println(k[0][n-1]);
		
		n = 6;
		a = new int[] {20, 30, 2, 2, 2, 10};
		solve();
		System.out.println(k[0][n-1]);
	}
	
}

