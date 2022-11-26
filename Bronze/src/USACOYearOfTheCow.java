import java.util.*;
import java.io.*;

public class USACOYearOfTheCow {

	static Scanner in;
	static int n;
	static String[] ani = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
	static HashMap<String, Integer> zodiac;
	static HashMap<String, pair> cow;
	
	static class pair{
		int idx;
		String animal;
		
		pair(int i, String a){
			idx = i;
			animal = a;
		}
		
		public String toString() {
			return idx +" "+animal;
		}
	}
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(System.in);
		init();
		in.close();
	}

	static void init() throws IOException {
		
		n = in.nextInt(); in.nextLine();
		
		zodiac = new HashMap<String, Integer>();
	
		for(int i=0; i<12; i++) zodiac.put(ani[i], i);
		
		cow = new HashMap<String, pair>();
		cow.put("Bessie", new pair(0, "Ox"));
		
		
		for(int i=0; i<n; i++) solve();
		
		System.out.println(Math.abs(cow.get("Elsie").idx));
	}
	
	static void solve() {
		
		String s[] = in.nextLine().split(" ");
		
		String to = s[0];
		String from = s[7];
		String status = s[3];
		String toAni = s[4];
		String fromAni = cow.get(from).animal;
		
		int d = 0;
		
		if(status.equals("previous")) {
			
			if(zodiac.get(toAni) < zodiac.get(fromAni))
				d = zodiac.get(fromAni) - zodiac.get(toAni);
			else d = (zodiac.get(fromAni) - zodiac.get(toAni)) + 12;
		}
		else {
			if(zodiac.get(fromAni) < zodiac.get(toAni))
				d = zodiac.get(fromAni) - zodiac.get(toAni);
			else d = (zodiac.get(fromAni) - zodiac.get(toAni)) - 12;
		}
		
		int idx = cow.get(from).idx + d;
		
		cow.put(to, new pair(idx,toAni));
		//System.out.println(cow);
	}	
}