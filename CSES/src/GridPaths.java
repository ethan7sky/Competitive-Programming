import java.util.*;
import java.io.*;

public class GridPaths {
	
	static boolean[][] v = new boolean[9][9];
	static int[] dirx = {0, 0, -1, 1};
	static int[] diry = {1, -1, 0, 0};
	static int[] path = new int[48];
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String s = in.next();
		for(int i=0; i<48; i++) {
			if(s.charAt(i)=='?') path[i] = 4;
			else if(s.charAt(i)=='U') path[i]=0;
			else if(s.charAt(i)=='D') path[i]=1;
			else if(s.charAt(i)=='L') path[i]=2;
			else path[i]=3;
		}
		
		for(int i=0; i<9; i++) {
			v[0][i] = true;
			v[i][0] = true;
			v[8][i] = true;
			v[i][8] = true;
		}
		
		int ans = recurse(0, 1, 1);
		System.out.println(ans);
	}
	public static int recurse(int pathIdx, int curX, int curY) {
		
		if(v[curX+1][curY]&&v[curX-1][curY]
				&&!v[curX][curY+1]&&!v[curX][curY-1]) {
			return 0;
		}
		if(v[curX][curY+1]&&v[curX][curY-1]
				&&!v[curX+1][curY]&&!v[curX-1][curY]) {
			return 0;
		}
		
		if(curX==7&&curY==1) {
			if(pathIdx==48) return 1;
			return 0;
		}
		if(pathIdx==48) return 0;
		
		int x=0;
		v[curX][curY] = true;
		
		if(path[pathIdx]<4) {
			int nx = curX + dirx[path[pathIdx]];
			int ny = curY + diry[path[pathIdx]];
			if(!v[nx][ny]) {
				x += recurse(pathIdx+1, nx, ny);
			}
		}
		//dead ends
		
		else {
			for(int i=0; i<4; i++) {
				if(v[curX+dirx[i]][curY+diry[i]]) continue;
				x += recurse(pathIdx+1, curX+dirx[i], curY+dirx[i]);
			}
		}
		
		v[curX][curY] = false;
		return x;
		
		
	}
}
