import java.util.*;

public class USACOUdderedButNotHerd {

	static Scanner in;
	static String alphabet, line;
	static HashMap<Character, Integer> index;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		init();
		solve();
	}
	static void init() {
		
		alphabet = in.next();
		
		index = new HashMap<Character, Integer>();
		for(int i=0; i<26; i++) {
			index.put(alphabet.charAt(i), i);
		}
		
		line = in.next();
	}
	static void solve() {
		
		int prev = 27;
		int cnt = 0;
		
		for(int i=0; i<line.length(); i++) {
			if(index.get(line.charAt(i)) <= prev){
				cnt++;
			}
			prev = index.get(line.charAt(i));
		}
		
		System.out.println(cnt);
	}
}
