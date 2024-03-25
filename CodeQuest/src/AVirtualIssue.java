import java.util.*;
import java.io.*;

public class AVirtualIssue {
	
	static final double TARGET_FRAME_TIME = (double)1000/90;
	static final double LOW_THRESHOLD = TARGET_FRAME_TIME*0.7,
			EXTRAPOLATE_THRESHOLD = TARGET_FRAME_TIME*0.85,
			HIGH_THRESHOLD = TARGET_FRAME_TIME*0.9;
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		while(t-->0) {

			double f1 = in.nextDouble();
			double f2 = in.nextDouble();
			double f3 = in.nextDouble();
			int q = in.nextInt();
			
			if(f3>HIGH_THRESHOLD) q-=2;
			else if(f3>EXTRAPOLATE_THRESHOLD) {
				double val1 = f3+(f3-f2);
				double val2 = f3+(f3-f1)/2;
				if(Math.max(val1, val2)>HIGH_THRESHOLD) q-=2;
			}
			else if(f1<LOW_THRESHOLD&&f2<LOW_THRESHOLD&&f3<LOW_THRESHOLD) {
				q++;
			}
			q = guaranteeInRange(1, 10, q);
			System.out.println(q);
		}
	}
	
	
	static int guaranteeInRange(int min, int max, int val) {
		val = Math.max(min, val);
		val = Math.min(max, val);
		return val;
	}
}
