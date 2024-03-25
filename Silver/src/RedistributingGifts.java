import java.util.*;
import java.io.*;

public class RedistributingGifts {
	
	static int n;
	static int[][] a;
	static BufferedReader in;
	static StringTokenizer st;
	static HashSet<Integer> gifts;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		a = new int[n][n];
		gifts = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				gifts.add(a[i][j]);
			}
		}
		
	}
	
	static void trial_1() {
		int[] ans = new int[n];
		for(int j=0; j<n; j++) {
			for(int i=0; i<n; i++) {
				if(gifts.contains(a[i][j])&&ans[i]==0) {
					ans[i] = a[i][j];
					gifts.remove(a[i][j]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i: ans) sb.append(i).append("\n");
		System.out.print(sb);
		
	}
	
}
