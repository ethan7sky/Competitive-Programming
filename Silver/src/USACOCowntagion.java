import java.util.*;
import java.io.*;

public class USACOCowntagion {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, ans;
	static boolean v[];
	static ArrayList<Integer>[] roads;
	static ArrayList<Integer>[] newroads;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solvedfs(1);
		System.out.println(ans);
	}
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());
		roads = new ArrayList[n+1];
		newroads = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			roads[i] = new ArrayList<Integer>();
			newroads[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			roads[x].add(y);
			roads[y].add(x);
		}
		v = new boolean[n+1];
		bfs();
		
		ans=0;
	}
	static void solvedfs(int idx) {
		
		ans += Math.ceil((double)Math.log(newroads[idx].size()+1)/Math.log(2));
		for(int i: newroads[idx]) {
			ans++;
			solvedfs(i);
		}
		
		
	}
	
	static void bfs() {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		v[1]=true;
		
		while(!q.isEmpty()) {
			int idx = q.poll();
			for(int i: roads[idx]) {
				if(v[i]) continue;
				else {
					newroads[idx].add(i);
					v[i] = true;
					q.add(i);
				}
			}
		}
	}
}
