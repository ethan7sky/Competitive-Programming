import java.util.*;
import java.io.*;

public class USACOMilkingOrder {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int N, M, K, order[], a[], res;
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("milkorder.in"));
		out = new PrintWriter("milkorder.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	
	
	}
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		a = new int[N];
		order = new int[M];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<M; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(in.readLine());
			int cow = Integer.parseInt(st.nextToken()); 
			a[Integer.parseInt(st.nextToken())-1] = cow;
		}

		res = 0;
	}
	static void solve() {
		boolean contains1 = false;
		for(int i = 0; i < M; i++) {
			if(order[i] == 1) contains1 = true;
		}
		
		if(contains1) {
			int min = 0;
			for(int i = 0; i < M; i++) {

				int cow = order[i];
				int index = 0;
				
				for(int j = N-1; j >= min; j--) {
					if(a[j] == 0) {
						index = j;
					}
					else if(a[j] == cow) {
						index = j;
						break;
					}
				}
				min = index+1;
				a[index] = cow;
			}
			for(int i = 0; i < N; i++) {
				if(a[i] == 1) res = i+1;
			}
		}
	
		
		
		else {
			int max = N-1;
			for(int i = M-1; i >= 0; i--) {

				int cow = order[i];
				
				boolean contains = false;
				for(int j = max; j >= 0; j--) {
					if(a[j] == cow) {
						max = j-1;
						contains = true;
					}
				}
				if(!contains) {
					a[max] = cow;
					max -= 1;
				}
			}

			for(int i = 0; i < N; i++) {
				if(a[i] == 0) {
					res = i+1;
					break;
				}
			}
			if(res == 0) res = N+1;
		}		
		
		
		out.println(res);
	}
}
