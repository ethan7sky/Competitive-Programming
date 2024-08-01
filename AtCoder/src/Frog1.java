import java.util.*;
import java.io.*;

public class Frog1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int[] p = new int[n];
		p[0] = 0;
		p[1] = Math.abs(a[1]-a[0]);
		for(int i=2; i<n; i++) {
			p[i] = Math.min(p[i-2]+Math.abs(a[i]-a[i-2]), p[i-1]+Math.abs(a[i]-a[i-1]));
		}System.out.print(p[n-1]);
	}
}
