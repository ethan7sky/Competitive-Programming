import java.util.*; import java.io.*;
public class USACOSleepyCowSorting {
	
	static int n, cows[], max;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		in = new Scanner(new FileReader("sleepy.in"));
		out = new PrintWriter("sleepy.out");
		
		n = in.nextInt();
		cows = new int[n];
		for(int i = 0; i < n; i++) {
			cows[i]= in.nextInt();
		}
		
		max = n-1;
		for(int i = n-2; i >= 0; i--) {
			if(cows[i] < cows[i+1]) {
				max = i;
			}
			else {
				break;
			}
		}
		
		out.println(max);
		
		in.close();
		out.close();
		
	}
}
