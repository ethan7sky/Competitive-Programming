import java.util.*;
import java.io.*;
public class USACOCountingLiars {
	
	static int n, p[];
	static char s[];
	static StringTokenizer st;
	static BufferedReader in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		
		init();
		solve();
		
	}
	static void init() throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		s = new char[n];
		p = new int[n];
		
		for(int i = 0; i <n; i++) {
			st = new StringTokenizer(in.readLine());
			s[i] = st.nextToken().charAt(0);
			p[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() {
		
		int answer = n;
		
		for(int i = 0; i < n; i++) {
			
			int x = p[i];
			
			int liars = 0;
			for(int j = 0; j < n; j++) {
				if(s[j] == 'G' && x < p[j] || s[j] == 'L' && x > p[j]) liars++;
			}
			
			answer = Math.min(answer,  liars);
		}
		System.out.println(answer);
	}
}
