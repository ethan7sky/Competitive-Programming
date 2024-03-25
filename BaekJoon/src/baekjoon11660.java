import java.util.*;
import java.io.*;

public class baekjoon11660 {
	
	static int n, m, p[][];
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		p = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(in.readLine()); 
			for(int j=1; j<=n; j++) {
				int x = Integer.parseInt(st.nextToken());
				p[i][j] = x+p[i-1][j]+p[i][j-1]-p[i-1][j-1];
			}
		}		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			sb.append(p[x2][y2]-p[x1-1][y2]-p[x2][y1-1]+p[x1-1][y1-1]).append("\n");
		}
		System.out.print(sb);
		
		
	}
	
}
