import java.util.*;
import java.io.*;

public class CF102951D {
	
	static BufferedReader in;
	static StringTokenizer st;
	static Query[] updates;
	static Query[] queries;
	static ArrayList<Integer> indexes;
	static long[] p;
	static int[] range;
	static int n, q;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		updates = new Query[n];
		queries = new Query[q];
		indexes = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
		}
	}
	
	
	static class Query {
		int l, r, v;
		public Query(int a, int b, int c) {
			this.l = a;
			this.r = b;
			this.v = c;
		}
		public Query(int a, int b) {
			this.l = a;
			this.r = b;
		}
	}
}
