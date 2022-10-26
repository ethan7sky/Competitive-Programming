import java.util.*; import java.io.*;
public class USACOSleepyCowHerding {
	
	static long a, b, c;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		in = new Scanner(new FileReader("herding.in"));
		out = new PrintWriter("herding.out");
		
		long[] cows = new long[3];
		for(int i = 0; i < 3; i++) {
			cows[i]= in.nextLong();
		}
		Arrays.sort(cows);
		
		a = cows[0];
		b = cows[1];
		c = cows[2];
		
		if(a+1 == b && b+1 == c) {
			out.println(0);
		}
		else if(b-a == 2 || c-b==2) {
			out.println(1);
		}
		else {
			out.println(2);
		}
		
		long maxdist = Math.max(b-a,c-b);
		out.println(maxdist-1);
		
		in.close();
		out.close();
		
	}
}
