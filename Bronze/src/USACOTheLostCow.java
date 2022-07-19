import java.util.*;
import java.io.*;

public class USACOTheLostCow {

	static long init, x, y, res;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new FileReader("lostcow.in"));
		out = new PrintWriter("lostcow.out");
		
		x = in.nextLong();
		y = in.nextLong();
		init = x;
		
		int max = 1;
		boolean add = true;
		while(x != y) {
			if(add) {
				x += 1;
				if(x == init+max) {
					add = false;
					max *= -2;
				}
			}
			else {
				x -= 1;
				if(x == init+max) {
					add = true;
					max *= -2;
				}
			}
			res++;
		}
		
		out.println(res);
		
		in.close();
		out.close();
	}
}
