import java.util.*;
import java.io.*;

public class USACOPareidolia {

	static Scanner in;
	static String a;
	static LinkedList<Integer> s, e;
	static long len, cnt;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		a = in.next();
		len = a.length();
		
		String bessie = "bessie";
		int idx = 0;
		
		s = new LinkedList<Integer>();
		e = new LinkedList<Integer>();
		int[] found = new int[7];
		
		for(int i=0; i<len; i++) {
			
			char curr = a.charAt(i);
			found[0]++;
			for(int j=5; j>=0; j--) {
				if(curr==bessie.charAt(j)) {
					found[j+1] += found[j];
					found[j] = 0;
				}
			}
			if(found[6]!=0) {
				s.add(found[6]);
				e.add(i);
				found[0]+=found[6];
				found[6]=0;
			}
			
			System.out.println(Arrays.toString(found));
		}
		
		if(s.size()!=e.size()) s.removeLast();

		System.out.println(s);
		System.out.println(e);
		
		cnt = s.size();
			
		long ans = 0L;
		for(int i=0; i<cnt; i++){
			long l = s.get(i);
			long r = len-e.get(i);
			ans += l*r;
		}
		System.out.println(ans);
		
		
		
//		int[] a = new int[cnt+1];
//		for(int i=0; i<cnt; i++) a[i] = s.get(i)-e.get(i);
//		
//		System.out.println(Arrays.toString(a));
//		
//		long[] p = new long[cnt+2];
//		for(int i=1; i<=cnt+1; i++) p[i] = p[i-1]+a[i-1];
//		
//		System.out.println(Arrays.toString(p));
//		
//		long ans = 0L;
//		for(int i=0; i<cnt; i++){
//			long l = p[i+1];
//			long r = p[cnt]-p[i+2];
//			ans += l*r;
//		}
//		System.out.println(ans);
		
	}
}
