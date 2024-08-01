import java.util.*;
import java.io.*;

public class CF539825F {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int n, p;
	static int MAX_N = (int)1e4+1;
	static long EV[] = new long[MAX_N];
	static long inverse[] = new long[MAX_N];
	static long p3 = 1;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		
		EV[1] = 0;
		sb.append("0 ");
		
		for(int i=1; i<MAX_N; i++) {
			inverse[i] = modInverse(i);
		}
		
		for(int i=2; i<=n; i++) {
			calc(i);
		}
		System.out.println(sb);
	}
	static void calc(int i) {
		
		long ans = 0;
		long denom = 0;
		long currChoose = 1;
		
		for(int k=1; k<=i-1; k++) {
			currChoose *= (long)i-(k-1);
			currChoose %= p;
			currChoose *= inverse[k];
			currChoose %= p;
			ans += EV[i-k]*currChoose;
			ans %= p;

			denom += currChoose;
			denom %= p;
		}
		
//		System.out.println(ans);
//		System.out.println(denom);

		p3 = (p3*3)%p;
		ans += p3;
		ans *= modInverse(denom);
		ans %= p;
		
		EV[i] = ans;	
		sb.append(ans).append(" ");
	}
	
	
	static long modInverse(long a) {
		long m = p;
		long y = 0, x = 1;
		
		long q, t;
		while(a>1) {
			q = a/m;
			t = m;
			m = a%m;
			a=t;
			t=y;
			
			y = x-q*y;
			x=t;
		}
		if(x<0) x += p;
		
		return x;
	}
}
