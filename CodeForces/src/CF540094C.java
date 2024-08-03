import java.util.*;
import java.io.*;
public class CF540094C {

	static int t, n;
	static ArrayList<edge> adj[];
	static int[][] charCnt;
//	static Queue<Integer> toCheck;
	static HashSet<Character> multi[];
	static boolean v[], works[];
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		t = Integer.parseInt(in.readLine());
		
		testcases:
		while(t-->0) {
			n = Integer.parseInt(in.readLine());
			
			adj = new ArrayList[n+1];
			charCnt = new int[n+1][26];
//			toCheck = new LinkedList<Integer>();
			multi = new HashSet[n+1];
			
			for(int i=1; i<=n; i++) {
				adj[i] = new ArrayList<edge>();
//				toCheck.add(i);
				multi[i] = new HashSet<Character>();
			}
			
			for(int i=1; i<n; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				char letter = st.nextToken().charAt(0);
				
				adj[a].add(new edge(b, letter));
				adj[b].add(new edge(a, letter));
				letter -= 'a';
				charCnt[a][letter]++;
				charCnt[b][letter]++;				
			}
			
			for(int i=1; i<=n; i++) {
				for(int j=0; j<26; j++) {
					if(charCnt[i][j] == 2) {
						multi[i].add((char)(j+'a'));
					}
					else if(charCnt[i][j]>2){
						sb.append("0\n");
						continue testcases;
					}
				}
			}
			
			
			v = new boolean[n+1];
			works = new boolean[n+1];
			Arrays.fill(works, true);
			
			
			for(int curr=1; curr<=n; curr++) {
				
				if(multi[curr].size()>1) {
					sb.append("0\n");
					continue testcases;
				}
				else if(multi[curr].size()==1){
					works[curr] = false;
					for(edge e: adj[curr]) {
						if(!multi[curr].contains(e.c)) {
							boolean fails = dfs(e.to, curr, e.c);
							if(fails) {
								sb.append("0\n");
								continue testcases;
							}
						}
					}
				}
			}
			
			int ans=0;
			for(int i=1; i<=n; i++) {
				if(works[i]) ans++;
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
	}
	static boolean dfs(int node, int parent, char last) {
		
		if(v[node]) return false;
		v[node] = true;
		
		works[node] = false;
		
		if(multi[node].size()>1) {
			return true;
		}
		
		for(char c: multi[node]) {
			int count = charCnt[node][c-'a'];
			if(c==last) count--;
			if(count>=2) {
				return true;
			}
		}
		
		for(edge e: adj[node]) {
			if(e.to!=parent && !v[e.to]) {
				if(dfs(e.to, node, e.c)) {
					return true;
				}
			}
		}
		return false;
	}
	
	static class edge{
		int to;
		char c;
		public edge(int a, char b) {
			this.to = a;
			this.c = b;
		}
		public String toString() {
			return to+" "+c;
		}
	}
}
