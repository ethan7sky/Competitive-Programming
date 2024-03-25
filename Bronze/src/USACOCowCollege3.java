import java.util.*;

public class USACOCowCollege3 {
	
	static Scanner in;
	static long n, cows[], max, idx;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		n = in.nextInt();
		cows = new long[(int)n];
		for(int i=0; i<n; i++) cows[i] = in.nextLong();
		Arrays.sort(cows);
		
		max=0;
		idx=0;
		
		for(int i=0; i<n; i++) {
			
			long money = cows[i]*(n-i);
			
			if(money>max) {
				max=money;
				idx = cows[i];
			}
		}
		
		System.out.println(max+" "+idx);
	}
}