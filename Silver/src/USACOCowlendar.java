import java.util.*;
import java.io.*;

public class USACOCowlendar {
	
	static int N;
	static HashSet<Long> a;
	static long[] a2;
	static BufferedReader in;
	static StringTokenizer st;
	static long ans=0;
	
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		a = new HashSet<Long>();
		st = new StringTokenizer(in.readLine());
		long maxWeek = Long.MAX_VALUE;
		for(int i=0; i<N; i++) {
			long x = Long.parseLong(st.nextToken());
			a.add(x);
			maxWeek = Math.min(maxWeek, x/4);
		}
		if(a.size() <= 3) {
			System.out.println(maxWeek*(maxWeek+1)/2);
		}
		else {
			a2 = new long[a.size()];
			int idx=0;
			for(long i: a) {
				a2[idx] = i;
				idx++;
			}
			HashSet<Long> div = new HashSet<Long>();
			for(int i=0; i<4; i++) {
				for(int j=i+1; j<4; j++) {
					long diff = Math.abs(a2[i]-a2[j]);
					for(int d=1; d<=100000; d++) {
						if(diff%d==0L) {
							div.add((long)d);
							div.add(diff/d);
						}
					}
				}
			}
			ans = 0;
			for(long i: div) {
				if(i>maxWeek) continue;
				HashSet<Long> cnt = new HashSet<Long>();
				for(long j: a2) {
					cnt.add(j%i);
					if(cnt.size()>3) break;
				}
				if(cnt.size()<=3) ans += i;
			}
			System.out.println(ans);
		}
	}
}
