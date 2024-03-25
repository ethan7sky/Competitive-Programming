import java.util.*;
import java.io.*;
 
public class CollectingNumbersII {
 
	static int n, m, vals[], idx[];
	static BufferedReader in;
	static StringTokenizer st;
 
	public static void main(String[] args) throws IOException {
 
		in = new BufferedReader(new InputStreamReader(System.in));
 
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
 
		st = new StringTokenizer(in.readLine());
		vals = new int[n+1];
		idx = new int[n+1];
 
		for(int i=1; i<=n; i++){
			vals[i] = Integer.parseInt(st.nextToken());
			idx[vals[i]] = i;
		}
 
		int ans = 1;
		for(int i=1; i<n; i++) {
			if(idx[i]>idx[i+1]) 
				ans++;
		}
		
		while(m-->0) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int val1 = vals[a];
			int val2 = vals[b];
			
			HashSet<Integer> pairs = new HashSet<Integer>();
			
			if(val1>1) pairs.add(val1-1);
			if(val1<n) pairs.add(val1);
			if(val2>1) pairs.add(val2-1);
			if(val2<n) pairs.add(val2);
			
			
			for(int s: pairs) 
				if(idx[s] > idx[s+1]) ans--;
			
			vals[a] = val2;
			vals[b] = val1;
			
			int temp = idx[val1];
			idx[val1] = idx[val2];
			idx[val2] = temp;
			
			for(int s: pairs) 
				if(idx[s] > idx[s+1]) ans++;
			
			System.out.println(ans);
		}
		
	}
	static class pair{
		int x, y;
		public pair(int a, int b) {
			x = a;
			y = b;
		}
		public String toString() {
			return x+" "+y;
		}
	}
}
