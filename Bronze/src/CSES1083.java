import java.util.*;
import java.io.*;

public class CSES1083  {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int amt = Integer.valueOf(in.readLine());
		String input = in.readLine();

		StringTokenizer st = new StringTokenizer(input);
		
		long sum = (long)(0.5 * amt * (amt+1));	
		
		for(int i= 0; i < amt-1; i++) {
			sum -= Long.parseLong(st.nextToken());
		}
		
		System.out.println(sum);
		
	}
}
