import java.util.*;
import java.io.*;

public class USACOCereal_2 {
	
	static ArrayList<Integer>[] firstIdx, secondIdx;
	static int[][] cereal;
	static int[] chosen;
	static int[] choose;
	static boolean[] usingSecond;
	static int n, m, ans;
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static HashSet<Integer> used;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		chosen = new int[m+1];
		cereal = new int[n][2];
		choose = new int[n];
		usingSecond = new boolean[n];
		used = new HashSet<Integer>();
		
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
					usingSecond[i] = true;
				}
				else {
					choose[i] = -1;
					secondIdx[second].add(i);
				}
			}
		}
//		System.out.println(ans);
//		System.out.println(Arrays.toString(choose));
//		System.out.println(Arrays.toString(firstIdx));
//		System.out.println(Arrays.toString(secondIdx));
		
		
		for(int i=0; i<n; i++) {
			System.out.println("--------"+(i+1));
			System.out.println(Arrays.toString(firstIdx));
			System.out.println(Arrays.toString(secondIdx));
			System.out.println(ans);
			ans--;
			update(i);
		}
		
	}
	static void update(int currCow) {

		int toRemove = cereal[currCow][0];
		int second = cereal[currCow][1];
		if(!firstIdx[toRemove].isEmpty() && firstIdx[toRemove].get(0)==currCow) {
			firstIdx[toRemove].remove(0);
		}
		if(!secondIdx[second].isEmpty() && secondIdx[second].get(0)==currCow) {
			secondIdx[second].remove(0);
		}
		
		int firstOccurance = findFirstOccurance(toRemove);
		
		//System.out.println(firstOccurance);
		if(firstOccurance == -1) {
			System.out.println("no occurances found");
			return;
		}
		else {
			System.out.println("found!");
		}
		
		if(cereal[firstOccurance][1]==toRemove) {
			secondIdx[toRemove].remove(0);
			ans++;
			usingSecond[firstOccurance] = true;
		}
		else {
			if(!usingSecond[firstOccurance]) {
				ans++;
			}
			else {
				usingSecond[firstOccurance] = false;
			}
			update(firstOccurance);
		}
	}
	static int findFirstOccurance(int i) {
		
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		
		if(!firstIdx[i].isEmpty()) {
			a = firstIdx[i].get(0);
		}
		if(!secondIdx[i].isEmpty()) {
			b = secondIdx[i].get(0);
		}
		
		int min = Math.min(a, b);
		if(min==Integer.MAX_VALUE) return -1;
		else return min;
	}
}
