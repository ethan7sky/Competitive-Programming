import java.util.*;
import java.io.*;

public class CF538367C2 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n, m;
	static double mid;
	
	static ArrayList<Integer> adjAsc[], adjDesc[];
	static boolean hasCycle, ans[], v[], recStack[];
	static int ascCnt[], descCnt[];
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			st = new StringTokenizer(in.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			mid = (double)n/2;
			
			adjAsc = new ArrayList[n+1];
			adjDesc = new ArrayList[n+1];
			for(int i=0; i<=n; i++) {
				adjAsc[i] = new ArrayList<Integer>();
				adjDesc[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjAsc[b].add(a);
				adjDesc[a].add(b);
			}

//			System.out.println(Arrays.toString(adjAsc));
//			System.out.println(Arrays.toString(adjDesc));
			
			//check for cycles
			
			v = new boolean[n+1];
			recStack = new boolean[n+1];
			hasCycle = false;
			
			for(int i=1; i<=n; i++) {
				if(isCyclic(i)) hasCycle = true;
			}
//			System.out.println(hasCycle);
			
			if(hasCycle) {
				for(int i=0; i<n; i++) sb.append(0);
				sb.append("\n");
				continue;
			}
			
			ascCnt = new int[n+1];
			descCnt = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				v = new boolean[n+1];
				ascDfs(i);
				ascCnt[i]--;
			}
			for(int i=1; i<=n; i++) {
				v = new boolean[n+1];
				descDfs(i);
				descCnt[i]--;
			}
			

			ans = new boolean[n+1];
			Arrays.fill(ans, true);
			for(int i=1; i<=n; i++) {
				if(ascCnt[i] > mid || descCnt[i] > mid) {
					ans[i] = false;
				}
			}
			
			for(int i=1; i<=n; i++) {
				sb.append(ans[i]? 1:0);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	static void ascDfs(int node) {
		if(v[node]) return;
		v[node] = true;
		ascCnt[node]++;
		for(int i: adjAsc[node]) {
			if(!v[i]) {
				ascDfs(i);
			}
		}
	}
	static void descDfs(int node) {
		if(v[node]) return;
		v[node] = true;
		descCnt[node]++;
		for(int i: adjDesc[node]) {
			if(!v[i]) {
				descDfs(i);
			}
		}
	}
	static boolean isCyclic(int i) {
		if(recStack[i]) {
			return true;
		}
		if(v[i]) return false;
		v[i] = true;
		
		recStack[i] = true;
		
		for(int c: adjAsc[i]) {
			if(isCyclic(c)) return true;
		}
		recStack[i] = false;
		
		return false;
	}
}
