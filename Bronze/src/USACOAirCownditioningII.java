import java.util.*;
import java.io.*;

//just use brute force hehe
public class USACOAirCownditioningII {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, cowS[], cowE[], cowCool[], acS[], acE[], acReduce[], acCost[];
	static long a[];
	static ArrayList<String> combinations;
	static int min;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
	}
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cowS = new int[n];
		cowE = new int[n];
		cowCool = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			cowS[i] = Integer.parseInt(st.nextToken());
			cowE[i] = Integer.parseInt(st.nextToken());
			cowCool[i] = Integer.parseInt(st.nextToken());
		}
		
		a = new long[100];
		for(int i=0; i<n; i++) {
			for(int j=cowS[i]; j<=cowE[i]; j++) {
				a[j] += cowCool[i];
			}
		}
		
		acS = new int[m];
		acE = new int[m];
		acReduce = new int[m];
		acCost = new int[m];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			acS[i] = Integer.parseInt(st.nextToken());
			acE[i] = Integer.parseInt(st.nextToken());
			acReduce[i] = Integer.parseInt(st.nextToken());
			acCost[i] = Integer.parseInt(st.nextToken());
		}
		combinations = new ArrayList<String>();
		createcombinations("");
		
	}
	static void solve() {
		
		int min = Integer.MAX_VALUE;
		for(String combination: combinations) {
			
			long stalls[] = a.clone();
			int cost = 0;
			
			for(int i=0; i<m; i++) {
				if(combination.charAt(i)=='1') {
					
					for(int j=acS[i]; j<=acE[i]; j++) {
						stalls[j] -= acReduce[i];
					}
					cost += acCost[i];
				}
			}
			
			boolean works = true;
			for(int i=0; i<100; i++) {
				if(stalls[i] > 0) {
					works = false;
				}
			}
			if(works) min = Math.min(min, cost);
		}
		
		System.out.println(min);
		
		
		
	}
	
	
	
	static void createcombinations(String s) {
		
		if(s.length()==m) combinations.add(s);
		
		else {
			createcombinations(s+1);
			createcombinations(s+0);
		}
		
	}
}
