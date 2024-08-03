import java.util.*;
import java.io.*;

public class CF540341B {
	
	static int t, n, a[];
	static long ans;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			
			n = Integer.parseInt(in.readLine());
			
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<n; i++) {
				int k = Integer.parseInt(st.nextToken());
				while(k>=6) k/=6;
				if(k==5) k=4;
				else if(k==3) k=2;
				else if(k==1) k=0;
				if(i==0) ans=k;
				else ans ^= k;
			}
			sb.append(ans>0? "Nino\n":"Miku\n");
		}
		System.out.print(sb);
	}
	
	
}
