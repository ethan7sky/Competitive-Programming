import java.util.Map.Entry;
import java.util.*;
import java.io.*;

public class USACOTriangles_2 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n;
	static point[] points;
	static HashMap<Integer, ArrayList<Integer>> xLines, yLines;
	static long ans;
	static int[][][] distAns = new int[20002][20002][2];
	static int MOD = (int)Math.pow(10, 9)+7;
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("TEST");
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		points = new point[n];
		xLines = new HashMap<Integer, ArrayList<Integer>>();
		yLines = new HashMap<Integer, ArrayList<Integer>>();
		
		System.out.println(n);
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			points[i] = new point(Integer.parseInt(st.nextToken())+10000, Integer.parseInt(st.nextToken())+10000);
			if(!yLines.containsKey(points[i].y)) yLines.put(points[i].y, new ArrayList<Integer>());
			yLines.get(points[i].y).add(points[i].x);
			if(!xLines.containsKey(points[i].x)) xLines.put(points[i].x, new ArrayList<Integer>());
			xLines.get(points[i].x).add(points[i].y);
		}
		System.out.println("got input");
		

		for(int yVal: yLines.keySet()) {
			
			ArrayList<Integer> temp = yLines.get(yVal);
			Collections.sort(yLines.get(yVal));
			int size = temp.size();
			
			int[] curr = new int[size];
			int sum=0;
			int first = temp.get(0);
			for(int i=0; i<size; i++) {
				curr[i] = temp.get(i);
				sum += curr[i]-first;
			}
			
			int[] diff = new int[size];
			for(int i=1; i<size; i++) {
				diff[i] = curr[i]-curr[i-1];
			}
			
			distAns[curr[0]][yVal][0] = sum;
			for(int i=1; i<size; i++) {
				sum += diff[i]*(-(size-i-1)+i);
				distAns[curr[i]][yVal][0] = sum;
			}
		}
		for(int xVal: xLines.keySet()) {
			
			ArrayList<Integer> temp = xLines.get(xVal);
			Collections.sort(xLines.get(xVal));
			int size = temp.size();
			
			int[] curr = new int[size];
			int sum=0;
			int first = temp.get(0);
			for(int i=0; i<size; i++) {
				curr[i] = temp.get(i);
				sum += curr[i]-first;
			}
			
			int[] diff = new int[size];
			for(int i=1; i<size; i++) {
				diff[i] = curr[i]-curr[i-1];
			}
			
			distAns[xVal][curr[0]][1] = sum;
			for(int i=1; i<size; i++) {
				sum += diff[i]*(-(size-i-1)+i);
				distAns[xVal][curr[i]][1] = sum;
			}
		}
		ans=0;
		
		for(point i: points) {
			ans += distAns[i.x][i.y][0]*distAns[i.x][i.y][1];
			ans %= MOD;
		}
		System.out.println(ans);
		
		in.close();
		
	}
	static class point {
		int x, y;
		public point(int a, int b) {
			this.x = a;
			this.y = b;
		}
	}
	
}
