import java.util.*;
import java.io.*;

public class RestaurantCustomers {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		customers a[] = new customers[n*2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			a[i] = new customers(Integer.parseInt(st.nextToken()), true);
			a[i+n] = new customers(Integer.parseInt(st.nextToken()), false);
		}
		Arrays.sort(a);
		
		int max=0;
		int cnt = 0;
		for(int i=0; i < n*2; i++) {
			if(a[i].arrival) cnt++;
			else cnt--;
			max = Math.max(cnt, max);
		}
		System.out.println(max);
		
	}
	
	static class customers implements Comparable<customers> {

		int t;
		boolean arrival;
		customers(int a, boolean b){
			t = a;
			arrival = b;
		}
		
		public String toString() {
			return t+"";
		}
		
		@Override
		public int compareTo(RestaurantCustomers.customers o) {
			// TODO Auto-generated method stub
			return this.t-o.t;
		}
	}
	
}
