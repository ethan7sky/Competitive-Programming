import java.util.*;
import java.io.*;

public class USACOAirCownditioning {
	 
	static Scanner in;
	static int n, a[], ans;
	static ArrayList<Integer> increasing, decreasing;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		init();
	}
	
	static void init() {
		
		n = in.nextInt();
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = in.nextInt();
		
		//System.out.println(Arrays.toString(a));
		
		increasing = new ArrayList<Integer>();
		decreasing = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			
			int df = a[i] - in.nextInt();
			if(df>0) {
				decreasing.add(df); 
				increasing.add(0);
			}
			else if(df < 0) {
				increasing.add(-df);
				decreasing.add(0);
			}
			else {
				decreasing.add(0);
				increasing.add(0);
			}
		}
		
		//System.out.println(decreasing);
		//System.out.println(increasing);
		
		solve(increasing);
		solve(decreasing);
		
		System.out.println(ans);
		
		
	}
	
	static void solve(ArrayList<Integer> list) {
		
		if(list.size() == 0) return;
		
		//find minimum value
		int min = list.get(0);
		for(int i=0; i<list.size(); i++) {
			min = Math.min(min,  list.get(i));
		}
		
		ans += min;
		
		//update values
		for(int i=0; i<list.size(); i++) {
			list.set(i,list.get(i)-min);
		}
		
		//regrouping
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) ==0) {
				solve(temp);
				temp.clear();
			}
			else temp.add(list.get(i));
		}
		solve(temp);
	}
}