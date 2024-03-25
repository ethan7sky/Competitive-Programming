/* 
ID: ethan7s1
LANG: JAVA
PROB: transform
*/ 

import java.util.*;
import java.io.*;

public class transform {
	
	static char[][] original, a, res;
	static Scanner in;
	static PrintWriter out;
	static int n;
	
	public static void main(String[] args) throws IOException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("transform.in"));
		out = new PrintWriter("transform.out");
		
		n = in.nextInt();
		
		original = new char[n][];
		res = new char[n][];
		for(int i=0; i<n; i++) original[i] = in.next().toCharArray();
		for(int i=0; i<n; i++) res[i] = in.next().toCharArray();
		
		
		reset();
		if(compare(rotate90(a),res)) out.println(1);
		else if(compare(rotate90(rotate90(a)),res)) out.println(2);
		else if(compare(rotate90(rotate90(rotate90(a))),res)) out.println(3);
		else if(compare(reflect(a),res)) out.println(4);
		else if(compare(rotate90(reflect(a)),res)) out.println(5);
		else if(compare(rotate90(rotate90(reflect(a))),res)) out.println(5);
		else if(compare(rotate90(rotate90(rotate90(reflect(a)))),res)) out.println(5);
		else if(compare(a, res)) out.println(6);
		else out.println(7);
		
		in.close();
		out.close();
	}
	
	static char[][] rotate90(char[][] b){
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				char temp = b[i][j];
				b[i][j] = b[j][i];
				b[j][i] = temp;
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n/2; j++) {
				char temp = b[i][j];
				b[i][j]=b[i][n-j-1];
				b[i][n-j-1]=temp;
			}
		}
		return b;
		
	}
	static char[][] reflect(char[][] b){
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n/2; j++) {
				char temp = b[i][j];
				b[i][j]=b[i][n-j-1];
				b[i][n-j-1]=temp;
			}
		}
		return b;
		
	}
	static boolean compare(char[][] b, char[][] c) {
		reset();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(b[i][j] != c[i][j]) return false;
			}
		}return true;
		
	}
	static void reset() {
		a = new char[n][];
		for(int i=0; i<n; i++) {
			a[i] = original[i].clone();
		}
	}
}
