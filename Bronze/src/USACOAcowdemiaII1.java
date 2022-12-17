import java.util.*;

public class USACOAcowdemiaII1 {
	
	
	static Scanner in;
	static int k, n;
	static char a[][];
	static HashMap<String, Integer> m;
	
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		init();
		solve();
	}
	
	static void init() {
		
		k = in.nextInt();
		n = in.nextInt();
		
		a = new char[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(a[i], '?');
			a[i][i] = 'B';
		}
		
		m = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) {
			m.put(in.next(), i);
		}
		in.nextLine();
	}
	static void solve() {
		
		for(int i=0; i<k; i++) {
			
			String[] order = in.nextLine().split(" ");
			
			for(int j=0; j<n; j++) {
				
				boolean sort = true;
				for(int l=j+1; l<n; l++) {
					
					if(order[l-1].compareTo(order[l]) > 0 ) sort = false;
					if(!sort) {
						int x = m.get(order[j]);
						int y = m.get(order[l]);
						a[x][y] = '0';
						a[y][x] = '1';
					}
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
