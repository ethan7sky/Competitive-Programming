import java.util.*;
import java.io.*;

public class Frog2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int[] p = new int[n];
		Arrays.fill(p, Integer.MAX_VALUE);
		p[0] = 0;
		for(int i=0; i<n; i++) {
			for(int j=1; j<=k && i-j>=0; j++) {
				if(i-j<0) continue;
				p[i] = Math.min(p[i], p[i-j]+Math.abs(a[i]-a[i-j]));
			}
			//System.out.println(Arrays.toString(p));
		}
		System.out.print(p[n-1]);
	}
}
