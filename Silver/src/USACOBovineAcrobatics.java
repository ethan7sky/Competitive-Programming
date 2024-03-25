import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class USACOBovineAcrobatics {
	
	static int n, m, k;
	static TreeMap<Integer, Integer> remaining;
	static Queue<Integer> towers;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		remaining = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			remaining.put(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		towers = new ArrayDeque<Integer>();

		Map.Entry<Integer, Integer> x;
		int ans=0;
		
		while(!remaining.isEmpty()) {
			
			x = remaining.firstEntry();
			
			if(ans<m) {
				towers.add(x.getKey());
				ans++;
			}
						
			else if(towers.peek()-x.getKey() >= k) {
				towers.add(x.getKey());
				towers.poll();
				ans++;
			}
			
			if(x.getValue()==1) remaining.remove(x.getKey());
			else remaining.put(x.getKey(), x.getValue()-1);
		}
		System.out.println(ans);
	}
}
