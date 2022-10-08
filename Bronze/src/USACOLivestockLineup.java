import java.util.*;
import java.io.*;

public class USACOLivestockLineup {
	
	static TreeSet<String> set;
	static Scanner in;
	static PrintWriter out;
	static int n;
	static ArrayList<String> nextto;
	static HashMap<String, Integer> cownum;
	static String names[] = new String[] {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"}, ans;
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new FileReader("lineup.in"));
		out = new PrintWriter("lineup.out");
		//in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
		out.close();
		
	}
	
	static void init() throws IOException {
		
		n = in.nextInt();
		
		cownum = new HashMap<String, Integer>();
		
		for(int i = 0; i < 8; i++) {
			cownum.put(names[i], i);
		}
		
		nextto = new ArrayList<String>();
		
		for(int i = 0; i < n; i++) {
			int cow1 = cownum.get(in.next());
			in.next(); in.next(); in.next(); in.next();
			int cow2 = cownum.get(in.next());
			nextto.add(cow1+""+cow2);
		}
		
		set = new TreeSet<String>();
		
	}
	
	static void solve() {
		
		R("","01234567");
		
		for(String order: set) {
			boolean works = true;
			for(String t: nextto) {
				if(!(order.contains(t) || order.contains(t.substring(1)+t.substring(0,1)))){
					works = false;
					break;
				}
			}
			if(works) {
				ans = order;
				break;
			}
		}
		
		String res = "";
		for(int i = 0; i < 8; i++) {
			res += names[ans.charAt(i)-'0']+"\n";
		}
		out.print(res);
		
	}
	
	
	static void R(String left, String right) { //left = "", right = "123"
		if(right.length()==0) set.add(left);
		for(int i = 0; i < right.length(); i++) {
			String left1 = left + right.charAt(i);
			String right1 = right.substring(0,i) + right.substring(i+1);
			R(left1, right1);
		}
		
	}
}