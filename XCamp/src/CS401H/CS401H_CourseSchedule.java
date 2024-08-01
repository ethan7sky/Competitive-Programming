package CS401H;
import java.util.*;
import java.io.*;

public class CS401H_CourseSchedule {
	
	static int n, m;
	static ArrayList<Integer> adj[];
	static Queue<Integer> nextToAdd;
	static int p[];
	static int cnt;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder ans;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) adj[i] = new ArrayList<Integer>();
		
		p = new int[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			p[b]++;
		}
		
		nextToAdd = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			if(p[i]==0) nextToAdd.add(i);
		}
		ans = new StringBuilder();
		
		while(!nextToAdd.isEmpty()) {
			int curr = nextToAdd.poll();
			ans.append(curr).append(" ");
			cnt++;
			for(int c: adj[curr]) {
				p[c]--;
				if(p[c]==0) nextToAdd.add(c);
			}
		}
		if(cnt != n) {
			System.out.println("IMPOSSIBLE");
		}
		else {
			System.out.println(ans.toString().trim());	
		}
	}
	
}
