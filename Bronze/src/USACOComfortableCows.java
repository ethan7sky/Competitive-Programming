import java.util.*;
import java.io.*;

public class USACOComfortableCows {
	
	static int n, cnt;
	static boolean a[][];
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		a = new boolean[1001][1001];
		

		cnt = 0;		
		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(in.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(iscomfortable(x, y)) cnt--;
			if(iscomfortable(x+1, y)) cnt--;
			if(iscomfortable(x-1, y)) cnt--;
			if(iscomfortable(x, y+1)) cnt--;
			if(iscomfortable(x, y-1)) cnt--;
			
			a[x][y] = true;

			if(iscomfortable(x, y)) cnt++;
			if(iscomfortable(x+1, y)) cnt++;
			if(iscomfortable(x-1, y)) cnt++;
			if(iscomfortable(x, y+1)) cnt++;
			if(iscomfortable(x, y-1)) cnt++;
			
			System.out.println(cnt);
		}
	}
	static boolean iscomfortable(int x, int y) {
		
		if(x < 0 || x > 1000 || y < 0 || y > 10000 || !a[x][y]) return false;
		
		int cnt = 0;
		if(x > 0 && a[x-1][y]) cnt++;
		if(y > 0 && a[x][y-1]) cnt++;
		if(x < 1000 && a[x+1][y]) cnt++;
		if(y < 1000 && a[x][y+1]) cnt++;		
		
		return cnt == 3;
	}
}
