import java.util.*;
import java.io.*;

public class USACOReverseEngineering {
	
	static Scanner in;
	static int t, n, m;
	static boolean output[];
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		t = in.nextInt();
		
		for(int i=0; i<t; i++) {
			
			n = in.nextInt();
			m = in.nextInt();
			
			output = new boolean[n];
			boolean works = true;
			
			
			//initial
			String init = in.next();
			boolean res = in.nextInt() == 1;
			for(int j=0; j<init.length(); j++) {
				output[j] = res == (init.charAt(j) == '1');
			}
			
			//System.out.println(Arrays.toString(output));
			
			for(int j=1; j<m; j++) {
				String input = in.next();
				int out = in.nextInt();
				
				//System.out.println(input+" "+out);
				
				int incorrect = 0;
				for(int k=0; k<input.length(); k++) {
					if(!((input.charAt(k)-'0'==out)==output[k])){
						incorrect++;
					}
				}
				//System.out.println(incorrect);
				if(incorrect == n) {
					works=false;
				}
			}
			
			if(works) System.out.println("OK");
			else System.out.println("LIE");
		}
		
		
	}
	
}
