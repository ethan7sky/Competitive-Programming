import java.util.*;
import java.io.*;

public class CampContestP {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		if(a==1 && b!=1 && c!=1) {
			System.out.println((a+b)*c);
		}
		if(a!=1 && b==1 && c!=1) {
			if(a<c) {
				System.out.println((a+b)*c);
			}
			else {
				System.out.println(a*(b+c));
			}
		}
		if(a==1 && b!=1 && c==1) {
			System.out.println(a*(b+c));
		}
		if(a==1 && b==1 && c==1) {
			System.out.println(3);
		}
	}
}
