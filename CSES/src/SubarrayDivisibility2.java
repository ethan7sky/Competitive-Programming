import java.util.*;
import java.io.*;

public class SubarrayDivisibility2 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, p[];
	static HashMap<Integer, Integer> modcnt;
	static long sum;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		p = new int[n+1];
		
		p[0] = 1;
		long sum = 0;
		long ans = 0;
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			sum += x; sum %= n;
			if(sum<0) sum += n;
			
			ans += p[(int)sum];
			p[(int)sum]++;
		}
		System.out.println(ans);
	}
	static void meBeingStupid() {
		modcnt = new HashMap<Integer, Integer>();
		for(int i=1; i<=n; i++) {
			p[i] = (p[i-1]+Integer.parseInt(st.nextToken()))%n;
			if(modcnt.containsKey(p[i])) modcnt.put(p[i], modcnt.get(p[i])+1);
			else modcnt.put(p[i], 1);
		}
		System.out.println(Arrays.toString(p));
		for(int i: modcnt.keySet()) {
			System.out.println(i+" "+modcnt.get(i));
		}
		if(modcnt.containsKey(0)) {
			sum += modcnt.get(0)*(modcnt.get(0)-1)/2;
		}
		if(n%2==1 && modcnt.containsKey(n/2)) {
			sum += modcnt.get(n/2)*(modcnt.get(n/2)-1)/2;
		}
		for(int i=1; i<n/2; i++) {
			int l = 0;
			int r = 0;
			if(modcnt.containsKey(i)) l = modcnt.get(i);
			if(modcnt.containsKey((n-i)%n)) r = modcnt.get(i);
			
		}
		System.out.println(sum);
	}
}
