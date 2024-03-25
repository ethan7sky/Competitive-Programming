import java.util.*;
import java.io.*;

public class CF632C {
	
	static BufferedReader in;
	static int n;
	static words a[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		a = new words[n];
		for(int i=0; i<n; i++) a[i]= new words(in.readLine());
		Arrays.sort(a);
		
		StringBuilder sb = new StringBuilder();
		for(words i: a) sb.append(i.word);
		System.out.println(sb);
	}
	static class words implements Comparable<words> {
		
		String word;
		words(String s) { word = s; }
		
		@Override
		public int compareTo(CF632C.words o) {
			// TODO Auto-generated method stub
			return (this.word+o.word).compareTo(o.word+this.word);
		}
		
		
	}
	
}
