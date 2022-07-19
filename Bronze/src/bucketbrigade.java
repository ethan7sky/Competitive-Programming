import java.io.*;
import java.util.*;  

public class bucketbrigade {
	
	static int barnx, barny, lakex, lakey, rockx, rocky;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		
		init();
		solve();
		
	}
	static void init() throws IOException {
		
		in = new Scanner(new FileReader("buckets.in"));
		out = new PrintWriter("buckets.out");
		
		String[][] a = new String[10][10];
		for(int i = 0; i < 10; i++) {
			a[i] = in.nextLine().split("(?!^)");
		}
				
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(a[i][j].equals("B")) {
					barnx = i;
					barny = j;
				}
				else if(a[i][j].equals("L")) {
					lakex = i;
					lakey = j;
				}
				else if(a[i][j].equals("R")) {
					rockx = i;
					rocky = j;
				}
			}
		}
	}
	static void solve() {
		
		
		int ans = Math.abs(barnx-lakex) + Math.abs(barny-lakey) -1;
		
		if(check()) {
			ans += 2;
		}
		
		out.println(ans);
		
		in.close();
		out.close();
	}
	
	static boolean check() {
		if(barny == rocky && rocky == lakey && (barnx < rockx && rockx < lakex || barnx > rockx && rockx > lakex)) {
			return true;
		}
		if(barnx == rockx && rockx == lakex && (barny < rocky && rocky < lakey || barny > rocky && rocky > lakey)) {
			return true;
		}
		return false;
	}
}
