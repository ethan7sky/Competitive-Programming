import java.util.*;
import java.io.*;

public class USACOModernArt {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, n2;
	static int[][] a;
	static int[][] p;
	static int[] xMin, xMax, yMin, yMax;
	static HashSet<Integer> ans, unique;
	
	public static void main(String[] args) throws IOException {
		
//		in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("art.in"));
		out = new PrintWriter("art.out");
		
		
		n = Integer.parseInt(in.readLine());
		a = new int[n][n];
		p = new int[n+2][n+2];
		
		n2 = (int)Math.pow(n, 2);
		xMin = new int[n2+1];
		xMax = new int[n2+1];
		yMin = new int[n2+1];
		yMax = new int[n2+1];
		
		Arrays.fill(xMin, Integer.MAX_VALUE);
		Arrays.fill(yMin, Integer.MAX_VALUE);
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if(a[i][j]==0) continue;
				xMin[a[i][j]] = Math.min(xMin[a[i][j]], i+1);
				xMax[a[i][j]] = Math.max(xMax[a[i][j]], i+1);
				yMin[a[i][j]] = Math.min(yMin[a[i][j]], j+1);
				yMax[a[i][j]] = Math.max(yMax[a[i][j]], j+1);
				
			}
		}
//		System.out.println(Arrays.toString(xMin));
//		System.out.println(Arrays.toString(xMax));
//		System.out.println(Arrays.toString(yMin));
//		System.out.println(Arrays.toString(yMax));
		
		for(int i=1; i<=n2; i++) {
			if(xMin[i]==Integer.MAX_VALUE) continue;
			else {
				p[xMin[i]][yMin[i]]++;
				p[xMax[i]+1][yMin[i]]--;
				p[xMin[i]][yMax[i]+1]--;
				p[xMax[i]+1][yMax[i]+1]++;
			}
		}
//		for(int i=0; i<=n; i++) {
//			for(int j=0; j<=n; j++) {
//				System.out.print(p[i][j]);
//			}System.out.println();
//		}System.out.println();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				p[i][j] = p[i][j] + p[i-1][j] + p[i][j-1] - p[i-1][j-1];
			}
		}
		
		ans = new HashSet<Integer>();
		for(int i=1; i<=n2; i++) ans.add(i);
		
//		for(int i=0; i<=n; i++) {
//			for(int j=0; j<=n; j++) {
//				System.out.print(p[i][j]);
//			}System.out.println();
//		}System.out.println();
		
		unique = new HashSet<Integer>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j]!=0) unique.add(a[i][j]);
				
				if(p[i+1][j+1]>1) {
					if(ans.contains(a[i][j])) {
						ans.remove(a[i][j]);
					}
				}
			}
		}
//		System.out.println(ans);
		if(unique.size()==1) ans.remove(1);
		out.println(ans.size());
		
		in.close();
		out.close();
		
	}
	
}
