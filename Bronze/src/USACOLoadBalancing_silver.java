import java.io.*; import java.util.*;

public class USACOLoadBalancing_silver {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, x[], y[], ans;
	
	public static void main(String[] args) throws IOException{
		
		//in = new BufferedReader(new FileReader("balancing.in"));
		//out = new PrintWriter("balancing.out");
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
  
		long xsum = 0;
		long ysum = 0; 
		
		x = new int[n];
		y = new int[n];
  
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
      
			xsum += x[i];
			ysum += y[i];
		}
  
		int xavg = (int)(xsum/n);
		int yavg = (int)(ysum/n);
  
		if(xavg%2==1) xavg--;
		if(yavg%2==1) yavg--;
		
		ans = solve(xavg, yavg);
		System.out.println(ans);
		
		
		in.close();
		out.close();
	}		
	
	static int solve(int xavg, int yavg) {
		int q1 = 0;
		int q2 = 0;
		int q3 = 0;
		int q4 = 0;
		for(int i = 0; i < n; i++) {
			if(x[i] > xavg && y[i] > yavg) q1++;
			else if(x[i] < xavg && y[i] > yavg) q2++;
			else if(x[i] <= xavg && y[i] <= yavg) q3++;
			else if(x[i] >= xavg && y[i] <= yavg) q4++;
		}
		
		int res = Math.max(Math.max(q1, q2), Math.max(q3, q4));
		return res;
	}
}
