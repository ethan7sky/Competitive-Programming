import java.util.*;
import java.io.*;

public class baekjoon4716 {
	
	static int N, A, B;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static team[] a;
	static int bCnt, aDistSum, bDistSum, ans;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			if(N==0 && A==0 && B==0) break;
			
			a = new team[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				a[i] = new team(
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(a);
			
			aDistSum = 0;
			bDistSum = 0;
			bCnt = 0;
			for(int i=0; i<N; i++) {
				bDistSum += a[i].dB*a[i].K;
				bCnt += a[i].K;
			}

			ans = Integer.MAX_VALUE;
			
			if(bCnt<=B) {
				ans = bDistSum;
			}
			
			int currIdx = 0;
			
			for(int i=1; i<=A; i++) {
				
				if(currIdx >= N) break;
				if(a[currIdx].K==0) {
					currIdx++;
					i--;
					continue;
				}
				
				aDistSum += a[currIdx].dA;
				bDistSum -= a[currIdx].dB;
				a[currIdx].K--;
				
				if(bCnt-i <= B) {
					ans = Math.min(ans, aDistSum+bDistSum);
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	
	
	
	
	
	
	static class team implements Comparable<team> {
		public int K, dA, dB;
		public team(int K, int dA, int dB) {
			this.K= K;
			this.dA = dA;
			this.dB = dB;
		}
		@Override
		public int compareTo(team that) {
			return (that.dB-that.dA) - (this.dB-this.dA); 
		}
		@Override
		public String toString() {
			return K+" "+dA+" "+dB;
		}
	}
}
