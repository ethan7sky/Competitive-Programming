import java.util.*;
import java.io.*;

public class CF1805F1 {
	
	static int n;
	static long[] a;
	static long[] b;
	static int len;
	static long ans;
	static final int M = (int) (1e9+7);
	
	static void subMin() {
		ans = (ans+b[0]*pow(2, len-1)) % M;
		for(long i: b) --i;
	}
	
	static int pow(int a, int b) {
		int res = 1;
		while(b>)
	}
}
