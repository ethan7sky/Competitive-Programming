import java.util.*;
import java.io.*;

public class USACOComfortableCows2 {
	
	static Scanner in;
	static int n, b[][], cnt;
	static  boolean a[][];
	static StringBuilder sb;
	
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		
		in = new Scanner(System.in);
		init();
		solve();
	}
	static void init() throws IOException {
		
		n = in.nextInt();
		a = new boolean[1001][1001];
		b = new int[1001][1001];
		sb = new StringBuilder();
		
		for(int i=0; i<n; i++) solve();
		
	}
	static void solve() {
		
		int x = in.nextInt();
		int y = in.nextInt();
		a[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>1000 || ny>1000) continue;
			
			b[nx][ny]++;
			
			if(b[nx][ny] == 3 && a[nx][ny]) cnt++;
			else if(b[nx][ny] == 4 && a[nx][ny]) cnt++;
			
			sb.append(cnt).append("\n");
		}
		System.out.println(cnt);
		
		
	}
}
