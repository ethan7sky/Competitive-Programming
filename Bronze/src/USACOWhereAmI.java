import java.util.*;
import java.io.*;

public class USACOWhereAmI {
	
	static Scanner in;
	static PrintWriter out;
	static int n;
	static String s;
	
	public static void main(String[] args) throws IOException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("whereami.in"));
		out = new PrintWriter("whereami.out");
		
		n = in.nextInt();
		s = in.next();
		
		for(int i = 1; i <= n; i++) {
			
			boolean works = true;
			
			for(int a = 0; a+i <= n; a++) {
				for(int b = 0; b+i <= n; b++) {
					if(a!=b && s.substring(a, a+i).equals(s.substring(b, b+i))){
						works = false;
					}
				}
			}
			if(works) {
				out.println(i);
				break;
			}
		}
		
		in.close();
		out.close();
	}
}
