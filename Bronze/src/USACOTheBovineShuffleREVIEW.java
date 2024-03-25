import java.util.*;
import java.io.*;

public class USACOTheBovineShuffleREVIEW {
	
	static Scanner in;
	static PrintWriter out;
	static StringBuilder ans;
	static int n, result[];
	static HashMap<Integer, Integer> shuffle;
	
	public static void main(String[] args) throws IOException {
		
		//in = new Scanner(System.in);
		
		in = new Scanner(new FileReader("shuffle.in"));
		out = new PrintWriter("shuffle.out");
		
		n = in.nextInt();
		shuffle = new HashMap<Integer, Integer>();
		result = new int[n];
		for(int i=0; i<n; i++) shuffle.put(in.nextInt()-1, i);
		for(int i=0; i<n; i++) result[i] = in.nextInt();
		
		
		for(int i=0; i<3; i++) {
			
			int[] before = new int[n];
			
			for(int j=0; j<n; j++) {
				before[shuffle.get(j)] = result[j];
			}
			
			result = before;
		}
		ans = new StringBuilder();
		for(int i=0; i<n; i++) ans.append(result[i]).append("\n");
		
		out.print(ans);
		
		in.close();
		out.close();
		
		
	}
	
	
}
