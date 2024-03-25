import java.util.*;
import java.io.*;

public class USACOMilkFactoryREVIEW {
	
	static Scanner in;
	static PrintWriter out;
	static int n, ans;
	static HashMap<Integer, String> walkways;
	static HashSet<String> visited;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("factory.in"));
		out = new PrintWriter("factory.out");
		
		n = in.nextInt();
		walkways = new HashMap<Integer, String>();
		for(int i=0; i<n-1; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			if(walkways.containsKey(b)) walkways.put(b, walkways.get(b)+"-"+a);
			else walkways.put(b, ""+a);
		}
		
		ans=-1;
		for(int i=1; i<=n; i++) {
			HashSet<String> prev = new HashSet<String>();
			prev.add(i+"");
			solve(i, prev);
			
			if(prev.size() == n) {
				ans=i;
				break;
			}
		}
		out.println(ans);
		
		in.close();
		out.close();
	}
	
	static void solve(int origin, HashSet<String> prev) {
		
		if(!walkways.containsKey(origin)) return;
		
		String[] destinations = walkways.get(origin).split("-");
		
		for(int i=0; i<destinations.length; i++) {
			
			if(prev.contains(destinations[i])) continue;
			else {
				HashSet<String> hs2 = prev;
				hs2.add(destinations[i]);
				solve(Integer.parseInt(destinations[i]), hs2);
			}
			
		}
		
	}
	
	
}
