import java.util.*;
import java.io.*;

public class CF404C {
	
	static int N, K;
	static int d[];
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int currNodeCnt;
	static boolean works = true;
	static Queue<Integer> dists[];
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		d = new int[N+1];
		for(int i=1; i<=N; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		dists = new Queue[N]; //idxes
		for(int i=0; i<N; i++) dists[i] = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			dists[d[i]].add(i);
		}
		
		if(dists[0].size() != 1) {
			System.out.println(-1);
			return;
		}
		else {
			int currIdx = dists[0].poll();
			currNodeCnt = 1;
			for(int i=0; i<K && !dists[1].isEmpty(); i++) {
				int nextIdx = dists[1].poll();
				sb.append(currIdx).append(" ").append(nextIdx).append("\n");
				constructDfs(1, nextIdx);
			}
		}
		
		if(currNodeCnt == N) {
			System.out.println(N-1);
			System.out.print(sb);
		} else {
			System.out.println(-1);
		}
	}
	
	static void constructDfs(int depth, int currIdx) {
		currNodeCnt++;
		if(depth+1==N) return;
		for(int i=0; i<K-1 && !dists[depth+1].isEmpty(); i++) {
			int nextIdx = dists[depth+1].poll();
			sb.append(currIdx).append(" ").append(nextIdx).append("\n");
			constructDfs(depth+1, nextIdx);
		}
	}
}
