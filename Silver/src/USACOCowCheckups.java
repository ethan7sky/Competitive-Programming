import java.util.*;
import java.io.*;

public class USACOCowCheckups {
	
	static int MAX_N = 5*(int)1e5+10;
	static int N;
	static int[] a, b;
	static long ans = 0;
	static ArrayList<Integer> breedIdx[] = new ArrayList[MAX_N];
	static long[][] pref = new long[MAX_N][], suff = new long[MAX_N][];
	static BufferedReader in;
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		for(int i=1; i<=N; i++) {
			breedIdx[i] = new ArrayList<Integer>();
		}
		
		a = new int[N+1];
		b = new int[N+1];
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=N; i++) {
			b[i] = Integer.parseInt(st.nextToken());
			breedIdx[b[i]].add(i);
		}
		
		
		for(int i=1; i<=N; i++) {
			Collections.sort(breedIdx[i]);
			int sz = breedIdx[i].size();
			pref[i] = new long[sz+1];
			suff[i] = new long[sz+1];
			for(int j=1; j<=sz; j++) {
				pref[i][j] = pref[i][j-1]+breedIdx[i].get(j-1);
			}
			for(int j=sz-1; j>=0; j--) {
				suff[i][j] = suff[i][j+1]+(N-breedIdx[i].get(j)+1);
			}
			//reverse suff array for easy indexing
			for(int j=0; j<(sz+1)/2; j++) {
				long temp = suff[i][j];
				suff[i][j] = suff[i][sz-j];
				suff[i][sz-j] = temp;
			}
		}
//		for(int i=1; i<4; i++) {
//			for(int j: pref[i]) System.out.print(j+" ");
//			System.out.println();
//			for(int j: suff[i]) System.out.print(j+" ");
//			System.out.println("\n");
//		}
		
		//solve
		for(int i=1; i<=N; i++) {
			if(a[i] == b[i]) {
				ans += Math.min(i, N-i+1);
				ans += (long)(i-1) + (long)(i-1)*(i-2)/2;
				ans += (long)(N-i) + (long)(N-i)*(N-i-1)/2;
			}
//			System.out.println("ans is now "+ans);
			
			int sz = breedIdx[a[i]].size();
			int idx = Collections.binarySearch(breedIdx[a[i]], i);
			
			int beforeCnt, afterCnt;
			
			if(idx<0) {
				idx = -idx-1;
				beforeCnt = idx;
				afterCnt = sz-idx;
			}else {
				beforeCnt = idx;
				afterCnt = sz-idx-1;
			}
//			System.out.println(ans);
//			System.out.println("beforeCnt = "+beforeCnt);
//			System.out.println("afterCnt = "+afterCnt);
			
			if(i-1 < N-i) {
				ans += pref[a[i]][beforeCnt];
				int idx2 = Collections.binarySearch(breedIdx[a[i]], N-i+1);
				if(idx2<0) idx2 = -idx2-1;
				ans += suff[a[i]][sz-idx2];
				ans += (long)i*(sz-beforeCnt-(sz-idx2)-(a[i]==b[i]? 1:0));
			}
			else if(i-1 > N-i) {
				ans += suff[a[i]][afterCnt];
//				System.out.println("ANS = "+ans);
				int idx2 = Collections.binarySearch(breedIdx[a[i]], N-i);
//				System.out.println("idx = "+idx2);
				if(idx2<0) idx2 = -idx2-2;
				idx2++;
				ans += pref[a[i]][idx2];
//				System.out.println("value = "+pref[a[i]][idx2]);
				ans += (long)(N-i+1)*(sz-afterCnt-idx2-(a[i]==b[i]?1:0));
			}
			else if(i-1 == N-i){
				ans += pref[a[i]][beforeCnt];
				ans += suff[a[i]][sz-beforeCnt-(a[i]==b[i]?1:0)];
			}
		}
			System.out.println(ans);
	}
}
