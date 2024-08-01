package CS400H;
import java.util.*;
import java.io.*;

public class CS400H_MatrixGame {
	
	static int n;
	static int[][] a;
	static StringBuilder sb;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		a = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++) {
			int min = Integer.MAX_VALUE;
			int minIdx=0;
			int max = -1;
			int maxIdx=0;
			for(int j=0; j<n; j++) {
				if(a[i][j]<min) {
					minIdx = j;
					min = a[i][j];
				}
				if(a[j][i]>max) {
					maxIdx = j;
					max = a[j][i];
				}
			}
			sb = new StringBuilder();
			
			a[i][minIdx] = max;
			a[maxIdx][i] = min;
			Arrays.sort(a[i]);
			
		}
		
		sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				sb.append(a[i][j]).append(" ");
			}
			sb.append(a[i][n-1]).append("\n");
		}System.out.print(sb);
	}
	
}
