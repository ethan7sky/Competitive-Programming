import java.util.*;
import java.io.*;

public class USACOMilkMeasurement_silver {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static triple a[];
	static int N, G, boardcnt, boardmilk, max, maxcnt, ans;
	static TreeMap<Integer, Integer> milk;
	static HashMap<Integer, Integer> cows;
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new FileReader("measurement.in"));
		out = new PrintWriter(new FileWriter("measurement.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		
		a = new triple[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = new triple(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(a);
		
		
		milk = new TreeMap<Integer, Integer>();
		milk.put(G, 1000000000);
		
		cows = new HashMap<Integer, Integer>();
		
		boardcnt = 1000000000;
		boardmilk = G;
		max = G;
		
	}
	
	static void solve() {
		
		for(triple t: a) {
			
			int curId = t.id;
			
			if(!cows.containsKey(curId)) {
				cows.put(curId, G);
			}
			
			int curMilk = cows.get(curId);
			
			milk.put(curMilk, milk.get(curMilk)-1);
			if(milk.get(curMilk)==0) milk.remove(curMilk);
			
			if(curMilk == max) boardmilk += t.milk;
			curMilk += t.milk;
			
			cows.put(curId, curMilk);
			
			if(milk.containsKey(curMilk)) {
				milk.put(curMilk, milk.get(curMilk)+1);
			}
			else {
				milk.put(curMilk, 1);
			}
			
			max = milk.lastKey();
			maxcnt = milk.get(max);
			
			if(max!=boardmilk || maxcnt != boardcnt) {
				ans++;
				boardmilk = max;
				boardcnt = maxcnt;
			}
		}
		out.println(ans);
	}
	
	static class triple implements Comparable<triple> {
		
		int date, id, milk;
		triple(int a, int b, int c){
			date = a;
			id = b;
			milk = c;
		}
		
		public String toString() {
			return date+" "+id+" "+milk;
		}
		@Override
		public int compareTo(USACOMilkMeasurement_silver.triple o) {
			// TODO Auto-generated method stub
			return this.date-o.date;
		}
		
	}
}