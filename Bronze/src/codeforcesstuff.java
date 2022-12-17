import java.util.*;
import java.io.*;

public class codeforcesstuff {
	
	static BufferedReader in;
	static int[] a = {0, 1, 2, 3, 4, 5, 6, 7};
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		for(int i=0; i<n; i++) {
			
			in.readLine();
			
			char ans = '.';
			char[][] a = new char[8][8];
			
			for(int x=0; x<8; x++) {
				String line = in.readLine();
				for(int y=0; y<8; y++) {
					a[x][y] = line.charAt(y);					
				}
			}
			
			//rows
			for(int x=0; x<8; x++) {
				
				boolean works = true;
				char color = a[x][0];
				for(int j=0; j<8; j++) {
					if(a[x][j] != color) works = false;
				}
				if(works && color == 'R') {
					ans = color;
					break;
				}
			}
			for(int y=0; y<8; y++) {
				boolean works = true;
				char color = a[0][y];
				for(int j=0; j<8; j++) {
					if(a[j][y] != color) works = false;
				}
				
				if(works && color == 'B') {
					ans = color;
					break;
				}
			}
			
			System.out.println(ans);
			
		}
	}
}
