/* 
ID: ethan7s1
LANG: JAVA
PROB: friday
*/ 

import java.util.*; import java.io.*;

public class friday {
	
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("friday.in"));
		out = new PrintWriter("friday.out");
		
		int n = in.nextInt()+1900;
		
		int[] res = new int[7];
		int[] monthcnt = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int currentday = 2;
		
		for(int i = 1900; i < n; i++) {
			
			if(i%4 == 0 && (i % 100 != 0 || i%400 == 0)) {
				monthcnt[1] = 29;
			}
			else {
				monthcnt[1] = 28;
			}
			
			for(int j = 0; j < 12; j++) {
				for(int k = 0; k < monthcnt[j]; k++) {
					if(k+1 == 13) {
						res[currentday]++;
					}
					currentday = (currentday+1)%7;
					
				}
			}
		}
		
		String ans = "";
		for(int i = 0; i < 7; i++) {
			ans += res[i]+" ";
		}
		out.println(ans.substring(0,ans.length()-1));
		
		in.close();
		out.close();
	}
}
