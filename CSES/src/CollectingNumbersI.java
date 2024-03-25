import java.util.*;
import java.io.*;
 
public class CollectingNumbersI {
 
	static int n, a[];
	static HashMap<Integer, Integer> idx;
	static BufferedReader in;
	static StringTokenizer st;
 
	public static void main(String[] args) throws IOException {
 
		in = new BufferedReader(new InputStreamReader(System.in));
 
		n = Integer.parseInt(in.readLine());
 
		st = new StringTokenizer(in.readLine());
		idx = new HashMap<Integer, Integer>();
		a = new int[n];
 
		for(int i=0; i<n; i++){
			a[i] = Integer.parseInt(st.nextToken());
			idx.put(a[i], i);
		}
		idx.put(0, -1);
 
		int ans = 1;
		for(int i=0; i<n; i++){
			if(idx.get(a[i]-1)>i){
				ans++;
			}
		}
		System.out.println(ans);
	}	
}
