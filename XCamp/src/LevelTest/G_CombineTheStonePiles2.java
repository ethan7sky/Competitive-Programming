package LevelTest;
import java.util.*;
import java.io.*;

public class G_CombineTheStonePiles2 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n;
	static ArrayList<Integer> a;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader((System.in)));
		
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		a = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		
		long ans = 0;
		while(a.size() > 1) {
			int cidx = -1;
			int minWeight = Integer.MAX_VALUE;
			for(int i=0; i<a.size()-1; i++) {
				if(a.get(i)+a.get(i+1)<minWeight) {
					minWeight = a.get(i)+a.get(i+1);
					cidx = i;
				}
			}
			int circSum = a.get(0)+a.get(a.size()-1);
			if(circSum<minWeight) {
				a.remove(0);
				a.remove(a.size()-1);
				a.add(0, circSum);
				ans += circSum;
			}
			else {
				a.remove(cidx);
				a.remove(cidx);
				a.add(cidx, minWeight);
				ans += minWeight;
			}
			System.out.println(a);
			System.out.println(ans);
		}
		System.out.println(ans);
	}
	
}
