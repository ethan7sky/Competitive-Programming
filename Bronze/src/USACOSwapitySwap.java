import java.util.*;
import java.io.*;

public class USACOSwapitySwap {
	
	static Scanner in;
	static int n, k, a1, a2, b1, b2;
	static ArrayList<int[]> combos;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		//in = new Scanner(System.in);
		in = new Scanner(new FileReader("swap.in"));
		out = new PrintWriter("swap.out");
		
		n=in.nextInt();
		k=in.nextInt();
		a1=in.nextInt()-1;
		a2=in.nextInt()-1;
		b1=in.nextInt()-1;
		b2=in.nextInt()-1;
		
		int[] order = new int[n];
		for(int i=0; i<n; i++) order[i]=i+1;
		int[] start = order.clone();
		
		combos = new ArrayList<int[]>();
		combos.add(order);
				
		
		while(true) {
			reverse(order, a1, a2);
			reverse(order, b1, b2);
			if(Arrays.equals(order, start))break;
			else {
				int[] temp = order.clone();
				combos.add(temp);
			}
		}
		
		int[] ans = combos.get(k%combos.size());
		for(int i=0; i<n; i++) out.println(ans[i]);
		
		in.close();
		out.close();
	}
	
	static void reverse(int[] order, int s, int e) {
		
		while(s<e) {
			int temp = order[s];
			order[s] = order[e];
			order[e] = temp;
			
			s++;
			e--;
		}
	}
}
