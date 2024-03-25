import java.util.*;
import java.io.*;

public class USACORentalService_silver {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m, r, milk[], profit[];
	static TreeMap<Integer, Integer> stores;
	static ArrayList<Integer> rent;
	static long ans;
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("rental.in"));
		out = new PrintWriter("rental.out");
		//in = new BufferedReader(new InputStreamReader(System.in));
		
		init(); 
		solve();
		
		in.close();
		out.close();
		
	}
	static void solve() {
		
		start:
		for(int i=n-1; i>=0; i--) {
			
			int price = stores.lastKey();
			int curr = milk[i];
			int gallon = stores.get(price);
			
			while(curr>0) {
				
				int sold = Math.min(curr, gallon);
				profit[i] += price*sold;
				
				gallon -= sold;
				curr -= sold;
				
				if(gallon == 0) {
					stores.remove(price);
					if(stores.size()==0) break start;
					price = stores.lastKey();
					gallon = stores.get(price);
				}
				else {
					stores.put(price, gallon);
				}
			}
		}
		
		for(int i=0; i<profit.length; i++) {
			if(rent.size()>0 && 
					profit[i] < rent.get(rent.size()-1)) {
				profit[i] = rent.get(rent.size()-1);
				rent.remove(rent.size()-1);
			}
			else break;
		}
		
		for(int i=0; i<profit.length; i++) ans += profit[i];
		out.println(ans);
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		milk = new int[n];
		for(int i=0; i<n; i++) 
			milk[i] = Integer.parseInt(in.readLine());
		Arrays.sort(milk);
		
		stores = new TreeMap<Integer, Integer>();
		for(int i=0; i<m; i++) {
			
			st = new StringTokenizer(in.readLine());
			int maxmilk = Integer.parseInt(st.nextToken());
			int cents = Integer.parseInt(st.nextToken());
			
			if(stores.containsKey(cents)) {
				stores.put(cents, stores.get(cents)+maxmilk);
			}
			else stores.put(cents,maxmilk);
		}
		
		rent = new ArrayList<Integer>();
		for(int i=0; i<r; i++) 
			rent.add(Integer.parseInt(in.readLine()));
		Collections.sort(rent);
		
		profit = new int[n];
	}
	
}