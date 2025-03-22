import java.io.*;
import java.util.*;

public class baekjoon1912 {
	
	static int N;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int MAX_N = 100000;
	static int[] a = new int[MAX_N];
	
	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		a = new int[N];
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int ans = calcMaxSubarraySum(a);
		if(ans==0) {
			ans = -Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				ans = Math.max(ans, a[i]);
			}
		}
		System.out.println(ans);
	}
	
	static int calcMaxSubarraySum(int[] arr) {
		int bestSum = 0;
		int currSum = 0;
		for(int i=0; i<arr.length; i++) {
			currSum = Math.max(0, currSum+arr[i]);
			bestSum = Math.max(bestSum, currSum);
		}
		return bestSum;
	}
}
