import java.util.*;
import java.io.*;
 
public class USACOdoyouknowyourABCs {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] a = new int[7];
		for(int i = 0; i < 7; i++) {
			a[i] = in.nextInt();
		}
		
		int max = 0;
		int max2 = 0;
		int max3 = 0;
		
		int index = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
				index = i;
			}
		}
		a[index] = 0;
		
		index = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > max2) {
				max2 = a[i];
				index = i;
			}
		}
		a[index] = 0;
		
		
		index = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > max3) {
				max3 = a[i];
				index = i;
			}
		}
		a[index] = 0;
		
		
		String res = "";
		res += max-max2+" ";
		res += max-max3+" ";
		res += max-((max-max2)+(max-max3));
		
		System.out.println(res);
		
	}
	
	
}
