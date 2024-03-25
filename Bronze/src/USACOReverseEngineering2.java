import java.util.*;
import java.io.*;

public class USACOReverseEngineering2 {
	
	static Scanner in;
	static String inputs[];
	static int t, n, m, outputs[], important[];
	static boolean works;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		t = in.nextInt();
		
		for(int i=0; i<t; i++) {
			
			n = in.nextInt();
			m = in.nextInt();
			
			inputs = new String[m];
			outputs = new int[m];
			for(int j=0; j<m; j++) {
				inputs[j] = in.next();
				outputs[j] = in.nextInt();
			}
			
			Arrays.fill(important, -1);
			works = true;
			
			for(int j=0; j<m; j++) {
				for(int k=j+1; k<m; k++) {
					
					int overlap = cntoverlap(inputs[j], inputs[k]);
					if(overlap == 0 && outputs[j] != outputs[k]) {
						works = false;
					}
					else {
						for(int l=0; l<n; l++) {
							if(inputs[j].charAt(l) != inputs[k].charAt(l)) {
								if(important[l] != 0) {
									
								}
							}
						}
					}
				}
			}
			
			
			if(works) System.out.println("OK");
			else System.out.println("LIE");
		}
		
		
	}
	static int cntoverlap(String a, String b) {
		int cnt = 0;
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {
				cnt++;
			}
		}
		return cnt;
		
		
	}
	
}
