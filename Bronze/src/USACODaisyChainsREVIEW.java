import java.util.*;
import java.io.*;

public class USACODaisyChainsREVIEW {
	
	static Scanner in;
	static PrintWriter out;
	static int n, petals[], ans;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		n = in.nextInt();
		petals = new int[n];
		for(int i=0; i<n; i++) {
			petals[i] = in.nextInt();
		}
		
		ans=0;
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				
				HashSet<Double> petalcnt = new HashSet<Double>();
				
				double cnt=0.0;
				for(int k=i; k<=j; k++) {
					cnt += petals[k];
					petalcnt.add((double) petals[k]);
				}
				
				cnt /= j-i+1;
				
				
				if(petalcnt.contains(cnt)) ans++;	
				
			}
		}
		System.out.println(ans);
		
	}
}
