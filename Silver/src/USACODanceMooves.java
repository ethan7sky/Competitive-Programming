import java.util.*;
import java.io.*;

public class USACODanceMooves {
	
	static int n, k, cows[], ans[];
	static BufferedReader in;
	static StringTokenizer st;
	static ArrayList<Integer>[] v;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		cows = new int[n+1];
		v = new ArrayList[n+1];
		ans = new int[n];
		
		for(int i=0; i<n; i++) {
			v[i+1] = new ArrayList<Integer>();
			v[i+1].add(i+1);
			cows[i+1] = i+1;
		}
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int cow1 = cows[a];
			int cow2 = cows[b];
			
			v[cow1].add(b);
			v[cow2].add(a);
			
			cows[a] = cow2;
			cows[b] = cow1;
		}
		
		System.out.println(Arrays.toString(cows));
		
		boolean cntd[] = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			if(!cntd[i]) {
				
				ArrayList<Integer> cycled = new ArrayList<Integer>();
				int idx = i;
				while(!cntd[idx]) {
					cycled.add(idx);
					cntd[idx] = true;
					idx = cows[idx];
				}
				
				HashSet<Integer> set = new HashSet<Integer>();
				for(int cow: cycled) {
					set.addAll(v[cow]);
				}
				for(int cow: cycled) {
					ans[cow-1] = set.size();
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i: ans) {
			sb.append(i).append("\n");
		}
		System.out.print(sb);
	}
	
	
}
