import java.util.*;
import java.io.*;

public class USACORobotInstructions {
	
	static int n, tx, ty;
	static BufferedReader in;
	static StringTokenizer st;
	static int[][] instructions;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		tx = Integer.parseInt(st.nextToken());
		ty = Integer.parseInt(st.nextToken());
		
		instructions = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			instructions[i][0] = Integer.parseInt(st.nextToken());
			instructions[i][1] = Integer.parseInt(st.nextToken());
		}
		HashMap<String, Integer> firsthalf = new HashMap<String, Integer>();
		findPermutation(true, 0, n/2, 0, 0);
		HashMap<String, Integer> secondhalf = new HashMap<String, Integer>();
		findPermutation(false, n/2, n, 0, 0);
	}
	static void findPermutation(boolean firsthalf, int idx, int goal, int x, int y) {
		if(idx==goal) {
			
		}
	}
	
}
