import java.util.*;
import java.io.*;

public class USACOwordProcessor {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringBuilder sb;
	static StringTokenizer st;
	static int n,k;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("word.in"));
		out = new PrintWriter("word.out");
		sb = new StringBuilder();
		
		String[] input = in.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		
		st = new StringTokenizer(in.readLine());
		
		int linecnt = 0;
		for(int i = 0; i < n; i++) {
			String temp = st.nextToken();
			
			if(linecnt + temp.length() <= k) {
				
				if(linecnt != 0) {
					sb.append(" ");
				}
				sb.append(temp);
				linecnt += temp.length();
			}
			
			else {
				sb.append("\n"+temp);
				linecnt = temp.length();
			}
		}
		
		out.println(sb);
		
		in.close();
		out.close();
	}
}
