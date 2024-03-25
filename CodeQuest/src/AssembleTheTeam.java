import java.util.*;
import java.io.*;

public class AssembleTheTeam {
	
	static int t;
	static ArrayList<pair> e;
	static pair[] a;
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		t = in.nextInt(); in.nextLine();
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(in.nextLine());
			e = new ArrayList<pair>();
			while(st.hasMoreTokens()) {
				String s[] = st.nextToken().split("=");
				e.add(new pair(s[0].charAt(0), Integer.parseInt(s[1])));
			}
			a = new pair[e.size()];
			int idx=0;
			for(pair i: e) {
				a[idx] = e.get(idx);
				idx++;
			}
			Arrays.sort(a);
			
			//two pointer
			
			int ans = 0;
			int startidx=0;
			for(int i=0; i<a.length; i++) {
				while(a[i].score - a[startidx].score > 10) {
					startidx++;
				}
				ans = Math.max(ans, i-startidx+1);
			}
			ArrayList<Character> res = new ArrayList<Character>();
			ArrayList<String> combinations = new ArrayList<String>();
			startidx=0;
			for(int i=0; i<a.length; i++) {
				while(a[i].score - a[startidx].score > 10) {
					startidx++;
					res.remove(0);
				}
				res.add(a[i].val);
				if(res.size()==ans) {
					ArrayList<Character> one = new ArrayList<Character>();
					one.addAll(res);
					Collections.sort(one);
					String s = "";
					for(char c: one) {
						s+=c;
					}
					combinations.add(s);
				}
			}
			Collections.sort(combinations);
			StringBuilder sb = new StringBuilder();
			String answer = combinations.get(0);
			for(int i=0; i<answer.length(); i++) {
				sb.append(answer.charAt(i)).append(" ");
			}
			System.out.println(sb);
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
			if(this.score == that.score) return this.val-that.val;
			return this.score-that.score;
		}
	}
	
}
