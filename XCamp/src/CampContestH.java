import java.util.*;
import java.io.*;

public class CampContestH {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char[] c = in.next().toCharArray();
		Stack<Character> stack = new Stack<Character>();
		int blueCnt = 0;
		for(int i=n-1; i>=0; i--) {
			stack.add(c[i]);
			if(c[i]=='B') blueCnt++;
		}
		
		int ans = 0;
		while(blueCnt>0) {
			if(stack.peek()=='R') {
				while(stack.peek()=='R') {
					stack.pop();
				}
				stack.pop();
				blueCnt--;
				stack.add('R');
				while(stack.size()!=n) {
					stack.add('B');
					blueCnt++;
				}
				ans++;
			}
			else {
				stack.pop();
				stack.add('R');
				blueCnt--;
				ans++;
			}
		}
		System.out.println(ans);
	}
}
