import java.util.*;
import java.io.*;

public class CF537969A {
	
	static char[] s;
	static int bit[][], n, q;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		s = in.readLine().toCharArray();
		n = s.length;
		
		bit = new int[26][n+1];
		initBIT();
		
		
		sb = new StringBuilder();
		
		q = Integer.parseInt(in.readLine());	
		while(q-->0) {
			
			st = new StringTokenizer(in.readLine());
			int t = Integer.parseInt(st.nextToken());
			if(t==1) {
				int idx = Integer.parseInt(st.nextToken());
				int c = st.nextToken().charAt(0)-'a';
				updateBIT(idx, c);
			}
			else {
				int lQ = Integer.parseInt(st.nextToken());
				int rQ = Integer.parseInt(st.nextToken());
				int sum = 0;
				for(int i=0; i<26; i++) {
					sum += calcBIT(i, rQ) - calcBIT(i, lQ-1)>0? 1:0;
				}
				sb.append(sum).append("\n");
			}
		}
		System.out.print(sb);
		
		
	}
	static int calcBIT(int letter, int x) {
		int sum = 0;
		while(x>0) {
			sum += bit[letter][x];
			x -= (x&-x);
		}
		return sum;
	}
	
	static void updateBIT(int idx, int c) {
		int oldc = s[idx-1]-'a';
		s[idx-1] = (char)(c+'a');
		
//		System.out.println("oldc = "+oldc);
		
		
		while(idx<=n) {
			bit[oldc][idx]--;
			bit[c][idx]++;
			idx += idx&-idx;
		}
	}
	
	static void initBIT() {
		for(int i=1; i<=n; i++) {
			int letter = s[i-1]-'a';
			int idx = i;
			while(idx<=n) {
				bit[letter][idx]++;
				idx += (idx&-idx);
			}
		}
	}
	
}
