import java.util.*;
import java.io.*;

public class CampContestD2 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		int minStart=0;
		int changeCnt=Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}
		for(int i=1; i<=1000; i++) {
			int sum = 0;
			int height = i;
			for(int j=0; j<n; j++) {
				if(height-a[j]!=0) sum++;
				height += k;
			}
			if(sum<changeCnt) {
				minStart = i;
				changeCnt = sum;
			}
		}
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int diff = minStart-a[i];
			if(diff==0) {
				minStart+=k;
				continue;
			}
			if(diff>0) {
				sb.append("+ ").append(i+1).append(" ").append(diff).append("\n");
			}
			else {
				sb.append("- ").append(i+1).append(" ").append(-diff).append("\n");
			}
			cnt++;
			minStart += k;
		}
		System.out.println(cnt);
		if(cnt>0) {
			System.out.print(sb);
		}
	}
}
