import java.util.*;
import java.io.*;

public class USACOMeetings {
	
	static int N, L;
	static int cntL, cntR;
	static BufferedReader in;
	static StringTokenizer st;
	static cow[] rCows, lCows;
	static cow[] a;
	static long totalTime;
	static int weightSum=0;
	static Deque<cow> dq;
	static Long[] posL, posR;
	static int meetingCnt;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		
		N= Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		a = new cow[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int w, x, d;
			w = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			a[i] = new cow(w, x, d);
			int dummy = d==1? cntR++ : cntL++;
			
			weightSum += w;
		}
		
		rCows = new cow[cntR];
		lCows = new cow[cntL];
		
		int idxL = 0, idxR = 0;
		for(cow c: a) {
			if(c.d==1) {
				rCows[idxR] = c;
				idxR++;
			} else {
				lCows[idxL] = c;
				idxL++;
			}
		}
		Arrays.sort(a);
		Arrays.sort(rCows);
		Arrays.sort(lCows);
		
		dq = new ArrayDeque<cow>();
		for(cow c: a) dq.add(c);
		
		int currW = 0;
		idxL = 0; idxR = rCows.length-1;
		while(currW < weightSum/2.0) {
			long timeTo0 = idxL<lCows.length ? lCows[idxL].x : Long.MAX_VALUE;
			long timeToL = idxR>=0 ? L-rCows[idxR].x : Long.MAX_VALUE;
			if(timeTo0==Long.MAX_VALUE && timeToL==Long.MAX_VALUE) break;
			if(timeTo0 <= timeToL) {
				idxL++;
				currW += dq.pollFirst().w;
				totalTime = Math.max(totalTime, timeTo0);
			} if(timeTo0 >= timeToL){
				idxR--;
				currW += dq.pollLast().w;
				totalTime = Math.max(totalTime, timeToL);
			}
		}
//		System.out.println(currW);
//		System.out.println(totalTime);
		
		meetingCnt = 0;
		posL = new Long[lCows.length];
		posR = new Long[rCows.length];
		for(int i=0; i<lCows.length; i++) posL[i] = (long)lCows[i].x;
		for(int i=0; i<rCows.length; i++) posR[i] = (long)rCows[i].x;
		
//		System.out.println(Arrays.toString(a));
		
		for(cow c: a) {
			long currX = c.x;
			long finalX = c.x+c.d*totalTime*2;
			if(c.d==1) {
				int idx1 = Arrays.binarySearch(posL, currX)*-1-1;
				int idx2 = Arrays.binarySearch(posL, finalX);
				if(idx2<0) idx2 = -idx2-1;
				else idx2++; //NOTE THIS IS THE WORST SOLUTION I HAVE FOR THE OVERCOUNTING BUT IT SHOULD WORK
//				if(c.x<=500000024) System.out.println(idx1-25+" "+(idx2-25));
				meetingCnt += idx2-idx1;
			} else {
				int idx2 = Arrays.binarySearch(posR, currX)*-1-1;
				int idx1 = Arrays.binarySearch(posR, finalX);
				if(idx1<0) idx1 = -idx1-1;
				meetingCnt += idx2-idx1;
			}
			
//			System.out.println(meetingCnt);
		}
		
		if(meetingCnt%2!=0) {
			throw new IOException();
		}
		System.out.println(meetingCnt/2);
		
		
	}
	static class cow implements Comparable<cow> {
		long w, x, d;
		public cow(long w, long x, long d) {
			this.w = w;
			this.x = x;
			this.d = d;
		}
		@Override
		public String toString() {
			return w+" "+x+" "+d;
		}
		@Override
		public int compareTo(cow that) {
			if(this.x>that.x) return 1;
			else if(this.x<that.x) return -1;
			return 0;
		}
	}
}
