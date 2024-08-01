import java.util.*;
import java.io.*;

public class CF814C {
	
	static int n, q;
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static String word;
	static ArrayList<Integer>[] a = new ArrayList[26];
	static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		word = in.readLine();

		sb = new StringBuilder();
		
		q = Integer.parseInt(in.readLine());
		while(q-->0) {
			st = new StringTokenizer(in.readLine());
			int len = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			
			int s=0;
			int e=0;
			int notCharCnt=word.charAt(0)==c ?0:1;
			int maxLen=1;
			while(true) {
				
				if(notCharCnt>len) {
					if(word.charAt(s)!=c) notCharCnt--;
					s++;
				}
				else {
					e++;
					if(e>=n) break;
					if(word.charAt(e)!=c) notCharCnt++;
				}
				if(notCharCnt<=len) 
					maxLen = Math.max(maxLen, e-s+1);
				
				//System.out.println(s+" "+e+" "+notCharCnt+" "+maxLen);
			}
			sb.append(maxLen).append("\n");
		}
		System.out.print(sb);
	}
	
}
