import java.util.*;
import java.io.*;

public class ForestQueries {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, q, forest[][], ans;
	static int x1, y1, x2, y2;
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		forest = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			String s = in.readLine();
			for(int j=1; j<=n; j++)	{
				int x = s.charAt(j-1)=='*'? 1:0;
				forest[i][j] = forest[i-1][j] + forest[i][j-1] - forest[i-1][j-1] + x;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<q; i++) {
			
			st = new StringTokenizer(in.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			ans = forest[x2][y2] - forest[x1-1][y2] - forest[x2][y1-1] + forest[x1-1][y1-1];
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
		
	}
	
}
