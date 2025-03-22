import java.util.*;
import java.io.*;

public class USACOCakeGame {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int T, N;
	static int a[];
	static long sum;
	static long p1[], p2[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(in.readLine());
		while(T-->0) {
			N = Integer.parseInt(in.readLine());
			
			sum = 0;
			
			a = new int[N];
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				sum += a[i];
			}
			p1 = new long[N+1];
			for(int i=1; i<=N; i++) {
				p1[i] = p1[i-1]+a[i-1];
			}
			p2 = new long[N+1];
			for(int i=N-1; i>=0; i--) {
				p2[i] = p2[i+1]+a[i];
			}
//			System.out.println(Arrays.toString(p1));
//			System.out.println(Arrays.toString(p2));
			
			long elsie = 0;
			for(int i=0; i<=N/2-1; i++) {
				int j = N/2-1 - i;
//				System.out.println(i+" "+j);
				elsie = Math.max(elsie, p1[i]+p2[N-j]);
			}
			
			System.out.println(sum-elsie+" "+elsie);
			
			
			
		}
	}
}
