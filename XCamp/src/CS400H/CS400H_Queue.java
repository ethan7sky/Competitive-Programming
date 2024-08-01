package CS400H;
import java.util.*;
import java.io.*;

public class CS400H_Queue {
	static BufferedReader in;
	static StringTokenizer st;
	static TreeSet<Integer> a;
	static int n, currTime, cnt;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		a = new TreeSet<Integer>();
		for(int i=0; i<n; i++) a.add(Integer.parseInt(st.nextToken()));
		
		int currTime=0;
		while(currTime <= a.last()) {
			int next = a.ceiling(currTime);
			currTime += next;
			a.remove(next);
			cnt++;
			System.out.println(next);
		}
		System.out.println(cnt);
	}
}
