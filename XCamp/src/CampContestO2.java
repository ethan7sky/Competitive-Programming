import java.util.*;
import java.io.*;

public class CampContestO2 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] w = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				w[i][j] = in.nextInt();
			}
		}
		
		double[][] a = new double[n][n];
		double[][] b = new double[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				double avg = (double)(w[i][j]+w[j][i])/2.0;
				a[i][j] = avg;
				a[j][i] = avg;
				b[i][j] = w[i][j] - avg;
				b[j][i] = w[j][i] - avg;
				
			}
		}
		
//		for(int diag=0; diag<2*n-1; diag++) {
//			int left = Math.min(diag, n-1);
//			int right = Math.max(0, diag-n+1);
//			
//			//System.out.println(left+" "+right);
//			
//			double sum = 0.0;
//			int cnt=0;
//			while(left>=0 && right >=0 && left<n && right<n) {
//				sum += w[left][right];
//				cnt++;
//				left--;
//				right++;
//			}
//			double avg = sum/cnt;
//			
//			left = Math.min(diag, n-1);
//			right = Math.max(0, diag-n+1);
//			while(left>=0 && right >=0 && left<n && right<n) {
//				a[left][right] = avg;
//				b[left][right] = w[left][right] - avg;
//				left--;
//				right++;
//			}
//		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(a[i][j]).append(" ");
			}sb.append("\n");
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(b[i][j]).append(" ");
			}sb.append("\n");
		}
		System.out.print(sb);
	}
}
