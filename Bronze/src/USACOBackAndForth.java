import java.util.*;
import java.io.*;

public class USACOBackAndForth {
	
	static Scanner in;
	static PrintWriter out;
	static int a[], b[], a1[], b1[];
	static HashSet<Integer> set;
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new FileReader("backforth.in"));
		out = new PrintWriter("backforth.out");
		
		init();
		solve();
		
		in.close();
		out.close();
		
	}
	
	static void init() throws IOException {
		
		a = new int[10];
		b = new int[10];
		a1 = new int[10];
		b1 = new int[10];
		
		
		for(int i = 0; i < 10; i++) {
			a[i] = in.nextInt();
		}
		
		for(int i = 0; i < 10; i++) {
			b[i] = in.nextInt();
		}
		
		a1 = a.clone();
		b1 = b.clone();
		
		set = new HashSet<Integer>();
	}
	
	static void solve() {
		
		for(int i = 0; i < 10; i++) { //tuesday
			for(int j = 0; j < 10; j++) { //wednesday
				int TW = -a1[i]+b1[j];
				
				int temp = a1[i];
				a1[i] = b1[j];
				b1[j] = temp;
				
				for(int k = 0; k < 10; k++) { //thursday
					for(int l = 0; l < 10; l++) { //friday
						int TF = -a1[k] + b1[l];
						
						set.add(TW + TF);
					}
				}
				
				a1 = a.clone();
				b1 = b.clone();
			}
		}
		
		out.println(set.size());
	}
	
}