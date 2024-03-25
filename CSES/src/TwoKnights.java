import java.util.*;
import java.io.*;

public class TwoKnights {

	static Scanner in;
	static StringBuilder sb;
	static long n, res, tosub, calced,
		c1, c2, c3, c4, c5, c6;
	/*
	c1 = 0 positions lost
	c2 = 2 positions lost
	c3 = 4 positions lost
	c4 = 5 positions lost
	c5 = 6 positions lost
	c6 = all positions lost
	*/
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		n = in.nextLong();
		sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			solve(i);
		}
		System.out.print(sb);
		
		
	}
	static void solve(int n) {
		res = n*n*(n*n-1)/2;
		
		tosub=0;
		calced=0;
		//c1
		if(n>4) {
			long cnt = (n-4)*(n-4);
			calced += cnt;
			
			cnt *= 8;
			tosub += cnt;
		}
		//c2
		if(n>4) {
			long cnt = 4*(n-4);
			calced += cnt;
			
			cnt *= 6;
			tosub += cnt;
		}
		//c4
		if(n>=4) {
			calced += 8;
			tosub += 24;
		}
		//c5
		if(n>=3) {
			calced += 4;
			tosub += 8;
			if(n==3) {
				calced += 4;
				tosub += 8;
			}
		}
		
		//c3
		if(n>=4) {
			tosub += 4*(n*n-calced);
		}
		
		
		sb.append(res-tosub/2).append("\n");
	}
}
