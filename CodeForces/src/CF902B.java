import java.util.*;
import java.io.*;

public class CF902B {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, cnt, tree[], colors[];
	static ArrayList<Integer>[] a;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
	}
	static void init() throws IOException {
	
		n = Integer.parseInt(in.readLine());
		
		a = new ArrayList[n];
		for(int i=0; i<n; i++) a[i] = new ArrayList<Integer>();
		
		st = new StringTokenizer(in.readLine());
		for(int i=2; i<=n; i++){
			a[Integer.parseInt(st.nextToken())-1].add(i);
		}
		tree = new int[n];
		colors = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			tree[i] = i;
			colors[i] = Integer.parseInt(st.nextToken());
		}
		cnt=0;
	}
	static void solve() {
	
		for(int i=0; i<n; i++){
			
			if(tree[i] != colors[i]) {
				color(i, i);
				cnt++;
			}
		
		
		}
		System.out.println(cnt);
	}
	static void color(int i, int c){
		
		if(tree[i] == c) return;
		tree[i] = c;
		for(int n: a[i]) {
			color(n, c);
		}
	}
}