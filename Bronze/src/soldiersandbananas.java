import java.io.*;
import java.util.*;
 
public class soldiersandbananas {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long cost = in.nextLong();
		int init = in.nextInt();
		int amt = in.nextInt();
		
		long tamt = amt*(amt+1)/2;
		
		long finalcost = cost*tamt;
		
		long res = finalcost - init;
		if(res < 0) {
			res = 0;
		}
		
		System.out.println(res);
		
		
	}
}
