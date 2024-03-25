import java.util.*;
import java.io.*;

public class BaekJoon2178 {
	
	static int n, m, ans, a[][];
	static int[] chng = {-1, 1, 0, 0};
	static Scanner in;
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);

		init();
		q.add(0); q.add(0);
		while(!q.isEmpty()) {
			maze(q.poll(), q.poll());
		}
		maze(0, 0);
		
		System.out.println(a[n-1][m-1]);
	}
	static void maze(int x, int y) {
		
		if(x==n-1 && y==m-1) return;
		for(int i=0; i<4; i++) {
			
			int nx = x+chng[i];
			int ny = y+chng[4-i-1];
			
			
			if(nx<0||nx>=n||ny<0||ny>=m) continue;
			if(a[nx][ny] != 1) continue;
			
			a[nx][ny] = a[x][y]+1;
			q.add(nx);
			q.add(ny);
		}
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();
		a = new int[n][m];
		for(int i=0; i<n; i++) {
			String s = in.next();
			for(int j=0; j<m; j++) a[i][j] = s.charAt(j)-'0';
		}		

		q = new LinkedList<Integer>();
	}
}
