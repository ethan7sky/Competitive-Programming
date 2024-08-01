import java.util.*;
import java.io.*;
public class CF104114N2 {
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m;
	static int[] a;
	static StringBuilder ans;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
		for(int i=1; i<n; i++) a[i] = Math.max(a[i], a[i-1]-m);
		for(int i=n-2; i>=0; i--) a[i] = Math.max(a[i], a[i+1]-m);
		ans = new StringBuilder();
		for(int i=0; i<n; i++) {
			ans.append(a[i]);
			if(i!=n-1)ans.append(" ");
		}System.out.println(ans);
	}
}
