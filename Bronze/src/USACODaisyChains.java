import java.util.*;
import java.io.*;

public class USACODaisyChains {
	
	static BufferedReader in;
	static PrintWriter out;
	static int n, a[];
	
	public static void main(String[] args) throws IOException{
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		
		n = Integer.parseInt(in.readLine());
		a = new int[n];
		
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				
				int sum = 0;
				for(int n = i; n <= j; n++) {
					sum += a[n];
				}
				double average = (double) sum / (j-i+1);
				for(int n = i; n <= j; n++) {
					if(a[n] == average) {
						ans++;
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
