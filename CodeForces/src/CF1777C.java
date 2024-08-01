import java.util.*;
import java.io.*;

public class CF1777C {
	
	static int t, n, m, a[];
	static ArrayList<Integer>[] factors;
	static HashMap<Integer, Integer> topics;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		
		sieveOfEratosthenes();
		
		sb = new StringBuilder();
		
		while(t-->0) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			a = new int[n];
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			//System.out.println(Arrays.toString(a));
			
			topics = new HashMap<Integer, Integer>();
			
			int s = 0;
			int e = -1;
			int minDiff = Integer.MAX_VALUE;
			
			while(true) {
				
				while(topics.size()==m) {
					minDiff=Math.min(minDiff, a[e]-a[s]);
					for(int i: factors[a[s]]) {
						if(i>m) break;
						topics.put(i, topics.get(i)-1);
						if(topics.get(i)==0) topics.remove(i);
					}
					s++;
				}
				
				e++;
				if(e>=n) break;
				for(int i: factors[a[e]]) {
					if(i>m) break;
					if(!topics.containsKey(i)) topics.put(i, 1);
					else topics.put(i, topics.get(i)+1);
				}			
			}
			
			if(minDiff==Integer.MAX_VALUE) sb.append("-1\n");
			else sb.append(minDiff).append("\n");
		}
		System.out.print(sb);
		
	}
	
//	static boolean canRemoveFirst(int s) {
//		for(int i: factors[a[s]]) {
//			if(i>m) break;
//			if(!topics.containsKey(i)||topics.get(i)<=1) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	static void sieveOfEratosthenes() {
		factors = new ArrayList[100001];
		
		for(int i=1; i<=100000; i++) factors[i] = new ArrayList<Integer>();

		for(int i=1; i<=100000; i++) {
			for(int j=i; j<=100000; j+=i) { 
				factors[j].add(i);
			}
		}
	}
}
