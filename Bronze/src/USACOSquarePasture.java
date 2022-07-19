import java.util.*;
import java.io.*;

public class USACOSquarePasture {
	static int x1, y1, x2, y2, x3, y3, x4, y4;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader("square.in"));
		out = new PrintWriter("square.out");
		
		x1 = in.nextInt();
		y1 = in.nextInt();
		x2 = in.nextInt();
		y2 = in.nextInt();
		x3 = in.nextInt();
		y3 = in.nextInt();
		x4 = in.nextInt();
		y4 = in.nextInt();
		
		int cornerx1 = Math.min(x1, x3);
		int cornery1 = Math.min(y1, y3);
		int cornerx2 = Math.max(x2, x4);
		int cornery2 = Math.max(y2, y4);
		
		//make square
		if(cornerx2-cornerx1 != cornery2-cornery1){
			if(cornerx2-cornerx1 < cornery2-cornery1){
				cornerx2 += (cornery2-cornery1) - (cornerx2-cornerx1);
			}
			else if(cornerx2-cornerx1 > cornery2-cornery1){
				cornery2 += (cornerx2-cornerx1) - (cornery2-cornery1);
			}
		}
		
		int ans = (cornerx2-cornerx1) * (cornery2-cornery1);
		
		out.println(ans);
		
		in.close();
		out.close();
		
	}
}

/*
1  6  8  9
x1 y1 x2 y2
*/