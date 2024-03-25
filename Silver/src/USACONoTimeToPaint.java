import java.util.*;
import java.io.*;

public class USACONoTimeToPaint {
	
	static BufferedReader in;
	static StringTokenizer st;
	static String fence, left, right;
	static int n, q, a, b;
	static int pre[], suf[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		fence = in.readLine();
		
		pre = initpre();
		suf = initsuf();
		
		sb = new StringBuilder();
		
		while(q-->0) {
			
			st = new StringTokenizer(in.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			sb.append(pre[a-1]+suf[b]+"\n");
		}
		System.out.print(sb);
		
	}//beautiful
	static int[] initpre() {
		
		int[] lastseen = new int[26];
		Arrays.fill(lastseen, -1);
		
		int[] ans = new int[n+1];

		int cnt = 0;
		for(int i=0; i<n; i++) {
			
			int curr = fence.charAt(i)-'A';
			
			if(lastseen[curr]==-1) cnt++;
			else {
				for(int j=0; j<curr; j++) {
					if(lastseen[j] > lastseen[curr]) {
						cnt++;
						break;
					}
				}
			}
			
			lastseen[curr] = i;
			ans[i+1] = cnt;
		}
		return ans;
	
	}
	static int[] initsuf() {
		int[] lastseen = new int[26];
		Arrays.fill(lastseen, Integer.MAX_VALUE);
		
		int[] ans = new int[n+1];

		int cnt = 0;
		for(int i=n-1; i>=0; i--) {
			
			int curr = fence.charAt(i)-'A';
			
			if(lastseen[curr]==Integer.MAX_VALUE) cnt++;
			else {
				for(int j=0; j<curr; j++) {
					if(lastseen[j] < lastseen[curr]) {
						cnt++;
						break;
					}
				}
			}
			
			lastseen[curr] = i;
			ans[i] = cnt;
		}
		return ans;
	}
	
}
