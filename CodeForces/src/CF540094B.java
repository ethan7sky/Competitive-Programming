import java.util.*;
import java.io.*;

public class CF540094B {
	
	static long min, max;
	static double mid, ans;
	static int[] pos;
	static int idx;
	static int t, n, d;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			pos = new int[n];
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<n; i++) pos[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(pos);
			
			min = 1;
			max = (long)1e17;
			while(min < max) {
				mid = (min+max)/2/1e7;
				if(calc(mid)) {
					max = (long)(mid*1e7)-1;
					ans = mid;
					//System.out.println(mid);
				}
				else {
					min = (long)(mid*1e7)+1;
					//System.out.println(mid);
				}
//				System.out.println("here");
			}
			
//			System.out.println(Arrays.toString(pos));
//			
//			
			//System.out.println(calc(0.4));
			System.out.println(ans);
		}
		
	}
	static boolean calc(double time) {
		int currIdx = 0;
		while(true) {
//			System.out.println(currIdx);
//			System.out.println("calc");
			//System.out.println((int)Math.floor(pos[currIdx]+time*2+d));
			int nextIdx = Arrays.binarySearch(pos, (int)Math.floor(pos[currIdx]+time*2+d));
			//System.out.println(nextIdx);
			if(nextIdx<0) nextIdx = -nextIdx-2;
			
			if(nextIdx == n-2) {
				if(nextIdx-currIdx==1) {
					double avg = (double)(pos[currIdx]+pos[n-1])/2;
					double diff = avg-pos[currIdx];
					//System.out.println("diff = "+diff);
					//System.out.println(time+d);
					if(diff<=time+d && Math.abs(pos[n-2]-avg)<=time*2) return true;
					else return false;
//					if((pos[n-1]-pos[currIdx]>time*2+d)) return false;
//
////					if((pos[n-1]-pos[n-2]>time*2+d&&pos[n-2]-pos[currIdx]>time+d) || (pos[n-1]-pos[n-2]>time+d&&pos[n-2]-pos[currIdx]>time*2+d)) return false;
//					return true;
				}
				else {
					nextIdx--;
				}
			}
			
			if(nextIdx <= currIdx) return false;
			
			if(nextIdx >= n-1) break;
			currIdx = nextIdx+1;
		}
		return true;
	}
	
	
}
