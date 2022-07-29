import java.util.*;
import java.io.*;

public class USACOMilkPails {
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new FileReader("pails.in"));
		out = new PrintWriter("pails.out");
		int[] x = new int[3];
		for(int i = 0; i < 3; i++) {
			x[i] = in.nextInt();
		}
		
		int max = 0;
		
		for(int i = 0; i <=Math.ceil(x[2]/x[0]); i++) {
			int temp = (int) (x[0]*i + (x[2]-x[0]*i)/x[1]*x[1]);
			if(temp > max) {
				max = temp;
			}
		}
		out.println(max);
		
		in.close();
		out.close();
	}
}
