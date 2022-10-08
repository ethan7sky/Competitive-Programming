import java.util.*;
import java.io.*;

public class USACOContaminatedMilk {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int N, M, D, S, max;
	static boolean badmilk[], data[][];
	static milk a[];
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("badmilk.in"));
		out = new PrintWriter("badmilk.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		a = new milk[D+S];
		for(int i = 0; i < D; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = new milk(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
		}
		for(int i = D; i < D+S; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = new milk(Integer.parseInt(st.nextToken())-1, -1, Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(a);
		
		badmilk = new boolean[M];
		data = new boolean[N][M];
		
	}
	
	static void solve() {
		
		Arrays.fill(badmilk, true);
		for(milk t: a) {
			if(t.m == -1) {
				for(int i = 0; i < M; i++) {
					badmilk[i] = badmilk[i]&&data[t.p][i];
				}
			}
			else {
				data[t.p][t.m] = true;
			}
		}
		
		for(int i = 0; i < M; i++) {
			
			if(badmilk[i]) {
				int cnt = 0;
				for(int j = 0; j < N; j++) {
					if(data[j][i]) cnt++;
				}
				
				max = Math.max(max, cnt);
			}
		}
		
		out.println(max);
	}
	
	
	
	
	
	
	static class milk implements Comparable<milk> {

		int p, m, t;
		milk(int a, int b, int c){
			p = a;
			m = b;
			t = c;
		}
		
		public String toString() {
			return p+" "+m+" "+t;
		}
		
		@Override
		public int compareTo(USACOContaminatedMilk.milk o) {
			if(this.t == o.t) {
				return this.m-o.m;
			}
			return this.t-o.t;
		}
		
		
	}
	
}