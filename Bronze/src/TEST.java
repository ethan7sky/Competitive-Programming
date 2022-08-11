import java.util.*; import java.io.*;
public class TEST {
	
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n-->0) {
			hs.add(in.nextInt());
		}
		System.out.println(hs);
	}
}
