import java.util.*;
import java.io.*;

public class NumberSpiral {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, x, y;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		sb = new StringBuilder();
		
		while(n-->0){
			st = new StringTokenizer(in.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			long max = (long)Math.max(x, y);
			long xx = (max-1)*max+1;
			if(max%2==0){
    			xx += max-y;
	    		xx -= max-x;
			}
			else{
			    xx -= max-y;
			    xx += max-x;
			}
			sb.append(xx).append("\n");
		}
		System.out.print(sb);
		
	}
	
}