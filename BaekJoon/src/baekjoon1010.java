import java.util.*;
import java.io.*;

public class baekjoon1010 {
	
	static int T;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(in.readLine());
		while (T-->0) {
			int N, M;
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			long ans = 1;
			for(int i=0; i<(M-N); i++) {
				ans *= M-i;
				ans /= i+1;
			}
			sb.append(ans).append("\n");
		}System.out.print(sb);
	}
	
}
