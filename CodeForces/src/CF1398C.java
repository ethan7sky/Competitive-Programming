import java.util.*;
import java.io.*;

public class CF1398C {
	
	static int t, n, p[];
	static long ans;
	static HashMap<Integer, Integer> cnt;
	static BufferedReader in;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		while(t-->0) {
			
			n = Integer.parseInt(in.readLine());
			p = new int[n+1];
			String s = in.readLine();
			for(int i=0; i<n; i++) p[i+1] = p[i]+(s.charAt(i)-'0');	
			
			cnt = new HashMap<Integer, Integer>();
			cnt.put(0, 1);
			for(int i=1; i<=n; i++) {
				p[i] -= i;
				if(cnt.containsKey(p[i])) cnt.put(p[i], cnt.get(p[i])+1);
				else cnt.put(p[i], 1);
			}
			
			ans=0;
			for(int i: cnt.values()) {
				ans += (long)i*(i-1)/2;
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
		
		
	}
}
