import java.util.*;

public class CFWhiteSheet2 {
	
	static Scanner in;
	static point a,b,c;
	static long area, overlap;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		a = new point(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		b = new point(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		c = new point(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
	}
	
	static void solve() {
		
		area = (a.x2-a.x1) * (a.y2-a.y1);
		overlap = ol(a, b) + ol(a, c) - ol(a, b, c);
		
		if(overlap<area) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
	}
	
	static long ol(point a, point b) {
		
		long lx = Math.max(a.x1, b.x1);
		long rx = Math.min(a.x2, b.x2);
		long by = Math.max(a.y1, b.y1);
		long ty = Math.min(a.y2, b.y2);
		
		if(lx>rx || by>ty) {
			return 0;
		}
		return (rx-lx) * (ty-by);
	}
	
	static long ol(point a, point b, point c) {
		
		
		long lx = Math.max(Math.max(a.x1, b.x1), c.x1);
		long rx = Math.min(Math.min(a.x2, b.x2), c.x2);
		long by = Math.max(Math.max(a.y1, b.y1), c.y1);
		long ty = Math.min(Math.min(a.y2, b.y2), c.y2);
		
		if(lx>rx || by>ty) {
			return 0;
		}
		return (rx-lx) * (ty-by);
	}
	
	static class point{
		long x1, y1, x2, y2;
		point(long a, long b, long c, long d){
			x1 = a;
			y1 = b;
			x2 = c;
			y2 = d;
		}
		
		public String toString() {
			return x1+" "+y1+" "+x2+" "+y2;
		}
	}
}
