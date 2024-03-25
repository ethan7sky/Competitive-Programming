import java.util.*;
import java.io.*;

public class CoinPiles {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(t-->0) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			boolean works = false;

			if(a==0&&b==0) {
				sb.append("YES\n"); continue;
			}
			
			if((a+b)%6==0) works = true;
			if((float)Math.max(a, b)/Math.min(a, b)<=2.0 && (a+b)%3==0) works = true;
			else works = false;
			
			
			if(works) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.print(sb);
	}
}
