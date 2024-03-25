import java.util.*;
import java.io.*;

public class CF1791B {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		for(int j=0; j<t; j++) {
			int a = Integer.parseInt(in.readLine());
			
			int x = 0;
			int y = 0;
			
			Boolean works = false;
			String s = in.readLine();
			for(int i=0; i<a; i++) {
				if(s.charAt(i)=='L') x--;
				if(s.charAt(i)=='R') x++;
				if(s.charAt(i)=='U') y++;
				if(s.charAt(i)=='D') y--;
	            if(x==1 && y==1) {
	            	works = true;
	            	break;
	            }
			}
			if(works) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
