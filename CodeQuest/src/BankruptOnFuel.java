import java.util.*;
import java.io.*;

public class BankruptOnFuel {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		while(t-->0) {
			
			int fuel = in.nextInt();
			int tanks = in.nextInt();
			
			String[] ans = new String[tanks];
			pair[] a = new pair[tanks];
			for(int i=0; i<tanks; i++) {
				a[i] = new pair(in.nextInt(), i);
			}
			Arrays.sort(a);
			
			int sum = 0;
			for(int i=0; i<tanks; i++) {
				if((a[i].capacity-sum) * (tanks-i) <= fuel) {
					fuel -= (a[i].capacity-sum)*(tanks-i);
					sum = a[i].capacity;
					ans[a[i].idx] = Integer.toString(sum);
				}
				else {
					int numerator = fuel;
					int denominator = tanks-i;
					numerator += sum*denominator;
					int gcd = gcd(numerator, denominator);
					String answer = (numerator/gcd + "/"+denominator/gcd);
					if(gcd==denominator) answer = Integer.toString(numerator/denominator);
					for(; i<tanks; i++) {
						ans[a[i].idx] = answer;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for(String s: ans) {
				sb.append(s).append(" ");
			}
			System.out.println(sb.substring(0,sb.length()-1));
		}
		
	}
	static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
	
	static class pair implements Comparable<pair>{
		
		int capacity, idx;
		pair(int a, int b){
			capacity = a;
			idx = b;
		}
		
		public String toString() {
			return capacity+" "+idx;
		}
		
		@Override
		public int compareTo(pair that) {
			return this.capacity-that.capacity;
		}
		
	}
	
}
