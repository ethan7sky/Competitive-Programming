import java.util.*;
import java.io.*;

public class D_UpAndDown {
	
	static int n, s, e, ans;
	static boolean v[];
	static boolean found;
	static Queue<cell> pos;
	static int[] c;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		pos = new LinkedList<cell>();
		n = in.nextInt();
		while(n != 0) {
			s = in.nextInt()-1;
			e = in.nextInt()-1;

			v = new boolean[n];
			c = new int[n];
			
			for(int i=0; i<n; i++) c[i] = in.nextInt();
			
			pos.clear();
			pos.add(new cell(s, 0));
			
			found = false; ans = -1;
			while(!found&&!pos.isEmpty()) {
				cell curr = pos.poll();
				search(curr.x, curr.len);
			}
			System.out.println(ans);
			
			n = in.nextInt();
		}
	}
	static void search(int x, int len) {
		if(x<0 || x>=n) return;
		if(v[x]) return;
		v[x] = true;
		if(x==e) {
			found = true;
			ans = len;
			return;
		}
		pos.add(new cell(x+c[x], len+1));
		pos.add(new cell(x-c[x], len+1));
	}
	static class cell {
		int x, len;
		public cell(int a, int b) {
			this.x = a;
			this.len = b;
		}
	}
}
