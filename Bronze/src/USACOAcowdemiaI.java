import java.util.*;
import java.io.*;

public class USACOAcowdemiaI {
	
	static int n, l, a[], max;
	static ArrayList<Integer> citations;
	static Scanner in;
	
	public static void main(String[] args) { 
		
		in = new Scanner(System.in); 
		init();
		solve();
	}
	static void init() {
		n = in.nextInt();
		l = in.nextInt();
		
		citations = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			citations.add(in.nextInt());
		}
		Collections.sort(citations, Collections.reverseOrder());
		 
		max=0;		
	}
	static void solve() {
		
		for(int hidx=1; hidx<=n; hidx++) {
			
			int idx = hidx-1;
			int citationsleft = l;
			
			boolean works=true;
			while(idx >= 0) {
				
				if(citations.get(idx) >= hidx) {
					works = true;
					break;
				}
				else if(citationsleft > 0 && citations.get(idx)+1 >= hidx) {
					citationsleft--;
					idx--;
				}
				else {
					works = false;
					break;
				}
			}
			if(works) max = hidx;
		}
		System.out.println(max);
	}
}
