import java.util.*;
import java.io.*;

public class USACOSubsequencesSummingToSevens {	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, max;
	static HashMap<Integer, Integer> mins;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("div7.in"));
		out = new PrintWriter("div7.out");
		
		n = Integer.parseInt(in.readLine());
		mins = new HashMap<Integer, Integer>();
		
		max=0;
		int x=0;
		for(int i=0; i<n; i++) {
			x =(x+Integer.parseInt(in.readLine()))%7;
			if(mins.containsKey(x)) max = Math.max(max, i-mins.get(x));
			else mins.put(x, i);
		}
		out.println(max);
		
		in.close();
		out.close();
	}
}
