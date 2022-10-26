import java.util.*; import java.io.*;

public class USACOTheGreatRevegetation {
	
	static int n, m, types[];
	static boolean a[][];
	static String ans;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("revegetate.in"));
		out = new PrintWriter("revegetate.out");
		//in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
		out.close();
		
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new boolean[n][n];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
			
			a[i1-1][i2-1] = true;
			a[i2-1][i1-1] = true;
		}
		
		types = new int[n];
		Arrays.fill(types, 0);
		
		System.out.println(Arrays.deepToString(a));
	
	}
	
	static void solve() {
		
		for(int i = 0; i < n; i++) {
			
			boolean[] no = a[i];
			String notavailable = "";
			for(int j = 0; j < no.length; j++) {
				if(no[j]) {
					notavailable += types[j];
				}
			}
			
			System.out.println(notavailable);
			
			int available = 1;
			while(true) {
				if(!notavailable.contains(available+"")) {
					types[i] = available;
					break;
				}
				available++;
			}
		}
		
		ans = "";
		for(int i = 0; i < n; i++) {
			ans += types[i];
		}
		
		out.println(ans);
	}
	
}
