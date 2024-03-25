import java.util.*;
import java.io.*;

public class USACOMooOperations {
	
	static BufferedReader in;
	static int n;
	static HashMap<String, Integer> swapsneeded;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		initHashmap();
		for(int i=0; i<n; i++) {
			
			//solve
			String s = in.readLine();
			
			HashSet<String> hs = new HashSet<String>();
			
			for(int j=1; j<s.length()-1; j++) {
				if(s.charAt(j)=='O') {
					hs.add(s.substring(j-1, j+2));
				}
			}
			
			if(hs.size()==0) {
				System.out.println(-1);
			}
			else {
				int min = Integer.MAX_VALUE;
				for(String text: hs) {
					min = Math.min(min, swapsneeded.get(text));
				}
				
				System.out.println(min+s.length()-3);				
			}
			
		}
	}
	static void initHashmap() {
		swapsneeded = new HashMap<String, Integer>();
		swapsneeded.put("OOO", 1);
		swapsneeded.put("OOM", 2);
		swapsneeded.put("MOO", 0);
		swapsneeded.put("MOM", 1);
		
	}
}
