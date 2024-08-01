import java.util.*;
import java.io.*;

public class CampContestS {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		int xidx=0;
		int yidx=0;
		for(int i=0; i<5; i++) {
			String[] s = in.readLine().split(" ");
			for(int j=0; j<5; j++) {
				if(s[j].equals("1")) {
					xidx=i;
					yidx=j;
				}
			}
		}
		
		xidx++;
		yidx++;
		
		System.out.println(Math.abs(3-xidx)+Math.abs(3-yidx));
	}
}
