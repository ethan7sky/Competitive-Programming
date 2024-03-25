/* 
ID: ethan7s1
LANG: JAVA
PROB: beads
*/ 


import java.util.*;
import java.io.*;

public class beads {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter("beads.out");
		
		int n = in.nextInt();
		String s = in.next();
		
		int ans = 0;
		
		for(int i=0; i<=n; i++) {
			
			
			//left
			int lcnt=0;
			int idx=i-1;
			char bead = 'w';
			
			while(true) {
				
				if(lcnt==n) break;
				if(idx<0) idx=n-1;
				
				if(s.charAt(idx)=='w') lcnt++;
				else if(bead==s.charAt(idx)||bead=='w') {
					lcnt++;
					bead=s.charAt(idx);
				}
				else break;

				idx--;
			}
			//right
			int rcnt=0;
			idx=i;
			bead = 'w';
			
			while(true) {
				if(lcnt+rcnt>=n) break;
				if(idx>=n) idx=0;
				
				if(s.charAt(idx)=='w') rcnt++;
				else if(bead==s.charAt(idx)||bead=='w') {
					rcnt++;
					bead=s.charAt(idx);
				}
				else break;

				idx++;
			}
			
			ans = Math.max(ans, lcnt+rcnt);
		}
		out.println(ans);
		
		
		in.close();
		out.close();
	}
	
}
