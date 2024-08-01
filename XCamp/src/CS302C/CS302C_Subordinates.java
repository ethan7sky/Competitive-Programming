package CS302C;
import java.util.*;
import java.io.*;

public class CS302C_Subordinates {
	
	static int n;
	static ArrayList<Integer>[] p;
	static int[] cnt;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder res;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		p = new ArrayList[n+1];
		for(int i=1; i<n+1; i++) p[i] = new ArrayList<Integer>();
		
		st = new StringTokenizer(in.readLine());
		for(int i=2; i<n+1; i++) {
			int parent = Integer.parseInt(st.nextToken());
			p[parent].add(i);
		}
		
		cnt = new int[n+1];
		
		dfs(1);
		
		res = new StringBuilder();
		for(int i=1; i<n; i++) {
			res.append(cnt[i]).append(" ");
		}res.append(cnt[n]);
		System.out.println(res);
	}
	
	static void dfs(int id) {
		for(int c: p[id]) {
			dfs(c);
			cnt[id] += cnt[c]+1;
		}
	}
}
