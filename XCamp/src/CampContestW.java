import java.util.*;
import java.io.*;

public class CampContestW {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static String s;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		sieve((int)1e6);
		
		int x = Integer.parseInt(in.readLine());
		for(int i=1; i<x; i++) {
			if(!prime[i] && !prime[x-i]) {
				System.out.println(i+" "+(x-i));
				return;
			}
		}
	}
	static boolean[] prime = new boolean[(int)1e6+1];
	static void sieve(int n)
    {
        for(int i=0;i<=n;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=n; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
         
        
    }
}
