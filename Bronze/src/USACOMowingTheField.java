import java.util.*;
import java.io.*;

public class USACOMowingTheField {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, len[], a[][], x, y;
	static char dir[];
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("mowing.in"));
		out = new PrintWriter("mowing.out");
		
		n = Integer.parseInt(in.readLine());
		
		len = new int[n];
		dir = new char[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			dir[i] = st.nextToken().charAt(0);
			len[i] = Integer.parseInt(st.nextToken());
		}		
		
		a = new int[2001][2001];
		a[1000][1000] = 1;
		
		x = 1000;
		y = 1000;
		
		int min = Integer.MAX_VALUE;
		
		int time = 1;
		
		for(int i = 0; i < n; i++) {
			
			char cdir = dir[i];
			int clen = len[i];
			
			for(int j = 0; j < clen; j++) {
				time++;
				
				if(cdir == 'N') {
					y++;
				}
				else if(cdir == 'E') {
					x++;				
				}
				else if(cdir == 'S') {
					y--;
				}
				else if(cdir == 'W') {
					x--;
				}
				
				if(a[x][y] != 0) {
					min = Math.min(min, time-a[x][y]);
				}
				
				a[x][y] = time;
				
				
			}
		}
		
		if(min == Integer.MAX_VALUE)min = -1; 
		
		out.println(min);
		
		in.close();
		out.close();
	}
	
}
