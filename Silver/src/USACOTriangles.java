import java.util.*;
import java.util.Map.Entry;
import java.util.*;
import java.io.*;

public class USACOTriangles {
	
	//to find sum of possible lengths parallel to an axis,
	// find sum of lengths on either side, suml and sumr
	// find number of points on either side, cntl and cntr
	// sum1*(cntr+1) + sumr + sum2*(cntl+1) + suml;
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n;
	static int[][] pairs;
	static HashMap<Integer, ArrayList<Integer>> xlist, ylist;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader("triangles.in"));
		//out = new PrintWriter("triangles.out");
		n = Integer.parseInt(in.readLine());
		
		pairs = new int[n][2];
		xlist = new HashMap<Integer, ArrayList<Integer>>();
		ylist = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			pairs[i][0] = Integer.parseInt(st.nextToken());
			pairs[i][1] = Integer.parseInt(st.nextToken());
			if(!xlist.containsKey(pairs[i][0])) 
				xlist.put(pairs[i][0], new ArrayList<Integer>());
			if(!ylist.containsKey(pairs[i][1])) 
				ylist.put(pairs[i][1], new ArrayList<Integer>());
			xlist.get(pairs[i][0]).add(pairs[i][1]);
			ylist.get(pairs[i][1]).add(pairs[i][0]);
		}
		
		for(Entry<Integer, ArrayList<Integer>> i: xlist.entrySet()) {
			System.out.println(i.getKey()+" "+i.getValue());
		}
		for(Entry<Integer, ArrayList<Integer>> i: ylist.entrySet()) {
			System.out.println(i.getKey()+" "+i.getValue());
		}
		
		
		
		
		long sum = 0;
		long mod = (long)Math.pow(10, 9)+7;
		for(int i=0; i<n; i++) {
			int currx = pairs[i][0];
			int curry = pairs[i][1];
			
			int xlcnt=0;
			int xlsum=0;
			int xrcnt=0;
			int xrsum=0;
			int ylcnt=0;
			int ylsum=0;
			int yucnt=0;
			int yusum=0;
			
			for(int y: xlist.get(currx)) {
				if(y==curry) continue;
				if(y<curry) {
					ylcnt++;
					ylsum += curry-y;
				}
				else {
					yucnt++;
					yusum += y-curry;
				}
			}
			for(int x: ylist.get(curry)) {
				if(x==currx) continue;
				if(x<currx) {
					xlcnt++;
					xlsum += currx-x;
				}
				else {
					xrcnt++;
					xrsum += x-curry;
				}
			}
//			System.out.println("CURRENT = "+currx+", "+curry);
//			System.out.println(xlcnt+" "+xlsum+" "+xrcnt+" "+xrsum);
//			System.out.println(ylcnt+" "+ylsum+" "+yucnt+" "+yusum);
//			
			
			long xans = xlsum*(xrcnt+1) + xrsum*(xlcnt+1);
			long yans = ylsum*(yucnt+1) + yusum*(ylcnt+1);
			long ans = xans*yans;
			ans %= mod;
			sum += ans;
			sum %= mod;
		}
		System.out.println(sum);
		
		//in.close();
		//out.close();
		
		
	}
	
}
