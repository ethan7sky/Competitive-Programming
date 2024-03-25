import java.util.*;
import java.io.*;

public class Playlist {
	
	static int n, ans;
	static HashMap<Integer, Integer> lastseen;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		
		lastseen = new HashMap<Integer, Integer>();
		int len = 0;
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(!lastseen.containsKey(x)) {
				len++;
			}
			else {
				if(lastseen.get(x) >= i-len) {
					len = i-lastseen.get(x);
				} else len++;
			}
			ans = Math.max(len, ans);
			lastseen.put(x, i);
			
			//System.out.println(len+" "+lastseen);
		}
		System.out.println(ans);
	}
	
}
