import java.util.*;
import java.io.*;

public class Apartments {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, k, ans;
	static ArrayList<Integer> a, s;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new ArrayList<Integer>();
		s = new ArrayList<Integer>();
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<m; i++) s.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(a);
		Collections.sort(s);
		

		ans=0;
		int idx=0;
		for(int i=0; i<n; i++) {
			if(idx>=m) break;
			if(Math.abs(a.get(i)-s.get(idx))<=k) {
				ans++;
				idx++;
				continue;
			}
			if(s.get(idx)<a.get(i)) {
				if(idx==m-1) {
					System.out.println(ans);
					return;
				}
				idx++;
				i--;
			}
		}
		System.out.println(ans);
	}
}
