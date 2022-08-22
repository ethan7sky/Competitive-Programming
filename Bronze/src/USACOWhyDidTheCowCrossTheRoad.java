import java.io.*;
import java.util.*;

public class USACOWhyDidTheCowCrossTheRoad {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, cnt;
	static String a[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("crossroad.in"));
		out = new PrintWriter("crossroad.out");
		
		n = Integer.parseInt(in.readLine());
		a = new String[n];
		
		for(int i = 0 ; i < n; i++) {
			a[i] = "";
		}
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			a[Integer.parseInt(st.nextToken())-1] += Integer.parseInt(st.nextToken());
		}
		
		cnt = 0;
		for(int i = 0; i < n; i++) {
			
			for(int j = 1; j < a[i].length(); j++) {
				if(a[i].charAt(j) != a[i].charAt(j-1)) cnt++;
			}
		}
		out.println(cnt);
		
		in.close();
		out.close();
	}
}
