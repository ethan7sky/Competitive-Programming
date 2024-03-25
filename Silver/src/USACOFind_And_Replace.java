import java.util.*;
import java.io.*;

public class USACOFind_And_Replace {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int t, len;
	static int ans;
	static int[] s1;
	static int[] s2;
	static int[] pointsto;
	static ArrayList<ArrayList<Integer>> chains = new ArrayList<ArrayList<Integer>>();
	static boolean[] visited;
	static boolean[] partofcycle;
	static boolean[] partofchain;
	
	public static void main(String[] args) throws IOException {
		
		t = Integer.parseInt(in.readLine());
		
		testcases:
		while(t-->0 ) {
			
			char[] input1 = in.readLine().toCharArray();
			char[] input2 = in.readLine().toCharArray();
			len = input1.length;
			
			s1 = new int[len];
			s2 = new int[len];
			
			for(int i=0; i<len; i++) {
				if(input1[i]<'a') s1[i] = input1[i]-'A'+27; //uppercase
				else s1[i] = input1[i]-'a'+1; //lowercase
				if(input2[i]<'a') s2[i] = input2[i]-'A'+27; //uppercase
				else s2[i] = input2[i]-'a'+1; //lowercase
			}
			
			System.out.println(Arrays.toString(s1));
			System.out.println(Arrays.toString(s2));
			
			pointsto = new int[52+1];
			
			for(int i=0; i<len; i++) {
				if(pointsto[s1[i]] != 0) {
					System.out.println(-1);
					continue testcases;
				}
				else {
					pointsto[s1[i]] = s2[i];
				}
			}
			System.out.println(Arrays.toString(pointsto));
			
			//count cycles
			visited = new boolean[52+1];
			partofcycle = new boolean[52+1];
			countcycles();
			
			//count chains
			
			
			System.out.println();
		}
		
	}
	static void countcycles() {
		
		for(int i=0; i<52+1; i++) {
			//complete brute force
		}
		//update partofcycle
	}
	
}
