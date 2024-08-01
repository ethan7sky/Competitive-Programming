import java.util.*;
import java.io.*;

public class USACOSleepyCowHerding {
	
	static int n, a[], d[];
	static long min, max;
	static BufferedReader in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("herding.in"));
		out = new PrintWriter("herding.out");
		
		n = Integer.parseInt(in.readLine());
		
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(in.readLine());
		Arrays.sort(a);
		
		//calc min
		min = n;
		
		for(int i=0; i<n; i++) {
			int leftBound = a[i]-n+1;
			int leftBoundIdx = Arrays.binarySearch(a, leftBound);
			if(leftBoundIdx>=0) min = Math.min(min,  n-(i-leftBoundIdx+1));
			else {
				int newLeftBoundIdx = -leftBoundIdx-1;
				int cnt = i-newLeftBoundIdx+1;
				if(cnt==n-1) min = Math.min(min, 2);
				else min = Math.min(min, n-cnt);
			}
			
//			System.out.println("a["+i+"] = "+a[i]);
//			System.out.println("leftidx = "+leftBoundIdx);
			
			int rightBound = a[i]+n-1;
			int rightBoundIdx = Arrays.binarySearch(a, rightBound);
			if(rightBoundIdx>=0) min = Math.min(min, n-(rightBoundIdx-i+1));
			else {
				int newRightBoundIdx = -rightBoundIdx-1;
				int cnt = newRightBoundIdx-i;
				if(cnt==n-1) min = Math.min(min, 2);
				else min = Math.min(min, n-cnt);
			}

//			System.out.println("rightidx = "+rightBoundIdx);
//			System.out.println(min);
		}
		
		out.println(min);
		
		//calcmax
		long sum = 0;
		long[] diff = new long[n-1];
		for(int i=0; i<n-1; i++) {
			diff[i]=a[i+1]-a[i]-1;
			sum += diff[i];
		}

//		System.out.println(Arrays.toString(diff));

		max = Math.max(sum-diff[0], sum-diff[n-2]);
		out.println(max);
		
		in.close();
		out.close();
	}
	
}
