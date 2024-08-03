import java.util.*;
import java.io.*;

public class CF540094B2 {
	
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
		
		sb = new StringBuilder();
		
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
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
		
	}
	static boolean calc(double time) {
		
		boolean works = false;
		double currIdx = pos[0] + time;
		
		for(int i=1; i<n; i++) {
			//System.out.println(works+" "+currIdx);
			if(works) {
				if(currIdx < pos[i]-(time+d)) {
					works = false;
				}
				currIdx = pos[i]+time;
			}
			else {
				if(currIdx < pos[i]-(time+d)) {
					return false;
				}
				works = true;
				currIdx = Math.min(currIdx+d, pos[i]+time);
			}
		}
		return works;
	}
	
	
}
