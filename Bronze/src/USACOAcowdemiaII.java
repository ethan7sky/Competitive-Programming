import java.util.*;

public class USACOAcowdemiaII {
	
	static int n, k;
	static char a[][];
	static String names[];
	static HashMap<String, Integer> idx;
	static Scanner in;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		solve();
	}
	static void init() {
		
		k = in.nextInt();
		n = in.nextInt();
		
		names = new String[n];
		for(int i=0; i<n; i++) names[i] = in.next();
		
		idx = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) idx.put(names[i], i);
		
		a = new char[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(a[i], '?');
			a[i][i] = 'B';
		}
	}
	
	static void solve() {
		
		for(int i=0; i<k; i++) {
			
			ArrayList<String> prev = new ArrayList<String>();
			
			for(int j=0; j<n; j++) {
				prev.add(in.next());
			}
			for(int j=0; j<n; j++) {
				
				String curr = prev.get(j);
				
				if(prev.size()!=0 && prev.get(prev.size()-1).compareTo(curr) > 0) {
					
					for(int k=0; k<prev.size(); k++) {
						a[idx.get(curr)][idx.get(prev.get(k))] = '1';
						a[idx.get(prev.get(k))][idx.get(curr)] = '0';
						
						System.out.println(prev+" "+curr+" = "+idx.get(curr)+" -- "+prev.get(k)+" = "+idx.get(prev.get(k)));
						for(int x=0; x<n; x++) { 
							for(int y=0; y<n; y++) { 
								System.out.print(a[x][y]); 
							} 
							System.out.println(); 
						}
						System.out.println();
					}
					prev.clear();
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



/*
import java.util.*;

public class USACOAcowdemiaII {
	
	static int n, k;
	static char a[][];
	static String names[];
	static HashMap<String, Integer> idx;
	static Scanner in;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		solve();
	}
	static void init() {
		
		k = in.nextInt();
		n = in.nextInt();
		
		idx = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) idx.put(in.next(), i);
		
		System.out.println(idx);
		
		a = new char[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(a[i], '?');
			a[i][i] = 'B';
		}
	}
	
	static void solve() {
		
		for(int i=0; i<k; i++) {
			
			String[] order = new String[n];
			
			for(int j=0; j<n; j++) order[j] = in.next();
			
			for(int j=1; j<n; j++) {
				
				if(order[j].compareTo(order[j-1]) > 0) {
					
					for(int k=j; k<n; k++) {
						
						a[idx.get(order[j])][idx.get(order[k])] = '1';
						a[idx.get(order[k])][idx.get(order[j])] = '0';
						
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
*/
