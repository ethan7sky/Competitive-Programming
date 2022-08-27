import java.util.*;

import java.io.*;
public class TEST {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		in.nextLine();
		String line  = in.nextLine();
		stuff a[] = new stuff[k];
		for(int i = 0; i < k; i++) {
			a[i] = new stuff(in.nextInt(), in.nextInt());
		}
		Arrays.sort(a);
		
		System.out.println(line);
		System.out.println(Arrays.toString(a));
	}
	
	static class stuff implements Comparable<stuff>{
		
		int t, x;
		stuff(int a, int b){
			t = a;
			x = b;
		}
		
		public String toString() {
			return t+" "+x;
		}

		@Override
		public int compareTo(TEST.stuff o) {
			// TODO Auto-generated method stub
			return this.x-o.x;
		}
	}
}
