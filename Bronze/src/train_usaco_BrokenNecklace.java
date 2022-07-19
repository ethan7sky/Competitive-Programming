import java.util.*; import java.io.*;
public class train_usaco_BrokenNecklace {
	
	static Scanner in;
	static PrintWriter out;
	static int N;
	static String s;
	
	public static void main(String[] args) {
		
		
		in = new Scanner(System.in);
		
		N = in.nextInt();
		in.nextLine();
		
		s = in.nextLine(); s += s;
		
		int ans = -1;
		for(int i = 1; i < s.length(); i++) {
			
			int index = i-1;
			
			int bead = s.charAt(i-1);
			int left = 0;
			//left
			while(true && index >= 0) {
				char curr = s.charAt(i);
				
				if(curr == bead){ left++; }
				else if(curr == 'w') { left++; }
				else if(bead=='w' && curr != 'w') { bead = curr; left++; }
				if(curr != bead && curr != 'w') {
					break;
				}
				index--;

			}
			
			index = i;
			bead = s.charAt(i);
			int right = 0;
			//right
			while(true && index <=N+i) {
				char curr = s.charAt(i);
				
				if(curr == bead){ right++; }
				else if(curr == 'w') { right++; }
				else if(bead=='w' && curr != 'w') { bead = curr; right++; }
				if(curr != bead && curr != 'w') {
					break;
				}
				index++;

			}
			
			ans = Math.max(ans, right+left);
		}
		
		System.out.println(ans);
	}
}
