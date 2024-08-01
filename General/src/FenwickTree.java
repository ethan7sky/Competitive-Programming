import java.util.*;
import java.io.*;

public class FenwickTree {
	
	static int[] array = 
		{-1, 1, 0, 2, 1, 1, 3, 0, 4, 2, 5, 2, 2, 3, 1, 0};
	
	public static void main(String[] args) {
		
		FenwickTreeMax BIT = new FenwickTreeMax(array.clone());
		
		System.out.println(BIT.toString());
		System.out.println(BIT.findMaximumUpToIdx(7));
		System.out.println(BIT.findMaximumUpToIdx(8));
		
		BIT.update(10, 500);
		System.out.println(BIT.toString());
		System.out.println(BIT.findMaximumUpToIdx(9));
		System.out.println(BIT.findMaximumUpToIdx(10));
		System.out.println(BIT.findMaximumUpToIdx(11));
		
	}
	
	static class FenwickTreeMax {
		
		int a[], bit[];
		int LENGTH;
		
		FenwickTreeMax(int[] array){
			this.a = array.clone();
			this.LENGTH = array.length;
			this.bit = array.clone();
			init();
		}
		
		public void init() {
			for(int i=1; i<LENGTH; i++) {
				int next = i+(i&-i);
				if(next<LENGTH) {
					bit[next] = Math.max(bit[next], bit[i]);
				}
			}
		}
		
		public String toString() {
			return Arrays.toString(a)+"\n"+Arrays.toString(bit);
		}
		
		public int findMaximumUpToIdx(int idx) {
			int ans = Integer.MIN_VALUE;
			while(idx!=0) {
				ans = Math.max(ans, bit[idx]);
				idx -= idx&-idx;
			}
			return ans;
		}
		public void update(int idx, int val) {
			while(idx<LENGTH) {
				bit[idx] = Math.max(bit[idx], val);
				idx += idx&-idx;
			}
		}
	}
	

}
