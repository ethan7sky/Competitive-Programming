import java.util.*;
import java.io.*;

public class USACOTeamTicTacToeREVIEW {
	
	static Scanner in;
	static PrintWriter out;
	static char board[][];
	static int index[][][] = { {{0,0},{0,1},{0,2}}, 
			{{1,0},{1,1},{1,2}}, 
			{{2,0},{2,1},{2,2}}, 
			
			{{0,0},{1,0},{2,0}}, 
			{{0,1},{1,1},{2,1}}, 
			{{0,2},{1,2},{2,2}}, 
			
			{{0,0},{1,1},{2,2}}, 
			{{2,0},{1,1},{0,2}}};
	static int cnt1, cnt2;
	
	public static void main(String[] args) throws IOException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("tttt.in"));
		out = new PrintWriter("tttt.out");
		
		board = new char[3][];
		for(int i=0; i<3; i++) board[i] = in.next().toCharArray();
		
		HashSet<Character> cnt1 = new HashSet<Character>();
		HashSet<String> cnt2 = new HashSet<String>();
		
		for(int i=0; i<8; i++) {
			TreeSet<Character> hs = new TreeSet<Character>();
			for(int j=0; j<3; j++) 	hs.add(board[index[i][j][0]][index[i][j][1]]);
			
			if(hs.size()==1) cnt1.add(hs.first());
			else if(hs.size()==2) cnt2.add(hs.first()+""+hs.last());
		}
		

		out.println(cnt1.size());
		out.println(cnt2.size());
		
		in.close();
		out.close();
	}
	
}
