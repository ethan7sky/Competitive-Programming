import java.util.*;
import java.io.*;

public class USACOLivestockLineup2 {
	
	static Scanner in;
	static PrintWriter out;
	static int n, beside[][];
	static String ans;
	static ArrayList<String> permutations;
	static String cows[] = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"};
	static HashMap<String, Integer> getidx;
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new FileReader("lineup.in"));
		out = new PrintWriter("lineup.out");
		//in = new Scanner(System.in);
		
		
		init();
		solve();
		
		in.close();
		out.close();		
	}
	
	static void init() {
		
		n = in.nextInt();

		permutations = new ArrayList<String>();
		Arrays.sort(cows);
		createpermutations("");
		
		getidx = new HashMap<String, Integer>();
		for(int i=0; i<8; i++) {
			getidx.put(cows[i], i);
		}
		
		beside = new int[n][2];
		for(int i=0; i<n; i++) {
			
			String cow1 = in.next();
			in.next();in.next();in.next();in.next();
			String cow2 = in.next();
			
			beside[i][0] = getidx.get(cow1);
			beside[i][1] = getidx.get(cow2);
		}
	}
	
	static void solve() {
		
		for(int i=0; i<40320; i++) {
			
			boolean works = true;
			String lineup = permutations.get(i);
			for(int j=0; j<n; j++) {
				
				if(! (lineup.contains(beside[j][0] + "" + beside[j][1])
						|| lineup.contains(beside[j][1] + "" + beside[j][0]))) {
						works = false;
				}
			}
			if(works) {
				ans = lineup;
				break;
			}
		}
		for(int i=0; i<8; i++) {
			out.println(cows[ans.charAt(i)-'0']);
		}
		
	}
	
	static void createpermutations(String s) {
		
		if(s.length() == 8) {
			permutations.add(s);
			return;
		}
		
		for(int i=0; i<8; i++) {
			if(!s.contains(i+"")) createpermutations(s+i);
		}
	}
}
