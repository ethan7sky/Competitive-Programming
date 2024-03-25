import java.util.*;
import java.io.*;

public class TrailingZeros {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int multi = 5;
		int cnt= 0;
		
		while(multi<=n) {
			cnt += n/multi;
			multi*=5;
		}
		System.out.println(cnt);
	}
}
