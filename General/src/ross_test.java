import java.util.*;

public class ross_test {
	
	static ArrayList<fraction> nums;
	static TreeSet<fraction> uniquenums;
	
	public static void main(String[] args) {
		
		nums = new ArrayList<fraction>();
		nums.add(new fraction(1, 1));
		
		int depth = 5;
		while(depth-->0) {
			int len = nums.size();
			for(int i=0; i<len; i++) {
				for(int j=i; j<len; j++) {
					fraction frac1 = nums.get(i);
					fraction frac2 = nums.get(j);
					
					fraction frac3 = frac1.add(frac2);
					nums.add(frac3);
				}
			}
		}
		uniquenums = new TreeSet<fraction>();
		for(fraction i: nums) uniquenums.add(i);
		System.out.println(uniquenums);
	}

	
	static class fraction implements Comparable<fraction> {
		
		int numerator, denominator;
		
		fraction(int a, int b){
			numerator = a;
			denominator = b;
		}
		
		public void simplify() {
			int gcd = gcd(this.numerator, this.denominator);
			this.numerator /= gcd;
			this.denominator /= gcd;
		}
		
		public fraction add(fraction that) {
			
			int newnumerator = this.numerator*that.denominator + that.numerator*this.denominator;
			int newdenominator = this.denominator*that.denominator;
			
			fraction res = new fraction(newdenominator, newnumerator);
			res.simplify();
			return res;
		}
		
		public String toString() {
			return this.numerator+"/"+this.denominator;
		}
		
		static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
		
		@Override
		public int compareTo(fraction o) {
			if(this.denominator != o.denominator)
				return this.denominator - o.denominator;
			return this.numerator-o.numerator;
		}
	}
	
	
}
