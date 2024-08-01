package LevelTest;
import java.util.*;
import java.io.*;

public class C_KnightMoves {
	
	static int n, s_x, s_y, e_x, e_y, ans;
	static boolean v[][], found;
	static Queue<cell> pos;
	static int[] cx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] cy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		s_x = in.nextInt();
		s_y = in.nextInt();
		e_x = in.nextInt();
		e_y = in.nextInt();
		v = new boolean[n][n];
		
		pos = new LinkedList<cell>();
		pos.add(new cell(s_x, s_y, 0));
		
		while(!found) {
			cell curr = pos.poll();
			search(curr.x, curr.y, curr.len);
		}
		
		System.out.println(ans);	
	}
	static void search(int x, int y, int len) {
		if(x<0||y<0||x>=n||y>=n) return;
		if(v[x][y]) return;
		v[x][y] = true;
		if(x==e_x && y==e_y) {
			found = true;
			ans = len;
			return;
		}
		for(int i=0; i<8; i++) {
			pos.add(new cell(x+cx[i], y+cy[i], len+1));
		}
	}
	static class cell {
		int x, y, len;
		public cell(int a, int b, int c) {
			this.x = a;
			this.y = b;
			this.len = c;
		}
	}
}
