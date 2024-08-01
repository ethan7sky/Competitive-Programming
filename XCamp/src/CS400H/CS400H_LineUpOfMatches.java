package CS400H;
import java.util.*;
import java.io.*;

public class CS400H_LineUpOfMatches {
	
	static int M = (int)1e5+1;
	static int ref[] = new int[M];
	static int n, ans;
	static int a[], b[];
	static ArrayList<Integer> compare; 
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();

		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
		ans=0;
		compare = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			System.out.println(compare+" "+b[i]);
			int idx = Collections.binarySearch(compare, b[i]);
			System.out.println(idx);
			if(idx<0) idx = -idx-1;
			ans += i-idx;
			idx = Collections.binarySearch(compare, a[i]);
			if(idx<0) idx = -idx-1;
			compare.add(idx, a[i]);
			System.out.println("ans = "+ans);
		}
		System.out.println(ans);
		
	}
	
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());
		a = new int[n];
		b = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) b[i] = Integer.parseInt(st.nextToken());

		int[] temp = a.clone();
		Arrays.sort(temp);
		for(int i=n-1; i>=0; i--) {
			ref[temp[i]] = i+1;
		}
		for(int i=0; i<n; i++) {
			a[i] = ref[a[i]];
		}
		
		temp = b.clone();
		Arrays.sort(temp);
		for(int i=n-1; i>=0; i--) {
			ref[temp[i]] = i+1;
		}
		for(int i=0; i<n; i++) {
			b[i] = ref[b[i]];
		}
	}
}
