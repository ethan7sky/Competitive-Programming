import java.util.*;
import java.io.*;

public class CF1291D {
	
	static String s;
	static int t, n, a, b;
	static int[][] p;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		s = in.readLine().trim();
		n = s.length();
		t = Integer.parseInt(in.readLine());
		p = new int[n+1][];
		p[0] = new int[26];
		for(int i=1; i<=n; i++) {
			p[i] = p[i-1].clone();
			p[i][s.charAt(i-1)-'a']++;
		}
		sb = new StringBuilder();
		while(t-->0) {
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			int cnt=0;
			for(int i=0; i<26; i++) {
				if(p[b][i]-p[a-1][i]>0) cnt++;
			}
			if(a==b || s.charAt(a-1)!=s.charAt(b-1)||cnt>=3) {
				sb.append("Yes\n");
			}
			else sb.append("No\n");
		}
		System.out.print(sb);
		
		
	}
	
}
