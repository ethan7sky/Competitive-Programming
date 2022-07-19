import java.util.*;
import java.io.*;

public class USACOMixingMilk {
	static Scanner in;
	static PrintWriter out;
	static int caps[], buckets[];
	
	public static void main(String[] args) throws IOException{
		
		in = new Scanner(new FileReader("mixmilk.in"));
		out = new PrintWriter("mixmilk.out");
		
		caps = new int[3];
		buckets = new int[3];
		
		for(int i = 0; i < 3; i++) {
			caps[i] = in.nextInt();
			buckets[i] = in.nextInt();
		}
		
		for(int i=0; i < 4; i++) {
			int idx = i%3;
			int idx2 = (i+1)%3;
			
			int temp = buckets[idx2];
			buckets[idx2] = Math.min(buckets[idx]+ buckets[idx2], caps[idx2]);
			buckets[idx] -= (buckets[idx2]-temp);
		}
		
		for(int i = 0; i < 3; i++) {
			out.println(buckets[i]);
		}
		
		in.close();
		out.close();
	}
}
