import java.util.*;
import java.io.*;

public class CampContestG {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = in.nextInt();
		int k = in.nextInt();
		
		int left = Math.max(1, p-k);
		int right = Math.min(n, p+k);
		
		String ans = "";
		if(left!=1) ans += "<< ";
		for(int i=left; i<p; i++) {
			ans += i+" ";
		}
		ans += "("+p+") ";
		for(int i=p+1; i<=right; i++) {
			ans += i+" ";
		}
		if(right!=n) ans += ">>";
		System.out.println(ans);
	}
}
