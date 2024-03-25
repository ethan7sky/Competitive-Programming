import java.util.*;
import java.io.*;

public class USACOCereal {
	
	static ArrayList<Integer>[] firstIdx, secondIdx;
	static int[][] cereal;
	static int[] chosen;
	static int[] choose;
	static int n, m, ans;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		chosen = new int[m+1];
		cereal = new int[n][2];
		choose = new int[n];
		
		firstIdx = new ArrayList[m+1];
		secondIdx = new ArrayList[m+1];
		
		for(int i=0; i<=m; i++) {
			firstIdx[i]= new ArrayList<Integer>();
			secondIdx[i] = new ArrayList<Integer>();
		}
		
		ans = 0;
		Arrays.fill(chosen, -1);
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			cereal[i][0] = first;
			cereal[i][1] = second;
			
			if(chosen[first] == -1) {
				chosen[first] = i;
				choose[i] = 1;
				ans++;
			}
			else {
				firstIdx[first].add(i);
				if(chosen[second]==-1) {
					chosen[second] = i;
					choose[i] = 2;
					ans++;
				}
				else {
					choose[i] = -1;
					secondIdx[second].add(i);
				}
			}
		}
		System.out.println(ans);
		System.out.println(Arrays.toString(choose));
		System.out.println(Arrays.toString(firstIdx));
		System.out.println(Arrays.toString(secondIdx));
		
		
		for(int i=0; i<n; i++) {
			ans--;
			update(i);
			System.out.println(Arrays.toString(choose));
		}
		
	}
	static void update(int currCow) {
		
		int toRemove = cereal[currCow][0];
		int second = cereal[currCow][1];
		firstIdx[toRemove].remove(0);
		secondIdx[second].remove(0);
		
		if(firstIdx[toRemove].isEmpty() && secondIdx[toRemove].isEmpty()) {
			return;
		}
		
		int firstOccurance = findFirstOccurance(toRemove); 
		if(cereal[firstOccurance][1]==toRemove) {
			
		}
		
		if(firstIdx[toRemove].isEmpty()) {
			for(int nextIdx: secondIdx[toRemove]) {
				if(choose[nextIdx]==-1) {
					choose[nextIdx] = 2;
					ans++;
					return;
				}
			}
			return;
		}
		if(secondIdx[toRemove].isEmpty()) {
			int nextIdx = firstIdx[toRemove].get(0);
			if(choose[nextIdx] == 2) {
				if(!firstIdx[cereal[nextIdx][1]].isEmpty()) {
					keepSearching(firstIdx[cereal[nextIdx][1]].get(0));
				}
			}
			else {
				
			}
			choose[nextIdx] = 1;
			
		}
	}
	static void keepSearching(int currCow){
		
		
	}
	static int findFirstOccurance(int i) {
		
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		
		for(int j: firstIdx[i]) {
			if(choose[j] != 1) {
				a = j;
				break;
			}
		}
		for(int j: secondIdx[i]) {
			if(choose[j] == -1) {
				b = j;
				break;
			}
		}
		
		int min = Math.min(a, b);
		if(min==Integer.MAX_VALUE) return -1;
		else return min;
	}
}
