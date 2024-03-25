import java.util.*;
import java.io.*;

public class USACOComfortableCows {
	
	static int n, ans;
	static boolean cows[][];
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] cx = {0, 0, -1, 1, 0};
	static int[] cy = {1, -1, 0, 0, 0};
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		cows = new boolean[3001][3001];
		sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())+1000;
			int y = Integer.parseInt(st.nextToken())+1000;
			
			if(cows[x][y]) {
				ans--;
			}
			else {
				cows[x][y] = true;
				floodFill(x, y);
			}
			
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
	static void floodFill(int x, int y) {
		for(int i=0; i<5; i++) {
			int newX = x+cx[i];
			int newY = y+cy[i];
			
			if(cows[newX][newY]&&countCows(newX, newY)==3) {
				int ansX = 0;
				int ansY = 0;
				for(int j=0; j<4; j++) {
					if(!cows[newX+cx[j]][newY+cy[j]]) {
						ansX = newX+cx[j];
						ansY = newY+cy[j];
						break;
					}
				}
				
				ans++;
				cows[ansX][ansY] = true;
				floodFill(ansX, ansY);
			}
		}
	}
	static int countCows(int x, int y) {
		int cnt=0;
		for(int i=0; i<4; i++) {
			if(cows[x+cx[i]][y+cy[i]]) {
				cnt++;
			}
		}
		return cnt;
	}
}
