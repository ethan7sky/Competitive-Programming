import java.util.*;
import java.io.*;

public class USACOCowntactTracing {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int N, T, Y, Z, state[];
	static HashSet<Integer> X;
	static interactions a[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader("tracing.in"));
		//out = new PrintWriter("tracing.out");
		
		init();
		solve();
		
		//in.close();
		//out.close();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		String temp = in.readLine();
		state = new int[N];
		for(int i = 0; i < N; i++) {
			state[i] = temp.charAt(i)-'0';
		}
		
		a = new interactions[T];
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = new interactions(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(a);
	}
	
	static void solve() {
		
		X = new HashSet<Integer>();
		Y = Integer.MAX_VALUE;
		Z = -1;
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(state));
		
		//patient zero
		for(int i = 0; i < N; i++) {
			//value of K
			for(int j = 0; j <= T; j++) {
				
				int[][] infected = new int[N][2];
				infected[i][0] = 1;
				for(int k = 0; k < T; k++) {
					
					//we have two cows, a[k].x and a[k].y, who shook hands
					//if 1 is infected, so is the other, but only if infected[a[k].x][1] < j
					
					int cow1 = a[k].x-1;
					int cow2 = a[k].y-1;
					
					if(infected[cow1][0]==1||infected[cow2][0]==1) {
						if(infected[cow1][0]==infected[cow2][0]) {
							continue;
						}
						else {
							if(infected[cow1][0]==1 && infected[cow1][1] < j) {
								infected[cow1][1]++;
								infected[cow2][0] = 1;
							}
							else if(infected[cow2][0]==1 && infected[cow2][1] < j) {
								infected[cow2][1]++;
								infected[cow1][0] = 1;
							}
						}
					}
					
				}
				
				boolean works = true;
				for(int k = 0; k < N; k++) {
					if(state[k] != infected[k][0]) {
						works = false;
					}
				}
				System.out.println(Arrays.deepToString(infected) + " " + i+" "+j);
				System.out.println(works);
				if(works) {
					X.add(i);
					Y = Math.min(Y, j);
					Z = Math.max(Z, j);
				}
			}
		}
		if(Z == T) {
			System.out.println(X.size() + " " + Y + " Infinity");
		}else {
			System.out.println(X.size() + " " + Y + " " + Z);
		}
	}
	
	
	
	
	static class interactions implements Comparable<interactions>{
		
		int t, x, y;
		interactions(int a, int b, int c){
			t = a;
			x = b;
			y = c;
		}
		
		public String toString() {
			return t+" "+x+" "+y;
		}
		
		@Override
		public int compareTo(USACOCowntactTracing.interactions o) {
			
			return this.t-o.t;
		}
	}
}
