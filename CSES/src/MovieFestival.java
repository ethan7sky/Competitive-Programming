import java.util.*;
import java.io.*;

public class MovieFestival {
	
	static BufferedReader in;
	static StringTokenizer st;
	static movie[] movies;
	static int n;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		movies = new movie[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			movies[i] = new movie(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(movies);
		//System.out.println(Arrays.toString(movies));
		
		int last = 0;
		int ans = 0;
		for(int i=0; i<n; i++) {
			if(movies[i].s >= last) {
				ans++;
				last = movies[i].e;
			}
		}
		System.out.println(ans);
		
	}
	
	
	static class movie implements Comparable<movie> {
		
		int s, e;
		movie(int a, int b) {
			this.s = a;
			this.e = b;
		}
		
		public String toString() {
			return s+" "+e;
		}
		
		@Override
		public int compareTo(MovieFestival.movie o) {
			return this.e-o.e;
		}
	}
	
}
