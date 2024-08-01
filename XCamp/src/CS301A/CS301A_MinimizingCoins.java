package CS301A;
import java.util.*;
import java.io.*;

public class CS301A_MinimizingCoins {
	
	static int n, x;
	static int M = (int)1e6+1;
	static int[] c;
	static int[] a;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		c = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) c[i] = Integer.parseInt(st.nextToken());
		
		a = new int[x+1];
		Arrays.fill(a, M);
		a[0] = 0;
		
		for(int i=1; i<=x; i++) {
			int min = M;
			for(int coin: c) {
				if(i-coin>=0) min = Math.min(min, a[i-coin]+1);
			}
			a[i] = min;
		}
		
		if(a[x]==M) System.out.println(-1);
		else System.out.println(a[x]);
	}
}
