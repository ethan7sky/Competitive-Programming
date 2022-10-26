import java.util.*;
import java.io.*;

public class USACOGrassPlanting {

	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, a[], max;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("planting.in"));
		out = new PrintWriter("planting.out");
		
		n = Integer.parseInt(in.readLine());
		a = new int[n];
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(in.readLine());
			a[Integer.parseInt(st.nextToken())-1]++;
			a[Integer.parseInt(st.nextToken())-1]++;
			
		}
		
		max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(max, a[i]);
		}
		out.println(max+1);
		
		in.close();
		out.close();
		
	}
}
