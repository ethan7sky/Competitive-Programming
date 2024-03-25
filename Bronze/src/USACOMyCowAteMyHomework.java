import java.util.*;
import java.io.*;

public class USACOMyCowAteMyHomework {
	
	static Scanner in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, a[], min[];
	static long sum[];
	static TreeMap<Double, String> ans;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("homework.in"));
		out = new PrintWriter("homework.out");
		
		init();
		solve();
	}
	static void init() {
		
		n = in.nextInt();
		in.nextLine();
		a = new int[n];
		st = new StringTokenizer(in.nextLine());
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
		
		min = new int[n];
		sum = new long[n];
		
		ans = new TreeMap<Double, String>();
	}
	static void solve() {
		
		long total=0;
		int currmin = Integer.MAX_VALUE;
		for(int i=n-1; i>=0; i--) {
			
			total += a[i];
			currmin = Math.min(currmin, a[i]);
			
			sum[i] = total;
			min[i] = currmin;
		}
		for(int k=1; k<n-1; k++) {
			
			double avg = sum[k] - min[k];
			avg /= n-k-1;
			
			if(ans.containsKey(avg)) ans.put(avg,  ans.get(avg)+" "+k);
			else ans.put(avg, k+"");
		}
		
		String[] res = ans.get(ans.lastKey()).split(" ");
		for(int i=0; i<res.length; i++) {
			out.println(res[i]);
		}
		
		in.close();
		out.close();
		
	}
	
	
}