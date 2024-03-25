import java.util.*;
import java.io.*;

public class USACOHighCardWins {
	
	static BufferedReader in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("highcard.in"));
		out = new PrintWriter("highcard.out");
		
		int n = Integer.parseInt(in.readLine());
		boolean[] a = new boolean[n*2];
		
		for(int i=0; i<n; i++) {
			a[Integer.parseInt(in.readLine())-1] = true;
		}
		int ans = 0;
		int falsesofar = 0;
		for(int i=n*2-1; i>=0; i--) {
			if(!a[i]) falsesofar++;
			else {
				if(falsesofar>0) {
					ans++;
					falsesofar--;
				}
			}
		}
		out.println(ans);
		
		in.close();
		out.close();
		
	}
	
}
