import java.util.*;
import java.io.*;

public class USACOMooyoMooyo {
	
	static int n, k, cnt;
	static int a[][];
	static boolean v[][];
	static Scanner in;
	static PrintWriter out;
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new FileReader("mooyomooyo.in"));
		out = new PrintWriter("mooyomooyo.out");
		//in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
		out.close();
		
	}
	static void init() {
		
		n = in.nextInt();
		k = in.nextInt();
		
		a = new int[n][10];
		for(int i=0; i<n; i++) {
			String s = in.next();
			for(int j=0; j<10; j++) {
				a[i][j] = s.charAt(j)-'0';
			}
		}
	}
	
	static void solve() {
		
		while(true) {
			

			v = new boolean[n][10];
			boolean fall = false;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<10; j++) {
					if(a[i][j] == 0) continue;
					
					cnt=0;
					floodfill(i, j, a[i][j]);
					if(cnt>=k) {
						v = new boolean[n][10];
						changeto0(i, j, a[i][j]);
						fall = true;
					}
				}
			}
			if(!fall) break;
			fall();
		}
		print();
	}
	
	static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<10; j++) {
				sb.append(a[i][j]);
			}sb.append("\n");
		}
		out.print(sb);
	}
	
	
	static void floodfill(int i, int j, int c) {
		if(i<0 || j<0 || i>=n || j>=10 || a[i][j] != c || v[i][j]) return;
		
		cnt++;
		v[i][j] = true;
		
		floodfill(i+1, j, c);
		floodfill(i-1, j, c);
		floodfill(i, j+1, c);
		floodfill(i, j-1, c);
	}
	
	static void changeto0(int i, int j, int c) {
		if(i<0 || j<0 || i>=n || j>=10 || a[i][j] != c || v[i][j]) return;
		
		a[i][j]=0;
		v[i][j] = true;
		
		changeto0(i+1, j, c);
		changeto0(i-1, j, c);
		changeto0(i, j+1, c);
		changeto0(i, j-1, c);
	}
	
	static void fall() {
		
		for(int y=0; y<10; y++) {

			int idx=n-1;
			for(int x=n-1; x>=0; x--) {
				if(a[x][y]!=0) {
					a[idx][y] = a[x][y];
					idx--;
				}
				if(idx>=x) a[x][y] = 0;
			}
		}
	}
}
