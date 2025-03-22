import java.util.*;
import java.io.*;

public class baekjoon2912 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int N, C, M;
	static int a[];
	static ArrayList<Integer> c[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		a = new int[N];
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		c = new ArrayList[C+1];
		for(int i=1; i<=C; i++) c[i] = new ArrayList<Integer>();
		for(int i=0; i<N; i++) c[a[i]].add(i+1);
		
		
		M = Integer.parseInt(in.readLine());
		
		while(M --> 0) {
			st = new StringTokenizer(in.readLine());
			int A, B;
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			boolean works = false;
			for(int i=1; i<=C; i++) {
				int idx1 = Collections.binarySearch(c[i], A);
				int idx2 = Collections.binarySearch(c[i], B);

				if(idx1<0) idx1=-idx1-1;
				if(idx2<0) idx2=-idx2-2;
				
				int cnt = idx2-idx1+1;
				if(cnt>(B-A+1)/2.0) {
					works = true;
					sb.append("yes ").append(i).append("\n");
					break;
				}
			}
			if(!works) sb.append("no\n");
		}
		System.out.print(sb);
		
	}	
}
