import java.util.*;
import java.io.*;

public class CF540087A {
	
	static int t, n, a[];
	static long ans;
	static ArrayList<Integer> vals;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		while(t-->0){
			n = Integer.parseInt(in.readLine());
			a = new int[n];
			vals = new ArrayList<Integer>();
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			ans=0;
			for(int i=0; i<n; i++) {
				int idx = Collections.binarySearch(vals, a[i]-1);
				if(idx<0) idx = -idx-1;
				ans += vals.size()-idx;
				idx = Collections.binarySearch(vals, a[i]);
				if(idx<0) idx = -idx-1;
				vals.add(idx, a[i]);
				System.out.println(i+" "+ans);
				System.out.println(idx+" "+vals);
			}
			System.out.println(ans);
		}
	}
}
