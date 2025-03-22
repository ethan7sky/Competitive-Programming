import java.util.*;
import java.io.*;

public class USACOMooBuzz {
	
	static int N;
	static Scanner in;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(System.in);
		N = in.nextInt();
		long low=1, high=(long)1e10, mid = (low+high)/2;
		
		long ans=0;
		while(low<=high) {
			mid = (low+high)/2;
			
			long cnt = mid - mid/3L - mid/5L + mid/15L;
			if(cnt>=N) {
				ans = mid;
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		
		while(ans%3==0||ans%5==0) ans++;
		
		System.out.println(ans);
	}
}
