import java.util.*;
import java.io.*;

public class USACOShellGame {
	
	static Scanner in;
	static PrintWriter out;
	static int n, data[][], max;
	static boolean[] shell;
	
	public static void main(String[] args) throws IOException{
		
		in = new Scanner(new FileReader("shell.in"));
		out = new PrintWriter("shell.out");
		
		init();
		solve();
		in.close();
		out.close();
		
		
	}
	static void init() {

		n = in.nextInt();
		data = new int[n][];
		for(int i = 0; i < n; i++) {
			data[i] = new int[] {in.nextInt()-1, in.nextInt()-1, in.nextInt()-1};
		}
		
		max = Integer.MIN_VALUE;
		
	}
	static void solve() {
				
		for(int i = 0; i < 3; i++) {
			shell = new boolean[3];
			shell[i] = true;
			
			max = Math.max(max,  game());
		}
		
		out.println(max);
	}
	static int game() {
		
		int score = 0;
		
		for(int i = 0; i < n; i++) {
			
			int idx1 = data[i][0];
			int idx2 = data[i][1];
			
			//swap
			boolean temp =  shell[idx1];
			shell[idx1] = shell[idx2];
			shell[idx2] = temp;
			
			//guess (score++)
			if(shell[data[i][2]]) {
				score++;
			}
		}
		return score;
	}
}
