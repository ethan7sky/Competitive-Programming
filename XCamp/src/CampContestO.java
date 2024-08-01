import java.util.*;
import java.io.*;

public class CampContestO {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		System.out.println(s.substring(0, 1).toUpperCase()+s.substring(1));
	}
}
