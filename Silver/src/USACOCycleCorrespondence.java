import java.util.*;
import java.io.*;

public class USACOCycleCorrespondence {
	
	static HashMap<Integer, Integer> a;
	static int[] b;
	static HashSet<Integer> vals;
	static BufferedReader in;
	static StringTokenizer st;
	static int n, k;
	static int ans=0;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new HashMap<Integer, Integer>();
		b = new int[k];
		vals = new HashSet<Integer>();
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<k; i++) {
			int x = Integer.parseInt(st.nextToken());
			a.put(x, i);
			vals.add(x);
		}
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<k; i++) {
			int x = Integer.parseInt(st.nextToken());
			b[i] = x;
			vals.add(x);
		}
		
		ans += n-vals.size();
		
		int[] distances = new int[k];
		for(int i=0; i<k; i++) {
			
			if(!a.containsKey(b[i])) continue;
			int dist = i-(a.get(b[i]));
			if(dist<0) dist += k;
			distances[dist]++;
		}
		
		int[] distances1 = new int[k];
		reverse();
		for(int i=0; i<k; i++) {
			
			if(!a.containsKey(b[i])) continue;
			int dist = i-(a.get(b[i]));
			if(dist<0) dist += k;
			distances1[dist]++;
		}
		
		int max = 0;
		for(int i=0; i<k; i++) {
			max = Math.max(max, distances[i]);
			max = Math.max(max, distances1[i]);
		}
		System.out.println(ans+max);
		
		
	}
	static void reverse() {
		for(int i=0; i<k/2; i++) {
			int temp = b[k-i-1];
			b[k-i-1] = b[i];
			b[i] = temp;
		}
	}
}
