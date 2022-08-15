import java.util.*;
import java.io.*;

public class USACOContaminatedMilk {
	
	static int N, M, D, S, sick[][], badmilk[], max;
	static boolean overlap[];
	static milk a[];
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("badmilk.in"));
		out = new PrintWriter("badmilk.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void solve() {

		badmilk = new int[M];
		for(int i = 0; i < S; i++) {

			overlap = new boolean[M];
			for(int j = 0; j < D; j++) {
				if(sick[i][0] == a[j].p && sick[i][1] > a[j].t) {
					if(overlap[a[j].m-1] == false) {
						badmilk[a[j].m -1]++;
						overlap[a[j].m-1] = true;
					}
				}
			}
		}
		
		max = 0;
		for(int i = 0; i < M; i++) {
			if(badmilk[i] == S) {
				
				overlap = new boolean[N];
				int milktype = i+1;
				int cnt = 0;
				for(int j = 0; j < D; j++) {
					if(a[j].m == milktype) {
						if(overlap[a[j].p-1] == false) {
							cnt++;
							overlap[a[j].p-1] = true;
						}
					}
				}
				max = Math.max(cnt, max);
			}
		}
		out.println(max);
		
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		a = new milk[D];
		for(int i = 0; i < D; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = new milk(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		
		Arrays.sort(a);
		
		sick = new int[S][2];
		for(int i = 0; i < S; i++) {
			st = new StringTokenizer(in.readLine());
			sick[i][0] = Integer.parseInt(st.nextToken());
			sick[i][1] = Integer.parseInt(st.nextToken());
		}
		
	}

	static class milk implements Comparable<milk>{
		
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
			
			return o.t-this.t;
		}
		
	}
	
	
}
