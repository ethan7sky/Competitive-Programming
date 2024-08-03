import java.util.*;
import java.io.*;

public class CampContestF {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while(t-->0) {
			int n = in.nextInt();
			int p = in.nextInt();
			int cnt=1;
			
			print:
			for(int i=1; i<=n; i++) {
				for(int j=i+1; j<=n; j++) {
					if(cnt>2*n+p) break print;
					sb.append(i).append(" ").append(j).append("\n");
					cnt++;
				}
			}
		}
		System.out.print(sb);
	}
	
}
