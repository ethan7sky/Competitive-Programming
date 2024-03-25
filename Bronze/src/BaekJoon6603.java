import java.util.*;
import java.io.*;

public class BaekJoon6603 {
	
	static int n, a[];
	static LinkedList<Integer> list;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			sb = new StringBuilder();
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			init();
			solve();
		}
	}
	
	static void init() {
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
		list = new LinkedList<Integer>();
		
		Arrays.sort(a);
	}
	
	static void solve() {
		
		for(int i=0; i<n; i++) {
			dfs(i);
			list.clear();
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		list.add(a[start]);
		
		if(list.size()==6) {
			for(int i=0; i<list.size(); i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
		for(int i=start+1; i<n; i++) {
			dfs(i);
			list.remove(list.size()-1);
		}
	}
}
