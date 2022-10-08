import java.io.*;
import java.util.*;

public class USACOStuckInARut2 {
	
	static Scanner in;
	static PrintWriter out;
	static int n, dist[], dx, dy;
	static LinkedList<cows> E, N;
	static boolean stop[];
	
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		
		n = in.nextInt();
		
		stop = new boolean[n];
		dist = new int[n];
		E = new LinkedList<cows>();
		N = new LinkedList<cows>();
		
		for(int i = 0; i < n; i++) {
			char d = in.next().charAt(0);
			int x = in.nextInt();
			int y = in.nextInt();
			if(d=='E') E.add(new cows(i, x, y));
			else N.add(new cows(i, x, y));
		}
		
		Collections.sort(E, new Comparator<cows>() {
			@Override
			public int compare(USACOStuckInARut2.cows o1, USACOStuckInARut2.cows o2) {
				return o1.y-o2.y;
			}
			
		});
		Collections.sort(N, new Comparator<cows>() {
			@Override
			public int compare(USACOStuckInARut2.cows o1, USACOStuckInARut2.cows o2) {
				return o1.x-o2.x;
			}
			
		});
	}
	static void solve() {
		
		for(cows e: E) {
			for(cows n:N) {
				
				if(e.x>n.x || e.y<n.y || stop[e.id] || stop[n.id]) continue;
				dx = n.x-e.x;
				dy = e.y-n.y;
				
				if(dx>dy) {
					stop[e.id] = true;
					dist[e.id] = dx; 
				}
				else if(dx<dy) {
					stop[n.id]= true;
					dist[n.id] = dy; 
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n: dist) {
			if(n==0) sb.append("Infinity\n");
			else sb.append(n+"\n");
		}
		System.out.print(sb.toString());
	}
	
	
	static class cows {
		int id, x, y;
		cows(int a, int b, int c){
			id = a; x = b; y = c;
		}
		public String toString() {
			return id+" "+x+" "+y;
		}
	}
	
	
}
