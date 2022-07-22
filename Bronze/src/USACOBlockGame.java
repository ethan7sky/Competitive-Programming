import java.util.*;
import java.io.*;

public class USACOBlockGame {
	static Scanner in;
	static PrintWriter out;
	static int n, a[], b[], c[];
	static String w1, w2;
	
	public static void main(String[] args) throws IOException{
		
		init();
		
		for(int i = 0; i < 26; i++) {
			out.println(c[i]);
		}
		
		in.close();
		out.close();
		
	}
	
	static void init() throws IOException{
		
		in = new Scanner(new FileReader("blocks.in"));
		out = new PrintWriter("blocks.out");
		
		n = in.nextInt();
		c = new int[26];
		
		for(int i = 0; i < n; i++) {
			solve();
		}
	}
	
	static void solve() {
		
		a = new int[26];
		b = new int[26];
		
		w1 = in.next();
		w2 = in.next();
		
		for(int i = 0; i < w1.length(); i++) {
			a[w1.charAt(i)-'a']++;
		}
		for(int i = 0; i < w2.length(); i++) {
			b[w2.charAt(i)-'a']++;
		}
		
		for(int i = 0; i < 26; i++) {
			c[i] += Math.max(a[i],  b[i]);
		}
		
	}
}
