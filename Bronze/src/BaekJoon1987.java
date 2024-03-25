import java.util.*;
import java.io.*;

public class BaekJoon1987 {
	
	static Scanner in;
	static int r, s, max;
	static char a[][];
	static int xchng[] = {-1, 1, 0, 0};
	static int ychng[] = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		r = in.nextInt();
		s = in.nextInt();
		a = new char[r][];
		for(int i=0; i<r; i++) {
			a[i] = in.next().toCharArray();
		}
		max=0;
		
		dfs(Character.toString(a[0][0]), 0, 0);
		System.out.println(max);
	}
	static void dfs(String prev, int x, int y) {
		
		max = Math.max(max, prev.length());
		
		for(int i=0; i<4; i++) {
			
			int nx = x + xchng[i];
			int ny = y + ychng[i];
			
			if(nx<0||nx>=r||ny<0||ny>=s) continue;
			
			String next = Character.toString(a[nx][ny]);
			if(prev.contains(next)) continue;
			
			dfs(prev+next, nx, ny);
		}
	}
}
