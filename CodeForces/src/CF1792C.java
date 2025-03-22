import java.util.*;
import java.io.*;

public class CF1792C {
	
	static int t, n, idx[];
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		testcases:
		while(t-->0 ) {
			n = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			idx = new int[n+1];
			for(int i=0; i<n; i++) {
				idx[Integer.parseInt(st.nextToken())] = i+1;
			}
			if(n%2==0) {
				if(idx[n/2] > idx[n/2+1]) {
					sb.append(n/2).append("\n");
					continue testcases;
				}
				int dist = 1;
				while(dist<n/2) {
					if(idx[n/2-dist] < idx[n/2-dist+1] && idx[n/2+1+dist] > idx[n/2+dist]) {
						dist++;
					}
					else {
						break;
					}
				}
				sb.append((n-dist*2)/2).append("\n");
			}
			else {
				int dist = 1;
				while(dist<=n/2) {
					if(idx[n/2+1-dist] < idx[n/2+2-dist] && idx[n/2+1+dist] > idx[n/2+dist]) {
						dist++;
					}
					else {
						break;
					}
				}
				sb.append((n-(2*dist-1))/2).append("\n");
			}
		}
		System.out.print(sb);
	}
}
