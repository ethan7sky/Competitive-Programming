import java.util.*;
import java.io.*;

public class AssembleTheTeam2 {
	
	static int t;
	static ArrayList<pair> e;
	static pair[] a;
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		t = in.nextInt(); in.nextLine();
		testcases:
		while(t-->0) {
			
			String[] input = in.nextLine().split(" ");
			a = new pair[input.length];
			for(int i=0; i<input.length; i++) {
				a[i] = new pair(input[i].charAt(0), Integer.parseInt(input[i].substring(2)));
			}
			Arrays.sort(a);
			//System.out.println(Arrays.toString(a));
			
			ArrayList<String> combos = new ArrayList<String>();
			int maxlen = 0;
			for(int s=1; s<=90; s++) {
				String ans = "";
				for(pair i: a) {
					if(s<=i.score && i.score<=s+10) ans += i.val;
				}
				//System.out.println(ans);
				maxlen = Math.max(maxlen, ans.length());
				combos.add(ans);
			}
			Collections.sort(combos);
			
			for(String s: combos) {
				if(s.length()==maxlen) {
					StringBuilder ans = new StringBuilder();
					for(int i=0; i<maxlen; i++) {
						ans.append(s.charAt(i)).append(" ");
					}
					
					System.out.println(ans.substring(0,ans.length()-1));
					continue testcases;
				}
			}
		}
	}
	
	static class pair implements Comparable<pair> {
		
		char val;
		int score;
		
		public pair(char a, int b) {
			val = a;
			score = b;
		}
		public String toString() {
			return val+" "+score;
		}
		
		@Override
		public int compareTo(pair that) {
			return this.val-that.val;
		}
	}
	
}
