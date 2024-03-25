import java.util.*;
import java.io.*;

public class USACORangeReconstruction {
	
	static int d[][];
	static long min, max;
	static long current = 0;
	static BufferedReader in;
	static StringTokenizer st;
	static int n;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		d = new int[n][n];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(in.readLine());
			for(int j=i; j<n; j++){
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(Arrays.deepToString(d));
		
		min = 0L;
		max = 0;
		
		int[] ans = new int[n];
		ans[0]=0;
		
		for(int i=1; i<n; i++){
			if(d[0][i] != max-min){
				ans[i] = ans[i-1]+d[i-1][i];
			}
			else{
				ans[i] = ans[i-1]-d[i-1][i];
			}
			max = Math.max(max,ans[i]);
			min = Math.min(min,ans[i]);
		}
		System.out.println(Arrays.toString(ans));
		
	}
	
	
}