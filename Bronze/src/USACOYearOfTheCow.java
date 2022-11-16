import java.util.*;
import java.io.*;

public class USACOYearOfTheCow {
	
	static BufferedReader in;
	static StringTokenizer st;
	static HashMap<String, Integer> calendar;
	static int n, cnt, prev, cow1, cow2, next, year;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		
	}
	
	static void solve() throws IOException {
		
		cnt=0; prev = 13;
		for(int i=0; i<n; i++) {
			
			
			
		}
		
	}
	
	static void init() throws IOException {
		
		calendar = new HashMap<String, Integer>();
		calendar.put("Ox", 1);
		calendar.put("Tiger", 2);
		calendar.put("Rabbit", 3);
		calendar.put("Dragon", 4);
		calendar.put("Snake", 5);
		calendar.put("Horse", 6);
		calendar.put("Goat", 7);
		calendar.put("Monkey", 8);
		calendar.put("Rooster", 9);
		calendar.put("Dog", 10);
		calendar.put("Pig", 11);
		calendar.put("Rat", 12);
		
		n = Integer.parseInt(in.readLine());
		
		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(in.readLine());
			
			String cow1 = st.nextToken();
			st.nextToken(); st.nextToken();
			boolean next = st.nextToken().equals("next");
			String year = st.nextToken();
			st.nextToken();
			String cow2 = st.nextToken();
			
			
			
		}
	}
}
