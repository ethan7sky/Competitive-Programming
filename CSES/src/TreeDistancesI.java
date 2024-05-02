import java.util.*;
import java.io.*;

public class TreeDistancesI {
	
	static int n;
	static int MAX_N = 200000;
	static ArrayList<Integer>[] e;
	static int[] firstMax = new int[MAX_N+1];
	static int[] secondMax = new int[MAX_N+1];
	static int[] c = new int[MAX_N+1];
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		e = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			e[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			e[x].add(y);
			e[y].add(x);
		}
		
		dfs1(1, -1);
		dfs2(1, -1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			sb.append(firstMax[i]).append(" ");
		}
		System.out.println(sb);
		
	}
	static void dfs1(int n, int p) {
		
		firstMax[n] = 0;
		secondMax[n] = 0;
		
		for(int i: e[n]) {
			if(i==p) continue;
			dfs1(i, n);
			
			if(firstMax[i]+1 > firstMax[n]) {
				secondMax[n] = firstMax[n];
				firstMax[n] = firstMax[i]+1;
				c[n] = i;
			}
			else if(firstMax[i]+1 > secondMax[n]) {
				secondMax[n] = firstMax[i]+1;
			}
		}
	}
	static void dfs2(int n, int p) {
		
		for(int i: e[n]) {
			if(i==p) continue;
			
			if(i==c[n]) {
				if(secondMax[n]+1 > firstMax[i]) {
					secondMax[i] = firstMax[i];
					firstMax[i] = secondMax[n]+1;
					c[i] = n;
				}
				else {
					secondMax[i] = Math.max(secondMax[i], secondMax[n]+1);
				}
			}
			else {
				secondMax[i] = firstMax[i];
				firstMax[i] = firstMax[n]+1;
				c[i] = n;
			}
			dfs2(i, n);
		}
	}
}
