import java.util.*;
import java.io.*;

public class baekjoon14420 {
	
	static int N, M, K; //N stations, M express stops, K semiexpress stops
	static int A, B, C; //time for local, express, semiexpress
	static int T; //max time;
	static int stops[]; // for express train
	
	static BufferedReader in;
	static StringTokenizer st;
	
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		K -= M;
		
		st = new StringTokenizer(in.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		T = Integer.parseInt(in.readLine());
		
		stops = new int[M];
		for(int i=0; i<M; i++) stops[i] = Integer.parseInt(in.readLine());
		
		search:
		for(int i=0; i<M-1; i++ ) {
			
			int currEStop = stops[i];
			int nextEStop = stops[i+1];
			
			int timeToCurr = B*(currEStop-1);
			if(timeToCurr>T) break;
			else if(i>0) cnt++;
			
			int lastIdx = currEStop;
			
			int nextCnt = (T-timeToCurr)/A;
			if(currEStop+nextCnt+1 >= nextEStop) {
				cnt += nextEStop-1 - lastIdx;
				continue;
			} else {
				cnt += nextCnt;
				lastIdx += nextCnt;
			}
			
			while(K>0) {
				if(lastIdx == nextEStop-1) break;
				if(timeToCurr + (lastIdx+1-currEStop)*C <= T) {
					K--;
					cnt++;
					lastIdx++;
				}
				
				
				
				nextCnt += (T-timeToCurr-(lastIdx+1-currEStop)*C)/A;
				System.out.println("nextCnt = "+nextCnt);
				
				if(nextCnt <= 0) break;
				
				if(lastIdx+nextCnt >= nextEStop) {
					K--;
					cnt += nextEStop-1 - lastIdx;
					break;
				}
				else {
					K--;
					System.out.println("put stop at "+(lastIdx+1));
					cnt += nextCnt;
					lastIdx += nextCnt;
				}
			}
			
		}
		if((N-1)*B <= T) cnt++;
		
		System.out.println(cnt);
		
		
		
	}
}
