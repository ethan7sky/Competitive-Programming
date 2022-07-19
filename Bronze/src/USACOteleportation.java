import java.util.*;
import java.io.*;
 
public class USACOteleportation {
	
	static Scanner in;
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new File("teleport.in"));

		PrintWriter out = new PrintWriter("teleport.out");

		int a = in.nextInt();
		int b = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		
		int ans = Math.abs(a-b);
		ans = Math.min(ans,Math.abs(a-x)+Math.abs(y-b));
		ans = Math.min(ans, Math.abs(a-y) + Math.abs(x-b));
		
		
		out.println(ans);
		
		in.close();
		out.close();
	}
}
