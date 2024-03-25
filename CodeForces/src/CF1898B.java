import java.util.*;
import java.io.*;

public class CF1898B {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int t, n, mingoal, min;
	static long ans;
	static ArrayList<Integer> a;
	
	public static void main(String[] args) throws IOException {
		
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(t-->0) {
			
			n = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			a = new ArrayList<Integer>();
			ans=0;
			
			for(int i=0; i<n; i++) a.add(Integer.parseInt(st.nextToken()));
			
			for(int i=n-1; i>0; i--) {
				
				if(a.get(i-1)>a.get(i)) {
					
					if(a.get(i)==1) {
						ans += a.get(i-1)-1;
					}
					else {
						
						split(a.get(i-1),a.get(i));
					}
					
					int x = calc(a.get(i-1), a.get(i));
					
					a.add(i-1, x);
					
				}
				
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
		
	}
	static int calc(int a, int b) {

		int y = (int) Math.ceil(Math.log10((double)a/b)/Math.log10(2));
		double x = a/(Math.pow(2,y));
		return (int)Math.floor(x);
	}
	static void split(int x, int mingoal) {
		
		if(x<=mingoal) return;
		ans++;
		split(x/2, mingoal);
		split(x-x/2, mingoal);
	}
//	static void split(int x) {
//		
//		if(x<=mingoal) return;
//		
//		int a = x/2;
//		int b = x-a;
//		ans++;
//		min = a;
//		
//		split(a);
//		split(b);
//		
//	}
}
