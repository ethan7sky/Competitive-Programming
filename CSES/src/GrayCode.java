import java.util.*;
import java.io.*;

public class GrayCode {
	static int n;
	static boolean seen[];
	static int record[], position;
	
	static void dfs(int x) {
		seen[x] = true;
		record[position++] = x;
		
		if(position==1<<n) {
			for(int i=0; i<n; i++) {
				String s = Integer.toBinaryString(record[i]);
				while(s.length() < n) s = "0" + s;
				System.out.println(s);
			}
			System.exit(0);
		}
		for(int i=0; i<n; i++) {
			int mutated = x ^ (1<<i);
			System.out.println("mutated = " + mutated);
			if(seen[mutated]) continue;

			dfs(mutated);
		}
		position--;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		n = in.nextInt();

		//1<<N ==> produces 2^N
		
		seen = new boolean[1<<n];
		record = new int[1<<n];
		position = 0;
		
		int x = 0;
		while(true) {
			seen[x] = true;
			record[position++] = x;
			
			if(position == (1<<n)) {
				for(int i=0; i<position; i++) {
					String s = Integer.toBinaryString(record[i]);
					while(s.length() < n) s = "0" + s;
					System.out.println(s);
				}
				System.exit(0);
			}
					
			for(int i=0; i<n; i++) {
				int mutated = x ^ (1<<i);
				if(seen[mutated]) continue;
				x = mutated;
				break;
			}
		}
	}
}
