import java.util.*;
import java.io.*;

public class AreWeOnABudget {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); in.nextLine();
		while(t-->0) {
			int x = in.nextInt(); in.nextLine();
			StringTokenizer st = new StringTokenizer(in.nextLine());
			double[] prev = new double[x];
			for(int i=0; i<x; i++) {
				prev[i] = Double.parseDouble(st.nextToken());
			}
			st = new StringTokenizer(in.nextLine());
			double[] vals = new double[x];
			for(int i=0; i<x; i++) {
				vals[i] = Double.parseDouble(st.nextToken());
			}
			double sum = 0;
			for(int i=0; i<x; i++) {
				sum += vals[i]-prev[i];
			}
			sum /= x;
			String ans = String.format("%.2f", sum);
			System.out.println(ans);
		}
	}
}
