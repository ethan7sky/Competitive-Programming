import java.util.*;
import java.io.*;

public class _2425ACSLRings {
	
	static HashMap<String, Integer> scoringMap = new HashMap<String, Integer>();
	static String rings[] = {"A","R","O","G","B"};
	static int points[] = {1, 1, 3, 3, 6};
	
	static StringBuilder sb;
	static BufferedReader in;
	static StringTokenizer st;
	
	static int N;
	static ArrayList<Player> ans;
	
	public static void main(String[] args) throws IOException {
		
		initPointsMap();
		initEverything();

		N = Integer.parseInt(in.readLine());
		
		for(int id=1; id<=N; id++) {
			st = new StringTokenizer(in.readLine());
			
			Player curr = new Player(id, 0, 0);
			while(st.hasMoreTokens()) {
				curr.score += scoringMap.get(st.nextToken());
				curr.tossCnt++;
			}
			ans.add(curr);
		}
		
		Collections.sort(ans);
		
		for(int i=0; i<N; i++) {
			sb.append(ans.get(i).id).append("-").append(ans.get(i).score);
			if(i!=N-1) sb.append(" ");
		}
		System.out.println(sb);
		
	}
	
	
	
	static class Player implements Comparable<Player> {
		int id, score, tossCnt;
		public Player(int i, int s, int t) {
			this.id = i;
			this.score = s;
			this.tossCnt = t;
		}
		
		@Override
		public int compareTo(Player that) {
			if(this.score==that.score) {
				return this.tossCnt-that.tossCnt;
			}return that.score-this.score;
		}
	}
	
	static void initPointsMap() {
		for(int i=0; i<5; i++) {
			scoringMap.put(rings[i], points[i]);
			scoringMap.put(rings[i]+"+", points[i]+2);
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				scoringMap.put(rings[i]+rings[j], points[i]+points[j]+1);
				scoringMap.put(rings[i]+rings[j]+"+", points[i]+points[j]+3);
			}
		}
	}
	static void initEverything() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		ans = new ArrayList<Player>();
		sb = new StringBuilder();
	}	
}
