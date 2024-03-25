import java.util.*;
import java.io.*;

public class USACOLeaders {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, range[];
	static char cows[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		
	}
	static void init() throws IOException {
		
		n = Integer.parseInt(in.readLine());
		cows = in.readLine().toCharArray();
		st = new StringTokenizer(in.readLine());
		range = new int[n];
		for(int i=0; i<n; i++) {
			range[i] = Integer.parseInt(st.nextToken())-1;
		}
		
	//	System.out.println("cow breeds = "+Arrays.toString(cows));
		//System.out.println("ranges = "+Arrays.toString(range));
		
	}
	static void solve() {
		
		//prefix sums
		int g[] = new int[n];
		int h[] = new int[n];
		
		int gcnt=0;
		int hcnt=0;
		
		for(int i=0; i<n; i++) {
			if(cows[i] == 'G') gcnt++;
			else hcnt++;
			
			g[i] = gcnt;
			h[i] = hcnt;
		}
		//System.out.println("prefix sum g = "+Arrays.toString(g));
	//	System.out.println("prefix sum h = "+Arrays.toString(h));
		//System.out.println(gcnt+" "+hcnt);
		//find leaders of own breed
		
		boolean leader[] = new boolean[n];
		Arrays.fill(leader, false);
		
		int gleaders = 0;
		int hleaders = 0;
		
		int prefixsumGleaders[] = new int[n];
		int prefixsumHleaders[] = new int[n];
		
		for(int i=0; i<n; i++) {
			
			if(cows[i] == 'G') {
				if(g[range[i]]-g[i]+1 == gcnt) {
					leader[i] = true;
					gleaders++;
				}
			}
			else {
				if(h[range[i]]-h[i]+1 == hcnt) {
					leader[i] = true;
					hleaders++;
				}
			}
			prefixsumGleaders[i] = gleaders;
			prefixsumHleaders[i] = hleaders;
		}

		//System.out.println(Arrays.toString(prefixsumGleaders));
		//System.out.println(Arrays.toString(prefixsumHleaders));
		//System.out.println("is leader? "+Arrays.toString(leader));
		long ans = (long)gleaders * (long)hleaders;
		
		for(int i=0; i<n; i++) {
			
			if(cows[i] == 'G' && !leader[i]) { //not leader
				int s = i;
				int e = range[i];
				ans += prefixsumHleaders[e] - prefixsumHleaders[s];
			}
			else if(cows[i] == 'H' && !leader[i]) { //not leader
				int s = i;
				int e = range[i];
				ans += prefixsumGleaders[e] - prefixsumGleaders[s];
			}
		}
		
		System.out.println(ans);
	
		
	}
	
	
}