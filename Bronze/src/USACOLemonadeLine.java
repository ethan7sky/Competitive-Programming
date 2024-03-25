import java.util.*;
import java.io.*;

public class USACOLemonadeLine {
	
	static Scanner in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, a[], cnt;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		in = new Scanner(new FileReader("lemonade.in"));
		out = new PrintWriter("lemonade.out");
		
		n = in.nextInt(); in.nextLine();
		st = new StringTokenizer(in.nextLine());
		a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		
		cnt=0;
		for(int i=n-1; i>=0; i--) {
			if(a[i]<cnt) break;
			else cnt++;
		}
		
		out.println(cnt);
		
		in.close();
		out.close();
	}
}
