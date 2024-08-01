import java.util.*;
import java.io.*;

public class CF539597D {

	static int MOD = (int)1e9+7;
	static int n;
	static TreeSet<Integer> available;
	static long ans;
	static int lastAddedToA, lastAddedToB;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		available = new TreeSet<Integer>();
		for(int i=1; i<=2*n; i++) available.add(i);
		
		ans = 1;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			if(t==1) {
				int num1 = available.pollFirst();
				int num2 = x-num1;
				available.remove(num2);
				int min = Math.min(num1, num2);
				if(min>lastAddedToA && min > lastAddedToB) {
					ans *= 2;
				}
				lastAddedToA = num1;
				lastAddedToB = num2;
			}
			else if(t==2) {
				int num1 = available.pollFirst();
				int num2 = num1+x;
				available.remove(num2);
				int min = Math.min(num1, num2);
				if(min>lastAddedToA && min > lastAddedToB) {
					ans *= 2;
				}
				lastAddedToA = num1;
				lastAddedToB = num2;
			}
			else {
				int num1 = available.pollFirst();
				if(num1==x) {
					num1 = available.pollFirst();
				}
				else {
					available.remove(x);
				}
				int num2 = x;
				int min = Math.min(num1, num2);
				if(min>lastAddedToA && min > lastAddedToB) {
					ans *= 2;
				}
				lastAddedToA = num1;
				lastAddedToB = num2;
			}
//			System.out.println(ans+" "+lastAddedToA+" "+lastAddedToB);
//			System.out.println(available);
			ans %= MOD;
		}
		System.out.println(ans);
	}
}
