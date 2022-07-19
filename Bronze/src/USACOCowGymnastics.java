import java.util.*;
import java.io.*;

public class USACOCowGymnastics {
	
	static BufferedReader in;
	static PrintWriter out;
	static int k, n, ans;
	static String[] a, b;
	
	public static void main(String[] args) throws IOException{
		
		//init
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("gymnastics.in"));
		out = new PrintWriter("gymnastics.out");
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		k = Integer.valueOf(st.nextToken());
		n = Integer.valueOf(st.nextToken());
		
		
		a = new String[k];
		for(int i = 0; i < k; i++) {
			a[i] = in.readLine().replaceAll(" ", "");
		}
		
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < n; j++) {
				
			}
		}
		
		//solve
		for(int i = 1; i < n; i++) {
			for(int j = i+1; j <= n; j++) {
				
				boolean consistant = true;
				int dis = a[0].indexOf(i+"") - a[0].indexOf(j+"");
				
				
				for(int l = 0; l < k; l++) {
					if(dis * (a[l].indexOf(i+"") - a[l].indexOf(j+"")) < 0) {
						consistant = false;
						break;
					}
				}
				if(consistant) {
					ans++;
				}
			}
		}
		
		/*System.*/out.println(ans);
		
		in.close();
		out.close();
	}
}
