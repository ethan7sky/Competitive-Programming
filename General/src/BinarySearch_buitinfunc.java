import java.util.*;
import java.io.*;

public class BinarySearch_buitinfunc {
	
	public static void main(String[] args) {
		
		int[] a = {1, 3, 4, 10, 19};
		Arrays.sort(a);
		
		System.out.println(Arrays.toString(a));
		
		int n = Arrays.binarySearch(a, 10);
		System.out.println(n);
		
		n = Arrays.binarySearch(a, 1);
		System.out.println(n);
		
		n = Arrays.binarySearch(a, 11);
		System.out.println(n);
		
		System.out.println(Arrays.binarySearch(a, 2));
		
		int lower = Math.abs(n)-2;
		int upper = Math.abs(n)-1;
		
		System.out.println(a[lower]+" "+a[upper]);
		
		//repeating values
		int[] b = {1, 10, 10, 10, 10, 10, 10, 19};
		Arrays.sort(b);
		
		System.out.println(Arrays.toString(b));
		
		n = Arrays.binarySearch(a, 10);
		System.out.println(n);
		
		n = Arrays.binarySearch(a, 11);
		System.out.println(n);
		
		//using map
		int[] c = {1, 3, 4, 10, 10, 19};
		
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		
		
		tm.put(1, 0);
		tm.put(3, 1);
		tm.put(4, 2);
		tm.put(10, 3);
		tm.put(19, 5);
		
		lower = tm.lowerKey(11);
		System.out.println(lower);
		System.out.println(tm.get(lower));
		
		upper = tm.higherKey(11);
		System.out.println(upper);
		System.out.println(tm.get(upper));
		
		System.out.println(tm.lowerKey(1));
	}
}
