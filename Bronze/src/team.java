import java.io.*;
import java.util.*;
 
public class team {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt(); in.nextLine();
		int res = 0;
		for(int i = 0; i < x; i++) {
			String line =in.nextLine();
			int cnt = 0;
			for(int j = 0; j < line.length(); j++) {
				if(line.charAt(j) == '1') {
					cnt++;
				}
			}
			if(cnt >= 2) {
				res++;
			}
		}
		System.out.println(res);
	}
}
