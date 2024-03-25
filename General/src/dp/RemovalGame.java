package dp;
import java.util.*;

public class RemovalGame {

	static int a[], n;
	static HashMap<ArrayList<Integer>, Integer> memo;
	
	static int solve(int i, int j) {
		
		if(i>j || i>n || j<0) return 0;
		
		ArrayList<Integer> k = new ArrayList<Integer>();
		k.add(i);
		k.add(j);
		
		if(memo.containsKey(k)) return memo.get(k);
		
		int x = a[i] + Math.min(solve(i+1,j-1), solve(i+2,j));
		int y = a[j] + Math.min(solve(i+1,j-1), solve(i,j-2));
		
		memo.put(k, Math.max(x, y));
		return memo.get(k);
	}
	
	public static void main(String[] args) { 
		
		n = 4;
		a = new int[] {8, 15, 3, 7};
		
		memo = new HashMap<ArrayList<Integer>, Integer>();
		System.out.println(solve(0, n-1));
		
		n = 6;
		a = new int[] {20, 30, 2, 2, 2, 10};
		
		memo.clear();
		System.out.println(solve(0,n-1));
		
	}
	
}

