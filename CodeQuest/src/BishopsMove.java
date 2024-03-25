import java.util.*;
import java.io.*;

public class BishopsMove {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt(); in.nextLine();
		
		while(t-->0){	
			String[] s1 = in.nextLine().split(",");
			String[] s2 = in.nextLine().split(",");
			String[] s3 = in.nextLine().split(",");
			
			int xd = Integer.parseInt(s1[0]);
			int yd = Integer.parseInt(s1[1]);
			
			int cx = Integer.parseInt(s2[0]);
			int cy = Integer.parseInt(s2[1]);
			
			int tx = Integer.parseInt(s3[0]);
			int ty = Integer.parseInt(s3[1]);
			
			if(tx>xd || ty>yd) System.out.println("No");
			else {
				int diff1 = (ty-cy)%2;
				int diff2 = (tx-cx)%2;
				if(diff1<0) diff1+=2;
				if(diff2<0) diff2+=2;
				System.out.println(diff1 == diff2? "Yes":"No"); 
			}
			
		}
		
	}
	
}
