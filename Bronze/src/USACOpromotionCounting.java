import java.util.*;
import java.io.*;
 
public class USACOpromotionCounting {
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(new FileReader("promote.in"));
		FileWriter fw = new FileWriter("promote.out");
		
		in.nextInt();
		in.nextInt();
		int s1 = in.nextInt();
		int s2 = in.nextInt();
		int g1 = in.nextInt();
		int g2 = in.nextInt();
		int p1 = in.nextInt();
		int p2 = in.nextInt();
		
		int print1 = 0;
		int print2 = 0;
		int print3 = 0;
		
		
		print1 += s2-s1;
		
		print1 += (g2-g1);
		print2 += (g2-g1);
		
		print1 += (p2-p1);
		print2 += (p2-p1);
		print3 += (p2-p1);
		
		fw.write(print1+"\n");
		fw.write(print2+"\n");
		fw.write(print3+"\n");
		
		in.close();
		fw.close();
		
		
		
	}
}
