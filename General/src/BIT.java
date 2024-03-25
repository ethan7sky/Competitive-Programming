import java.util.*;
import java.io.*;

public class BIT {
	
	static int bit[], n, a[];
	
	public static void main(String[] args) {
		
		n=9;
		a = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
		
		int pre[] = new int[n];
		
		for(int i=1; i<n; i++) pre[i] = pre[i-1]+a[i];
		System.out.println(Arrays.toString(pre));

		makeBIT();
		System.out.println(Arrays.toString(bit));
		
		System.out.println(sum(6));
		System.out.println(rangeSum(2, 8));
		update(1, 3-a[1]);
		System.out.println(Arrays.toString(bit));
	}
	static void update(int i, int k) {
		
		while(i<n) {
			bit[i] += k;
			i += i&-i;
			
		}
	}
	
	static void makeBIT() {
		bit = a.clone();
		for(int i=1; i<n; i++) {
			int next = i+(i&-i);
			if(next<n) bit[next] += bit[i];
		}
	}
	static int rangeSum(int s, int e) {
		return sum(e) - sum(s-1);
	}
	static int sum(int i) {
		int ans = 0;
		
		while(i!=0) {
			ans+=bit[i];
			i -= i&-i;
		}
		return ans;
	}
}
