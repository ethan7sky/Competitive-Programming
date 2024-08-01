package LevelTest;
import java.util.*;
import java.io.*;

public class H_BackpackGroups {
	
	static int v, n, t;
	static HashMap<Integer, ArrayList<item>> a;
	static ArrayList<Integer> groups;
	static BufferedReader in;
	static StringTokenizer st;
	static int ans=0;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		
		v = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		a = new HashMap<Integer, ArrayList<item>>();
		groups = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if(!a.containsKey(z)) {
				a.put(z, new ArrayList<item>());
				groups.add(z);
			}
			a.get(z).add(new item(x, y));
		}
		solve(0, groups.size(), 0, 0);
		
		System.out.println(ans);
	}
	static void solve(int currIdx, int max, int weight, int val) {
		if(currIdx==max) {
			if(weight<=v) {
				ans = Math.max(ans, val);
			}
		}
		else {
			int groupNum = groups.get(currIdx);
			for(item i: a.get(groupNum)) {
				solve(currIdx+1, max, weight+i.w, val+i.v);
			}
			solve(currIdx+1, max, weight, val);
		}
	}
	
	
	static class item {
		int w, v;
		public item(int a, int b) {
			this.w = a;
			this.v = b;
		}
		public String toString() {
			return w+":"+v;
		}
	}
}
