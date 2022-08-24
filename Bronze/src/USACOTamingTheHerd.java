import java.util.*;
import java.io.*;

public class USACOTamingTheHerd {
	
	static Scanner in;
	static PrintWriter out;
	static int n, a[], breakouts[];
	static boolean works;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		in = new Scanner(new FileReader("taming.in"));
		out = new PrintWriter("taming.out");
		
		n = in.nextInt();
		a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}
		
		breakouts = new int[n];		
		breakouts[0] = 1;
		
		works = true;
		start:
		for(int i=0; i < n; i++) {
			if(a[i] == -1) continue;
			if(a[i] == 0) breakouts[i] = 1;
			else {

				if(breakouts[i-a[i]] != -2) breakouts[i-a[i]] = 1;
				else { works = false; break start; }
				
				for(int j = i-a[i]+1; j <= i; j++) {
					if(a[j] == 0 || a[j] > a[i]-(i-j)){
						works = false;
						break start;
					}
					breakouts[j] = -2;
				}
			}
		}
		if(!works) {
			out.println(-1);
		}
		else {
			int min = 0;
			int max = 0;
			for(int i = 0; i < n; i++) {
				if(breakouts[i] == 1) {
					min++; max++;
				}
				else if(breakouts[i] != -2) {
					max++;
				}
				
			}
			out.println(min+" "+max);
		}
		
		in.close();
		out.close();
	}
}
