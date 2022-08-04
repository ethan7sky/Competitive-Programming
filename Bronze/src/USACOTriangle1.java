import java.util.*;
import java.io.*;

public class USACOTriangle1 {
	static Scanner in;
	static PrintWriter out;
	static int n, x[], y[], area;
	static TreeSet<Integer> setX, setY;
	
	public static void main(String[] args) throws IOException{
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	static void init() throws IOException{
		in = new Scanner(new FileReader("triangles.in"));
		out = new PrintWriter("triangles.out");
		
		n = in.nextInt();
		
		x = new int[n];
		y = new int[n];
		for(int i = 0; i < n; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			
		}

		setX = new TreeSet<Integer>();
		setY = new TreeSet<Integer>();
		
	}
	
	static void solve() {
		int max = -1;
		
		for(int i = 0; i < n-2; i++) {
			for(int j = i+1; j < n-1; j++) {
				for(int k = j+1; k < n; k++) {
					if(check(i,j,k)) {
						max = Math.max(max,  Math.abs(setX.first()-setX.last()) * Math.abs(setY.first()- setY.last()));
					}
				}
			}
		}
		out.println(max);
	}
	
	static boolean check(int i, int j, int k) {
		
		setX.clear(); setY.clear();
		setX.add(x[i]); setX.add(x[j]); setX.add(x[k]);
		setY.add(y[i]); setY.add(y[j]); setY.add(y[k]);
		
		return setX.size() == 2 && setY.size() == 2;
		
	}
	
}
