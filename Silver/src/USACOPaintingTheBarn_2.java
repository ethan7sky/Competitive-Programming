import java.util.*;
import java.io.*;

public class USACOPaintingTheBarn_2 {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, k, ans;
	static int[][] p;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader(new File("paintbarn.in")));
		//out = new PrintWriter(new File("paintbarn.out"));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		p = new int[1002][1002];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			p[x1+1][y1+1]++;
			p[x1+1][y2+1]--;
			p[x2+1][y1+1]--;
			p[x2+1][y2+1]++;
		}

//		for(int i=0; i<=10; i++) {
//			for(int j=0; j<=10; j++) {
//				if(p[i][j]==-1)
//					System.out.print("N");
//				else System.out.print(p[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("-------");
		
		ans = 0;
		for(int i=1; i<=1000; i++) {
			for(int j=1; j<=1000; j++) {
				p[i][j] = p[i][j]+p[i-1][j]+p[i][j-1]-p[i-1][j-1];
				if(p[i][j]==k) ans++;
			}
		}
		
		for(int i=0; i<=10; i++) {
			for(int j=0; j<=10; j++) {
				if(p[i][j]<0)
					System.out.print("N");
				else System.out.print(p[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(ans);
		
		//out.println(ans);
		in.close();
		//out.close();
	}
}
