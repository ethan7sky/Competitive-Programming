import java.util.*;
import java.io.*;

public class AugmentingReality {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder sb = new StringBuilder();
		while(t-->0) {
			int r = in.nextInt();
			int w = in.nextInt();
			int h = in.nextInt();
			for(long x=0; x<=w; x++) {
				for(long y=0; y<=h; y++) {
					if(Math.pow(x, 2)+Math.pow(y, 2)>Math.pow(r, 2)) {
						sb.append(x).append(",").append(y).append("\n");
					}
				}
			}
		}
		System.out.print(sb);
	}
}
