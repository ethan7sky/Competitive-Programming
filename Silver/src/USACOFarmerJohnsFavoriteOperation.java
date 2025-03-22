import java.util.*;
import java.io.*;

public class USACOFarmerJohnsFavoriteOperation {
	
	static int T, N, M, a[];
	static BufferedReader in;
	static StringTokenizer st;
	static TreeMap<Integer, ArrayList<update>> t;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		while(T-->0) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			a = new int[N];
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				a[i] = a[i]%M;
				if(M-a[i] < a[i]) {
					a[i] = a[i]-M;
				}
			}
			t = new TreeMap<Integer, ArrayList<update>>();
			int low = -M/2-(M%2==1?1:0);
			Arrays.sort(a);
			for(int i=0; i<N; i++) {
				if(!t.containsKey(a[i]-low)) {
					t.put(a[i]-low, new ArrayList<update>());
				}t.get(a[i]-low).add(new update("-M/2", i));
				int diff = a[i]-(-1);
				if(diff<0) diff += M;
				if(!t.containsKey(diff)) {
					t.put(diff, new ArrayList<update>());
				}t.get(diff).add(new update("-1", i));
			}
			System.out.println(t);
			if(t.containsKey(0)) t.remove(0);
			
			long currentAnswer = 0;
			for(int i: a) currentAnswer += (i>0? i:-i);
			long minAnswer = currentAnswer;
			
			int previousTime = 0;
			for(int toSubtract: t.keySet()) {
				
				int negativeCount = 0; //# OF <=0 NUMBERS AFTER PREVIOUSTIME
				
				long min = (-M)/2+previousTime;
				long max = 0+previousTime;
//				System.out.println(M);
//				System.out.println((-M)/2);
//				System.out.println(previousTime+" "+min+" "+max);
				if(min>M/2) min-=M;
				if(max>M/2) max-=M;
				int left = (int)min;
				int right = (int)max;
				
				int idxLeft = Arrays.binarySearch(a, left);
				int idxRight = Arrays.binarySearch(a, right);
				if(idxLeft<0) idxLeft = -idxLeft-1;
				if(idxRight<0) idxRight = -idxRight-2;
				if(idxRight<0) idxRight=N;
				
				if(idxLeft<idxRight) {
					negativeCount = idxRight-idxLeft+1;
				}else {
					negativeCount += idxRight+1;
					negativeCount += N-idxLeft;
				}
				System.out.println(idxLeft+" "+idxRight);
				
				
				
				int positiveCount = N-negativeCount; //# OF POSITIVE NUMBERS AFTER PREVIOUSTIME
				
				System.out.println(previousTime+" HERE " + negativeCount+" "+positiveCount);
				
				
				
				int chng = toSubtract - previousTime-1;
				currentAnswer += (long)negativeCount*chng - (long)positiveCount*chng;
				minAnswer = Math.min(currentAnswer, minAnswer);
				
				for(update i: t.get(toSubtract)) {
					if(i.type.equals("-1")) {
						negativeCount++;
						positiveCount--;
					}else {
						negativeCount--;
						positiveCount++;
					}
				}
				currentAnswer += (long)negativeCount;
				currentAnswer -= (long)positiveCount;
				minAnswer = Math.min(currentAnswer, minAnswer);
				
				previousTime = toSubtract;
				System.out.println(minAnswer);
			}
			System.out.println(minAnswer);
		}
	}
	
	static class update {
		String type;
		int idx;
		public update(String s, int i) {
			this.type = s;
			this.idx = i;
		}
		public String toString() {
			return type+" "+idx;
		}
	}
}
