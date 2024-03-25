import java.util.*;
import java.io.*;

public class SubarraySumsI {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int a[] = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int s=0, e=0;
		int sum = a[0];
		int cnt=0;
		if(sum==x) cnt++;
		while(e<n) {
			if(e+1==n) {
				if(sum<x) break;
				else {
					sum -= a[s];
					s++;
				}
			}
			else if(sum+a[e+1]<=x) {
				e++;
				sum += a[e];
			}
			else {
				sum -= a[s];
				s++;
			}
			if(sum==x) cnt++;
		}
		System.out.println(cnt);
		
	}
}
