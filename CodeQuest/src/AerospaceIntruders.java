import java.util.*;
import java.io.*;

public class AerospaceIntruders {
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		while(t-->0) {
			
			int n = in.nextInt();
			invaders[] a = new invaders[n];
			
			for(int i=0; i<n; i++) {
				String s = in.next();
				int idx1 = s.indexOf(":");
				int idx2 = s.indexOf(",");
				a[i] = new invaders(s.substring(0,idx1),
						Integer.parseInt(s.substring(idx1+1,idx2)), 
						Integer.parseInt(s.substring(idx2+1)),
						false);
			}
			for(int i=0; i<n; i++) {
				Arrays.sort(a);
				System.out.println("Destroyed Ship: "+a[0].s.substring(0,a[0].s.indexOf("_"))+" xLoc: "+a[0].x);
				a[0].s += "Z";
				a[0].x = Integer.MAX_VALUE;

				for(int j=0; j<n; j++) {
					char type = a[j].s.charAt(a[j].s.length()-1);
					if(type=='Z') continue;
					if(type=='A') {
						a[j].x -= 10;
					}
					else if(type=='B') {
						a[j].x -= 20;
					}
					else a[j].x -= 30;
				}
			}
			
			
		}
		
	}
	static class invaders implements Comparable<invaders> {
		
		String s;
		int x, y;
		invaders(String a, int b, int c, boolean d){
			s = a;
			x = b;
			y = c;
		}
		
		public String toString() {
			return s+" "+x+" "+y;
		}
		
		@Override
		public int compareTo(AerospaceIntruders.invaders o) {
			// TODO Auto-generated method stub
			if(this.x == o.x) {
				return o.y-this.y;
			}
			return this.x-o.x;
		}
		
	}
}
