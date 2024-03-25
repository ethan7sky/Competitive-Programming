import java.util.*;
import java.io.*;

public class TowerOfHanoi {
	
	static void recurse(int n, int start, int end, int aux) {
		
		if(n==0) return;
		
		recurse(n-1, start, aux, end);
		System.out.println(start+" "+end);
		recurse(n-1, aux, end, start);
	}
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println((int)Math.pow(2, n)-1);
		recurse(n, 1, 3, 2);
	}
}

