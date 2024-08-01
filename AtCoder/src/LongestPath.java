import java.util.*;
import java.io.*;

public class LongestPath {
	
	static BufferedReader in;
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	static int ans = 0;
	static int n, m;
	static boolean[] v;
	static Queue<Integer> nextToAdd;
	static int parentCnt[];
	static int maxDist[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) adj[i] = new ArrayList<Integer>();
		parentCnt = new int[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			parentCnt[b]++;
		}
		nextToAdd = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			if(parentCnt[i]==0) nextToAdd.add(i);
		}
		//System.out.println(nextToAdd);
		
		maxDist = new int[n+1];
		
		while(!nextToAdd.isEmpty()) {
			int next = nextToAdd.poll();
			for(int c: adj[next]) {
				maxDist[c] = Math.max(maxDist[c], maxDist[next]+1);
				parentCnt[c]--;
				if(parentCnt[c]==0) nextToAdd.add(c);
			}
		}
		ans=0;
		for(int i=0; i<=n; i++) {
			ans = Math.max(ans, maxDist[i]);
		}
		System.out.println(ans);
	}
}
