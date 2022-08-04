import java.util.*; import java.io.*;

public class USACOTeamTicTacToe {
	
	static Scanner in;
	static PrintWriter out;
	static char a[][];
	static String[] index = {"00,10,20","01,11,21","02,12,22",
			"00,01,02","10,11,12","20,21,22","00,11,22","20,11,02"};
	public static void main(String[] args) throws IOException{
		
		a = new char[3][];
		
		in = new Scanner(new FileReader("tttt.in"));
		out = new PrintWriter("tttt.out");
		
		for(int i = 0; i < 3; i++) {
			a[i] = in.next().toCharArray();
			
		}
		
		TreeSet<Character> res1 = new TreeSet<Character>();
		TreeSet<String> res2 = new TreeSet<String>();
		
		for(int i = 0; i < 8; i++) {
			String temp = index[i];
			char x = a[temp.charAt(0)-'0'][temp.charAt(1)-'0'];
			char y = a[temp.charAt(3)-'0'][temp.charAt(4)-'0'];
			char z = a[temp.charAt(6)-'0'][temp.charAt(7)-'0'];
			
			if(x==y&&y==z) res1.add(x);
			
			if(x==y && y!=z || y==z && z!=x || x==z && y!=z) {
				char ans[] = {x,y,z};
				Arrays.sort(ans);
				res2.add(ans[0]+""+ans[2]);
			}
		}
		out.println(res1.size());
		out.println(res2.size());
		
		in.close();
		out.close();
	}
}
