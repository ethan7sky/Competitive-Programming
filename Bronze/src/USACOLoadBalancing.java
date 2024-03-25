import java.util.*;
import java.io.*;

public class USACOLoadBalancing {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, b, x[], y[], ans;
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("balancing.in"));
		out = new PrintWriter("balancing.out");
		
		st = new StringTokenizer(in.readLine());
		n = Integer.valueOf(st.nextToken());
		//b = Integer.valueOf(st.nextToken());
		
		x = new int[n];
		y = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			x[i] = Integer.valueOf(st.nextToken());
			y[i] = Integer.valueOf(st.nextToken());
		}
		
		int ans = 1000;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
				int currentx = x[i]+1;
				int currenty = y[j]+1;
				
				int tr = 0;
				int tl = 0;
				int br = 0;
				int bl = 0;			
				
				for(int k = 0; k < n; k++) {
					if(x[k] > currentx && y[k] > currenty) tr++;
					else if(x[k] > currentx && y[k] < currenty) br++;
					else if(x[k] < currentx && y[k] > currenty) tl++;
					else if(x[k] < currentx && y[k] < currenty) bl++;
				}
				
				int max = Math.max(Math.max(br, bl), Math.max(tr, tl));
				ans = Math.min(ans, max);
			}
		}
		out.println(ans);
		
		in.close();
		out.close();
		
	}
}
