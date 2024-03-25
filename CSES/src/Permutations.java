import java.util.*;
import java.io.*;

public class Permutations {
	
	static int n;
	static StringBuilder sb;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		if(n==1) {System.out.println("1"); return;}
		if(n<4) {
			System.out.println("NO SOLUTION");
			return;
		}
		sb = new StringBuilder();
		for(int i=2; i<=n; i+=2) sb.append(i).append(" ");
		for(int i=1; i<=n; i+=2) sb.append(i).append(" ");
		
		System.out.println(sb.toString().toString().substring(0,sb.length()-1));
	}
	
}