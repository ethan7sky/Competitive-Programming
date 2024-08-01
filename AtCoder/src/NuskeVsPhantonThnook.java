import java.util.*;
import java.io.*;

public class NuskeVsPhantonThnook {
	
	static int n, m, q;
	static int[][] a, p, hp, vp;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder ans;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		a = new int[n+1][m+1];
		p = new int[n+1][m+1];
		hp = new int[n+1][m+1];
		vp = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			String line = in.readLine();
			for(int j=1; j<=m; j++) {
				a[i][j] = line.charAt(j-1)-'0';
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				p[i][j] = a[i][j] + p[i-1][j] + p[i][j-1] - p[i-1][j-1];
				if(a[i][j]==1) {
					if(a[i][j-1]==1) hp[i][j]++;
					if(a[i-1][j]==1) vp[i][j]++;
				}
				hp[i][j] += hp[i-1][j] + hp[i][j-1] - hp[i-1][j-1];
				vp[i][j] += vp[i-1][j] + vp[i][j-1] - vp[i-1][j-1];
			}
		}
		
		ans = new StringBuilder();
		
		while(q-->0) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int totalBlueCnt = p[x2][y2] - p[x1-1][y2] - p[x2][y1-1] + p[x1-1][y1-1];
			int hCnt = hp[x2][y2] - hp[x1-1][y2] - hp[x2][y1] + hp[x1-1][y1];
			int vCnt = vp[x2][y2] - vp[x1][y2] - vp[x2][y1-1] + vp[x1][y1-1];
			ans.append(totalBlueCnt-hCnt-vCnt).append("\n");
		}
		System.out.print(ans.toString());
	}
}
