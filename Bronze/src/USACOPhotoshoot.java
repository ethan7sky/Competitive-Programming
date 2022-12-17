import java.util.*;
import java.io.*;

public class USACOPhotoshoot {
	
	static Scanner in;
	static PrintWriter out;
	static int n, a[];
	static String ans;
	static ArrayList<Integer> c1, c2;
	
	public static void main(String[] args) throws IOException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("photo.in"));
		out = new PrintWriter("photo.out");
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	static void init() {
		
		n = in.nextInt();
		
		a = new int[n-1];
		for(int i=0; i<n-1; i++) {
			a[i] = in.nextInt();
		}
		
		c1 = new ArrayList<Integer>();
		c2 = new ArrayList<Integer>();
		int x = 1;
		int y = a[0]-1;
		while(y>0) {
			
			if(x!=y) {
				c1.add(x);
				c2.add(y);
			}
			x++;
			y--;
		}
	}
	static void solve() {
		
		ans="";
		for(int i=0; i<c1.size(); i++) {
			
			LinkedHashSet<Integer> check = new LinkedHashSet<Integer>();			
			check.add(c1.get(i));
			check.add(c2.get(i));
			
			int last = c2.get(i);
			
			for(int j=1; j<n-1; j++) {
				if(a[j]-last<=0) continue;
				check.add(a[j]-last);
				last = a[j]-last;
			}
			
			if(check.size() == n) {
				for(int j: check) {
					ans+=j+" ";
				}				
				break;
			}
		}
		
		out.println(ans.substring(0,ans.length()-1));
	}
}
