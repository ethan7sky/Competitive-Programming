import java.util.*;
import java.io.*;

public class USACOGuessTheAnimal {
	
	static BufferedReader in;
	static PrintWriter out;
	static String[][] chs;
	static int n, max;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("guess.in"));
		out = new PrintWriter("guess.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException{
		n = Integer.valueOf(in.readLine());
		chs = new String[n][];
		
		for(int i = 0; i < n; i++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			st.nextToken();
			
			int temp = Integer.valueOf(st.nextToken());
			
			chs[i] = new String[temp];
			for(int j = 0; j < temp; j++) {
				chs[i][j] = st.nextToken();
			}
		}
	}
	static void solve() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
				if(chs[i].length > chs[j].length || i==j) {
					continue;
				}
				
				int amt = 1;
				for(int k = 0; k < chs[i].length; k++) {
					if(Arrays.asList(chs[j]).contains(chs[i][k])) {
						amt++;
					}
				}
				max = Math.max(amt, max);
			}
		}
		out.println(max);
	}
}
