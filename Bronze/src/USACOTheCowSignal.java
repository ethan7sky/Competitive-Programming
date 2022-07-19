import java.util.*;
import java.io.*;

public class USACOTheCowSignal {
	
	static Scanner in;
	static StringBuilder sb;
	static PrintWriter out;
	static int m, n, k;
	
	public static void main(String[] args) throws IOException {
		
		sb = new StringBuilder();
		in = new Scanner(new FileReader(new File("cowsignal.in")));
		out = new PrintWriter(new File("cowsignal.out"));
		//in = new Scanner(System.in);
		
		
		
		int m = in.nextInt();
		int n = in.nextInt();
		int k = in.nextInt();
		in.nextLine();
		
		
		for(int i = 0; i < m; i++) {
			String temp = in.nextLine();
			for(int p = 0; p < k; p++) {
				for(int j = 0; j < n; j++) {
					char c = temp.charAt(j);
					for(int u = 0; u < k; u++) {
						sb.append(c);
					}
				}sb.append("\n");
			}
		}
		
		out.println(sb.toString().substring(0,sb.length()-1));
		
		in.close();
		out.close();
		
	}
	
	
}
