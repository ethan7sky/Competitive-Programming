import java.util.*;
import java.io.*;

public class BSimpleArrays {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int sum=0;
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			sum += a[i];
		}
		
		Arrays.sort(a);
		
		if(sum%2==1) {
			System.out.println("NO");
			return;
		}
		
		else {
			int half = sum/2;
			int total = 0;
			int lastIdx=n-1;
			for(int i=n-1; i>=0; i--) {
				if(total+a[i]>half) break;
				total += a[i];
				lastIdx = i;
			}
			
			if(total == half-1) {
				for(int i=lastIdx-1; i>=0; i--) {
					if(a[i]==1) {
						total++;
						break;
					}
				}
			}
			
			if(total==half) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
}
