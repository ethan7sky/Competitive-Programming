import java.util.*;
import java.io.*;
import java.io.*;

public class USACORace {
	
	static Scanner in;
	static PrintWriter out;
	static int k, n;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		//in = new Scanner(new FileReader("race.in"));
		//out = new PrintWriter("race.out");
		
		init();
		solve();
		
		in.close();
		out.close();
		
	}
	static void init() {
		
		k = in.nextInt();
		n = in.nextInt();
		
		
	}
	
	static void solve() {
		
		for(int i=0; i<n; i++) {
			
			int x = in.nextInt();
			
			
			int dist = 0;
			int speed = 0;
			int secs = 0;
			while(dist<k) {
				
				if(speed < x) {
					speed++;
					dist+=speed;
					secs++;
				}
				else if(speed >= x) {
					
					int calc = speed + (speed+1)*(speed+2)/2 - x*(x+1)/2;
					//System.out.println("CALC = " + calc);
					if(calc<=k) {
						speed++;
						dist+=speed;
						secs++;
					}
					else {
						speed--;
						dist+=speed;
						secs++;
					}
					
				}
				
				//System.out.println(dist+" "+speed+" "+secs);
				
				
			}
			System.out.println(secs);
			
		}
		
		
	}
	
}
