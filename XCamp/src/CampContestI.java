import java.util.*;
import java.io.*;

public class CampContestI {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		HashSet<Integer> idx = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			String s = in.next();
			int idx1 = s.indexOf("G");
			int idx2 = s.indexOf("S");
			if(idx1==-1||idx2==-1) {
				System.out.println(-1);
				return;
			}
			if(idx1 > idx2) {
				System.out.println(-1);
				return;
			}
			idx.add(idx2-idx1);
		}
		System.out.println(idx.size());
	}
}
