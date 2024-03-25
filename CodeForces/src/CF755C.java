import java.util.*;
import java.io.*;

public class CF755C {
	
	static int n, p[], cnt;
	static boolean v[], newtree;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		p = new int[n];
		v = new boolean[n];
		cnt=0;
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) p[i] = Integer.parseInt(st.nextToken())-1;
		
		for(int i=0; i<n; i++) {
			
			if(!v[i]) {
				newtree=true;
				HashSet<Integer> hs = new HashSet<Integer>();
				dfs(i, hs);
				if(newtree) cnt++;
			}
		}
		System.out.println(cnt);
	}
	static void dfs(int i, HashSet<Integer> hs) {
		
		if(v[i]&&!hs.contains(i)) {
			newtree=false;
			return;
		}
		if(v[i]&&hs.contains(i)) return;
		
		hs.add(i);
		v[i] = true;
		
		HashSet<Integer> hs2 = new HashSet<Integer>();
		hs2 = (HashSet) hs.clone();
		dfs(p[i], hs2);
		
	}
}
