import java.util.*;
import java.io.*;

public class USACOCereal2_2 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static boolean v[], cycle[], getCereal[];
	static ArrayList<Integer> order;
	static int n, m, first = -1, ignore, hungry;
	static ArrayList<cow>[] a;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
		in.close();
		
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[m+1];
		for(int i=0; i<=m; i++)
			a[i] = new ArrayList<cow>();
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[x].add(new cow(i, y, false));
			a[y].add(new cow(i, x, true));
		}
		
		v = new boolean[m+1];
		getCereal = new boolean[n+1];
		cycle = new boolean[m+1];
		order = new ArrayList<Integer>();
	}
	static void solve() {
		
		for(int i=1; i<=m; i++) {
			first = -1;
			ignore = -1;
			
			if(!v[i]) {
				
				findCycle(i, -1);
				
				if(first != -1) {
					dfs(first);
				}
				else {
					dfs(i);
				}
			}
		}
		for(int i=1; i<=n; i++) {
			if(!getCereal[i]) {
				hungry++;
				order.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(hungry).append("\n");
		for(int o: order) {
			sb.append(o).append("\n");
		}
		System.out.print(sb.toString());
		
	}
	static void findCycle(int cur, int prev) {
		cycle[cur] = true;
		
		for(cow next: a[cur]) {
			if(!cycle[next.to]) findCycle(next.to, cur); 
			else {
				
				if(first == -1 && next.to != prev) {
					if(next.fav)first = next.to;
					else first = cur;
					
					ignore = next.id;
					order.add(next.id);
					getCereal[next.id] = true; 
				}
			}
		}
		
		
	}
	
	
	static void dfs(int cur) {
		v[cur] = true;
		
		for(cow next: a[cur]) {
			
			if(!v[next.to] && next.id != ignore) {
				getCereal[next.id] = true;
				order.add(next.id);
				dfs(next.to);
			}
		}
	}
	
	static class cow{
		int id, to;
		boolean fav;
		
		
		cow(int a, int b, boolean c){
			id = a;
			to = b; 
			fav = c;
		}
		public String toString() {
			return id+" "+to+" "+fav;
		}
	}
	
}
