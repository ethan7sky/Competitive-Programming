import java.util.*;
import java.io.*;

public class USACOBreedCounting {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, q, a[], b[], c[];
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("bcount.in"));
		out = new PrintWriter("bcount.out");
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		a = new int[n+1];
		b = new int[n+1];
		c = new int[n+1];
		for(int i=1; i<=n; i++){
			int j = Integer.parseInt(in.readLine());
			a[i] = a[i-1];
			b[i] = b[i-1];
			c[i] = c[i-1];
			
			if(j==1) a[i]++;
			else if(j==2) b[i]++;
			else c[i]++;
		}
		//System.out.println(Arrays.toString(a));
		//System.out.println(Arrays.toString(b));
		//System.out.println(Arrays.toString(c));
		
		for(int i=0; i<q; i++){
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken());
			String ans = "";
			ans += a[e]-a[s]+" ";
			ans += b[e]-b[s]+" ";
			ans += c[e]-c[s];
			out.println(ans);
		}
		
		in.close();
		out.close();
	
	}
}