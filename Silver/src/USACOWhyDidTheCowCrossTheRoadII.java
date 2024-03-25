import java.util.*;
import java.io.*;

public class USACOWhyDidTheCowCrossTheRoadII {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, k, b;
	static long p[], ans;
	static HashSet<Integer> a;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("maxcross.in"));
		out = new PrintWriter("maxcross.out");
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		a = new HashSet<Integer>();
		for(int i=0; i<b; i++) a.add(Integer.parseInt(in.readLine()));
		
		p = new long[n+1];
		for(int i=1; i<n+1; i++){
			p[i] = p[i-1];
			if(a.contains(i)) p[i]++;
		}
		
		ans=n+1;
		for(int i=0; i<=n-k; i++){
			ans = Math.min(ans, p[i+k]-p[i]);
		}
		out.println(ans);
		
		in.close();
		out.close();
	}
}