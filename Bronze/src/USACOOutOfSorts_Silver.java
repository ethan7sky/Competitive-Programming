import java.util.*;
import java.io.*;

public class USACOOutOfSorts_Silver {
	
	static Scanner in;
	static PrintWriter out;
	static int n, a[];
	static HashMap<Integer, String> index;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		in = new Scanner(System.in); 
		//in = new Scanner(new FileReader("sort.in"));
		//out = new PrintWriter("sort.out");
		
		n = in.nextInt();
		
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = in.nextInt();
		int min = a[n-1];
		int cnt=0;
		for(int i=n-1; i>=0; i--) {
			if(a[i]>min) cnt++;
			min = Math.min(a[i], min);
		}
		System.out.println(cnt+1);
		
		
		
		/*
		index = new HashMap<Integer, String>();
		a = new int[n];
		
		for(int i=0; i<n; i++) {
			int num = in.nextInt();
			if(index.containsKey(num)) index.put(num, index.get(num)+" "+i);
			else index.put(num, i+"");
			a[i] = num;
		}
		
		Arrays.sort(a);
		
		int max = 0;
		for(int i=0; i<n; i++) {
			String[] distances = index.get(a[i]).split(" ");
			int temp = Integer.MAX_VALUE;
			for(int j=0; j<distances.length; j++) {
				temp = Math.min(temp, Math.abs(i-Integer.parseInt(distances[j])));
			}
			max = Math.max(max, temp);
		}
		out.println(max/2);
				
		
		*/
		in.close();
		out.close();
	}
}
