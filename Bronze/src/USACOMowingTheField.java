import java.util.*;
import java.io.*;

public class USACOMowingTheField {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, len[], a[][];
	static char dir[];
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		len = new int[n];
		dir = new char[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			dir[i] = st.nextToken().charAt(0);
			len[i] = Integer.parseInt(st.nextToken());
		}
		
		
		System.out.println(n);
		System.out.println(Arrays.toString(dir));
		System.out.println(Arrays.toString(len));
		
		
		a = new int[2001][2001];
		
		int startx = 1001;
		int starty = 1001;
		
		int max = -1;
		
		for(int i = 0; i < n; i++) {
			
			char cdir = dir[i];
			int clen = len[i];
			
			for(int j = 0; j < clen; j++) {
				a[startx][starty] = 1;
			}
		}
	}
	
}
