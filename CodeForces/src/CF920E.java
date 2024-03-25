import java.util.*;
import java.io.*;

public class CF920E {
	
	static int n, m;
	static boolean[] v;
	static ArrayList<Integer> sizes;
	static HashSet<edges> exclude;
	static HashSet<Integer> edgesLeft;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		exclude = new HashSet<edges>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			exclude.add(new edges(x, y));
			exclude.add(new edges(y, x));
		}
		edgesLeft = new HashSet<Integer>();
		for(int i=1; i<=n; i++) edgesLeft.add(i);
		sizes = new ArrayList<Integer>();
		for(int i=1; i<=n; i++) {
			if(edgesLeft.contains(i)) {
				sizes.add(dfs(i));
			}
		}
		System.out.println(sizes.size());
		Collections.sort(sizes);
		StringBuilder sb = new StringBuilder();
		for(int i: sizes) sb.append(i).append(" ");
		String ans = sb.toString();
		System.out.println(ans.substring(0,ans.length()-1));
		
	}
	static int dfs(int node) {
		edgesLeft.remove(node);
		Iterator nodeItr = edgesLeft.iterator();
		int cnt = 1;
		while(nodeItr.hasNext()) {
			int i = (int)nodeItr.next();
			if(!exclude.contains(new edges(node, i))) {
				cnt += dfs(i);
			}
		}
		return cnt;
	}
	static class edges {
		int to, from;
		private int hashCode;
		
		public edges(int a, int b) {
			to = a;
			from = b;
			this.hashCode = Objects.hash(a, b);
		}
		public String toString() {
			return to+" "+from;
		}
		
		@Override
		public boolean equals(Object o) {
			if(this==o) return true;
			if (o==null || getClass() != o.getClass()) return false;
			edges that = (edges) o;
			return this.to == that.to && this.from == that.from;
			
		}
		
		@Override
		public int hashCode() {
			return this.hashCode;
		}
	}
	
}
