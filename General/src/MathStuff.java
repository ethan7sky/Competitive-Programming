import java.util.*;
import java.io.*;

public class MathStuff {
	
	public static void main(String[] args) {
		System.out.println(gcd(100001, 101101));
	}
	
	
	//gcd
	static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
	
	
	//prime numbers
	public static List<Integer> sieveOfEratosthenes(int n) {
	    boolean prime[] = new boolean[n + 1];
	    Arrays.fill(prime, true);
	    for (int p = 2; p * p <= n; p++) {
	        if (prime[p]) {
	            for (int i = p * 2; i <= n; i += p) {
	                prime[i] = false;
	            }
	        }
	    }
	    List<Integer> primeNumbers = new LinkedList<>();
	    for (int i = 2; i <= n; i++) {
	        if (prime[i]) {
	            primeNumbers.add(i);
	        }
	    }
	    return primeNumbers;
	}
	
	static int MOD = (int)1e9+7;
	
	//mod inverse
	static long modInverse(long a) {
		long m = MOD;
		long y = 0, x = 1;
		
		long q, t;
		while(a>1) {
			q = a/m;
			t = m;
			m = a%m;
			a=t;
			t=y;
			
			y = x-q*y;
			x=t;
		}
		if(x<0) x += MOD;
		
		return x;
	}
}
