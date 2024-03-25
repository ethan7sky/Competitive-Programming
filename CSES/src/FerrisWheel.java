import java.util.*;
import java.io.*;

public class FerrisWheel {
	
	static int n, x;
	static ArrayList<Integer> a;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		a = new ArrayList<Integer>();
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a.add(Integer.parseInt(st.nextToken()));
		Collections.sort(a);
		
		int ans = 0;
		int low = 0;
		int high = n-1;
		
		while(low<=high) {
			if(a.get(low)+a.get(high)<=x) {
				ans++;
				low++;
				high--;
			}
			else {
				high--;
				ans++;
			}
		}
		System.out.println(ans);
	}
}
