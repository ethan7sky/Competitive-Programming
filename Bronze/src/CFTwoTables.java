import java.util.*;
import java.io.*;

public class CFTwoTables {
  
	static BufferedReader in;
	static StringBuilder sb;
	static long cnt, W, H, x1, y1, x2, y2, w, h;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		cnt = Integer.valueOf(in.readLine());
		sb = new StringBuilder();
		
		for(int i = 0; i < cnt; i++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			W = Long.valueOf(st.nextToken());
			H = Long.valueOf(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			x1 = Long.valueOf(st.nextToken());
			y1 = Long.valueOf(st.nextToken());
			x2 = Long.valueOf(st.nextToken());
			y2 = Long.valueOf(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			w = Long.valueOf(st.nextToken());
			h = Long.valueOf(st.nextToken());
			
			
			long ans = Long.MAX_VALUE;
			
			long TW = x2-x1;
			long TH = y2-y1;
			
			if(TW + w <= W) {
				ans = Math.min(ans, Math.max(0, w-x1));
				ans = Math.min(ans, Math.max(0, x2-W+w)); //w-(W-TW)
			}
			if(TH + h <= H) {
				ans = Math.min(ans,  Math.max(0, h-y1));
				ans = Math.min(ans,  Math.max(0, y2-H+h)); // h-(h-y2)
			}
			
			if(ans == Long.MAX_VALUE) {
				ans = -1;
			}
			System.out.println(ans);
		}
	}
}