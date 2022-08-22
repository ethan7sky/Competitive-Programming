import java.util.*;
import java.io.*;

public class USACOBullInAchinaShop {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int N, K;
	static boolean pieces[][][], original[][];
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("bcs.in"));
		out = new PrintWriter("bcs.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException{
		st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		
		original = new boolean[N][N];
		pieces = new boolean[K][N][N];
		
		for(int i = 0; i < N; i++) {
			String temp = in.readLine();
			for(int j = 0; j < N; j++) {
				if(temp.charAt(j) == '#') original[i][j] = true;
			}
		}
		
		for(int i = 0; i < K; i++) {
			for(int j = 0; j < N; j++) {
				String temp = in.readLine();
				for(int k = 0; k < N; k++) {
					if(temp.charAt(k) == '#') pieces[i][j][k] = true;
				}
			}
		}
	}
	
	static void solve() {
		executed:
		//choose two pieces
		for(int a = 0; a < K; a++) {
			for(int b = a+1; b < K; b++) {
				//choose a section of piece a to work with
				for(int ax = -N+1; ax < N; ax++) {
					for(int ay = -N+1; ay < N; ay++) {
						//choose a section of piece b to work with
						for(int bx = -N+1; bx < N; bx++) {
							for(int by = -N+1; by < N; by++) {
								
								boolean flag = true;
								
								check:
								for(int i = 0; i < N; i++) {
									for(int j = 0; j < N; j++) {
										
										boolean check1 = check(pieces[a], ax+i, ay+j);
										boolean check2 = check(pieces[b], bx+i, by+j);
										
										if(original[i][j] != (check1 || check2)) {
											flag = false;
											break check;
										}
									}
								}
								if(flag) {
									out.println(Math.min(a, b)+1 + " " +  (Math.max(a, b)+1));
									break executed;
								}
							}
						}
					}
				}
			}
		}
	}
	
	static boolean check(boolean check[][], int x, int y) {
		return x >= 0 && y >=0 && x < N && y < N && check[x][y];
	}
	
}
