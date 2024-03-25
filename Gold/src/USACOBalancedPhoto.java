import java.util.*;
import java.io.*;

public class USACOBalancedPhoto {
	
	static BufferedReader in;
	static PrintWriter out;
	static int n, bit[], cnt;
	static pair a[];
	
	public static void main(String[] args) throws IOException{
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("bphoto.in"));
		out = new PrintWriter("bphoto.out");
		
		n = Integer.parseInt(in.readLine());
		a = new pair[n];
		for(int i=0; i<n; i++) a[i] = new pair(Integer.parseInt(in.readLine()), i+1);
		Arrays.sort(a);
		
		bit = new int[n+1];
		
		for(int i=0; i<n; i++) {
			
			int idx = a[i].idx;
			
			int l=sum(idx);
			int r=i-l;
			
			if(2*Math.min(l, r)<Math.max(l, r)) cnt++;
			
			update(idx);
		}
		out.println(cnt);
		
		in.close();
		out.close();
	}
	
	static int sum(int i) {
		int ans=0;
		while(i!=0) {
			ans += bit[i];
			i -= i&-i;
		}
		return ans;
	}
	
	static void update(int i) {
		while(i<n) {
			bit[i]++;
			i += i&-i;
		}
	}
	
	static class pair implements Comparable<pair> {
		
		int h, idx;
		pair(int a, int b){
			h = a;
			idx = b;
		}
		
		public String toString() {
			return h+" "+idx;
		}

		@Override
		public int compareTo(USACOBalancedPhoto.pair o) {
			// TODO Auto-generated method stub
			return o.h-this.h;
		}
	}
	
}