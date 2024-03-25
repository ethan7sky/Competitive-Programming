import java.util.*;
import java.io.*;

public class USACOTheBovineShuffle_silver {
	
	static Scanner in;
	static StringTokenizer st;
	static int n, cnt, a[], b[];
	static PrintWriter out;
	static Queue<Integer> zero;
	
	public static void main(String[] args) throws IOException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("shuffle.in"));
		out = new PrintWriter("shuffle.out");
		init();
		solve();
		in.close();
		out.close();
	}
	static void init() {
		
		n = in.nextInt(); in.nextLine();
		a = new int[n];
		b = new int[n];
		st = new StringTokenizer(in.nextLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken())-1;
			b[a[i]]++;
		}
		zero = new LinkedList<Integer>();
		for(int i=0; i<n; i++) if(b[i] ==0)zero.add(i);
		cnt=0;
	}
	static void solve() {
		
		while(!zero.isEmpty()) {
			
			int idx = zero.poll();
			b[a[idx]]--;
			if(b[a[idx]]==0) {
				zero.add(a[idx]);
			}
		}
		for(int i=0; i<n; i++) if(b[i]!=0) cnt++;
		out.println(cnt);
	}
}