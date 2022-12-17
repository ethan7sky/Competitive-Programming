import java.util.*;
import java.io.*;

public class USACOAcowdemiaIII {
	
	
	static int n, m, ans;
	static char a[][];
	static Scanner in;
	static HashSet<String> friends;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		init();
		solve();
	}
	static void init() {
		
		n = in.nextInt();
		m = in.nextInt();
		
		a = new char[n][];
		
		for(int i=0; i<n; i++) {
			a[i] = in.next().toCharArray();
		}
		
		friends = new HashSet<String>();
				
	}
	static void solve() {
		
		ans=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				if(a[i][j] != 'G') continue;
				
				int cnt=0;
				ArrayList<String> cows = new ArrayList<String>();
				if(cow(i+1, j)) { cnt++; cows.add(i+1+" "+j); }
				if(cow(i, j+1)) { cnt++; cows.add(i+" "+(j+1)); }
				if(cow(i-1, j)) { cnt++; cows.add(i-1+" "+j); }
				if(cow(i, j-1)) { cnt++; cows.add(i+" "+(j-1)); }
				
				if(cnt==2) {
					Collections.sort(cows);
					friends.add(cows.get(0) + cows.get(1));					
				}
				else if(cnt > 2) { 
					ans++;
				}
				
			}
		}
		ans += friends.size();
		System.out.println(ans);
	}
	static boolean cow(int x, int y) {
		
		return x>=0 && x<n && y>=0 && y<m && a[x][y]=='C';
	}
}
