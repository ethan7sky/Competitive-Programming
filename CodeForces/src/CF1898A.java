import java.util.*;
import java.io.*;

public class CF1898A {
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		
		while(t-->0){
			st = new StringTokenizer(in.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			String s = in.readLine();
			
			int idx = 0;
			int acnt= 0;
			int bcnt= 0;
			for(int i=0; i<n; i++) {
				if(s.charAt(i)=='B') {
					bcnt++;
					idx = i;
				}
				else acnt++;
			}
			if(bcnt==k)System.out.println(0);
			
			else if(bcnt>k) {
				System.out.println(1);
				
				int remove = bcnt-k;
				int ans=0;
				while(remove>0) {
					if(s.charAt(ans)=='B') remove--;
					ans++;
				}
				System.out.println(ans+ " A");
			}
			else {
				int ans = 0;
				while(bcnt<k) {
					if(s.charAt(ans)=='A')bcnt++;
					ans++;
				}
				System.out.println(1);
				System.out.println(ans+" B");
				
			}
			
			
			
//			
//			int[] p = new int[n+1];
//			int acnt = 0;
//			int bcnt = 0;
//			for(int i=1; i<=n; i++) {
//				p[i] = p[i-1];
//				if(s.charAt(i-1)=='B') {
//					p[i]++; 
//					bcnt++;
//				}
//				else acnt++;
//				
//			}
//			
//			System.out.println(Arrays.toString(p));
//			System.out.println(acnt+" "+bcnt);
//			
//			for(int a=0; a<=n; a++) {
//				for(int b=a+1; b<=n; b++) {
//					
//					int cnt = p[b] - p[a];
//					int len = b-a;
//					
//					if(bcnt+len-cnt==k) {
//						
//						if(a==0) {
//							System.out.println(1);
//							System.out.println(b+" b");
//						}
//						else {
//							System.out.println(2);
//							System.out.println(b+" B");
//							System.out.println(a+" A");
//						}
//						
//					}
//					if(bcnt-cnt==k) {
//						
//						if(a==0) {
//							System.out.println(1);
//							System.out.println(b+" A");
//						}
//						else {
//							System.out.println(2);
//							System.out.println(b+" A");
//							System.out.println(a+" B");
//						}
//					}
//					
//					
//					
//				}
//			}
//			
//			
//			int a = 0;
//			int b = 0;
//			for(int i=0; i<n; i++) {
//				if(s.charAt(i)=='A') a++;
//				else b++;
//			}
//			int ans = 0;
//			if(b<k) {
//				
//				int idx = 0;
//				while(b<k) {
//					if(s.charAt(idx)=='A') {
//						b++;
//						a--;
//					}
//					idx++;
//				}
//				
//				System.out.println(idx+"  B");
//				
//			}
//			else if (b>k){
//				
//				int idx=0;
//				while(b>k) {
//					if(s.charAt(idx)=='B') {
//						b--;
//						a++;
//					}
//					idx++;
//				}
//				
//				System.out.println(idx+"  A");
//			}
//			else {
//				System.out.println(0);
//			}
		}
		
		
	}
}
