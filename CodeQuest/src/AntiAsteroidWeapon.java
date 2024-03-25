import java.util.*;
import java.io.*;

public class AntiAsteroidWeapon {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		while(n-->0) {
			int m = in.nextInt();
			
			
			dist[] a = new dist[m];
			for(int i=0; i<m; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				double z = Math.sqrt(Math.pow(x,  2)+Math.pow(y,  2));
				a[i] = new dist(x, y, z);
				
			}
			Arrays.sort(a);
			
			for(int i=0; i<m; i++) {
				System.out.println(a[i].a+" "+a[i].b);
			}
			
			
//			int[][] a = new int[m][2];
//			for(int i=0; i<m; i++) {
//				a[i][0] = in.nextInt();
//				a[i][1] = in.nextInt();
//			}
//			double[][] dist = new double[m][2];
//			for(int i=0; i<m; i++) {
//				dist[i][0] = Math.sqrt(Math.pow(a[i][0], 2) + Math.pow(a[i][1],  2));
//				dist[i][1] = (double) i;
//			}
//			Arrays.sort(dist);
//			
//			for(int i=0; i<m; i++) {
//				int idx = (int) dist[i][1];
//				System.out.println(a[idx][0]+" "+a[idx][1]);
//			}
		}
	}
	static class dist implements Comparable<dist>{
		
		int a, b;
		double dist;
		dist(int x, int y, double z) {
			a = x;
			b = y;
			dist = z;
		}
		public String toString() {
			return (a+" "+b+" "+dist);
		}
		@Override
		public int compareTo(AntiAsteroidWeapon.dist o) {
			// TODO Auto-generated method stub
			if(this.dist<o.dist) {
				return -1;
			}
			else if(this.dist>o.dist) {
				return 1;
			}
			return 0;
		}
		
		
	}
}
