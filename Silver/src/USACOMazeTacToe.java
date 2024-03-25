import java.util.*;
import java.io.*;

public class USACOMazeTacToe {
	
	static int n;
	static int ans;
	static int startX, startY;
	static pair bessie;
	static int nodeCnt=1;
	static pair[][] grid;
	static boolean[][] v;
	static Scanner in;
	static HashMap<pair, ArrayList<pair>> edges;
	static HashSet<ArrayList<pair>> permutations;
	
	static int[] cX = new int[] {0, 0, -1, 1};
	static int[] cY = new int[] {1, -1, 0, 0};
	
	public static void main(String[] args) {
		
		 in = new Scanner(System.in);
		 
		 n = in.nextInt();
		 grid = new pair[n][n];
		 edges = new HashMap<pair, ArrayList<pair>>();
		 v = new boolean[n][n];
		 
		 for(int i=0; i<n; i++) {
			 String line = in.next();
			 for(int j=0; j<n; j++) {
				 String curr = line.substring(j*3,j*3+3);
				 if(curr.equals("...")) grid[i][j]=null;
				 else if(curr.equals("###")) {
					 v[i][j] = true;
					 grid[i][j] = new pair('X',-1,-1);
				 }
				 else if(curr.equals("BBB")) {
					 grid[i][j] = null;
					 startX = i;
					 startY = j;
					 bessie = new pair('B',i,j);
					 edges.put(bessie, new ArrayList<pair>());
				 }
				 else {
					 grid[i][j] = new pair(curr.charAt(0),
							 curr.charAt(1)-'0',
							 curr.charAt(2)-'0');
					 nodeCnt++;
					 edges.put(grid[i][j], new ArrayList<pair>());
				 }
			 }
		 }
		 
		 floodFill(startX, startY, bessie);
		 
		 
		 permutations = new HashSet<ArrayList<pair>>();
		 findPermutations(new ArrayList<pair>(), bessie);
		 
		 ans = 0;
		 for(ArrayList<pair> i: permutations) {
			 if(works(i)) ans++;
		 }
		 System.out.println(ans);
		 
	}
	
	static String[] index = {"00,10,20","01,11,21","02,12,22",
			"00,01,02","10,11,12","20,21,22","00,11,22","20,11,02"};
	
	static boolean works(ArrayList<pair> i) {
		char[][] ttt = new char[3][3];
		
		for(pair j: i) {
			if(j.c=='B') continue;
			ttt[j.x-1][j.y-1] = j.c;
		}
		System.out.println(i);
		for(int a=0; a<3; a++) {
			for(int j=0; j<3; j++) {
				System.out.print(ttt[a][j]);
			}System.out.println();
		}System.out.println();
		boolean works = false;
		for(int j = 0; j < 8; j++) {
			String temp = index[j];
			char x = ttt[temp.charAt(0)-'0'][temp.charAt(1)-'0'];
			char y = ttt[temp.charAt(3)-'0'][temp.charAt(4)-'0'];
			char z = ttt[temp.charAt(6)-'0'][temp.charAt(7)-'0'];
			String res = x+""+y+""+z;
			if(res.equals("OOM")||res.equals("MOO")) {
				works = true;
			}
		}
		return works;
	}
	
	
	
	static void findPermutations(ArrayList<pair> seq, pair currPos) {
		seq.add(currPos);
		permutations.add(seq);
		for(pair i: edges.get(currPos)) {
			ArrayList<pair> seq2 = (ArrayList<pair>) seq.clone();
			findPermutations(seq2, i);
		}
	}
	
	
	static void floodFill(int x, int y, pair prev) {
		if(x<0||y<0||x>=n||y>=n) return;
		if(v[x][y]) return;
		
		if(grid[x][y]!=null) {
			edges.get(prev).add(grid[x][y]);
			prev = grid[x][y];
		}	
		v[x][y] = true;
		for(int dir=0; dir<4; dir++) {
			int newX = x+cX[dir];
			int newY = y+cY[dir];
			floodFill(newX, newY, prev);
		}
	}
	static class pair {
		
		char c;
		int x, y;
		public pair(char letter, int xVal, int yVal) {
			this.c = letter;
			this.x = xVal;
			this.y = yVal;
		}
		public String toString() {
			return Character.toString(c)+x+y;
		}
		
	}
}
