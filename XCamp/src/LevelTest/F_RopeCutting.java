package LevelTest;
import java.util.*;
import java.io.*;

public class F_RopeCutting {
	
	static int n, k;
	static double[] ropes;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		ropes = new double[n];
		for(int i=0; i<n; i++) {
			ropes[i] = Double.parseDouble(st.nextToken());
		}
		
		int low = 1;
		int high = 100000000;
		int ans=0;
		while(low <= high) {
			int mid = (low+high)/2;
			if(check(mid/1000.0)) {
				ans = mid;
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		System.out.println(String.format("%.2f",Math.floor(ans/10.0)/100.0));
	}
	static boolean check(double len) {
		int cnt=0;
		for(double i: ropes) {
			cnt += (int)(i/len);
		}
		return cnt>=k;
	}
}
