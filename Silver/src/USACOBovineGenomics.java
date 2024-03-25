import java.util.*;
import java.io.*;

public class USACOBovineGenomics {
	
	static int n, m;
	static char a[][];
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static HashSet<String> spot, plain;
	
	public static void main(String[] args) throws IOException {
		
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("cownomics.in"));
		out = new PrintWriter("cownomics.out");
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new char[n*2][];
		for(int i=0; i<n*2; i++) {
			a[i] = in.readLine().toCharArray();
		}
		
		int ans = 0;
		
		for(int i=0; i<m; i++) {
			for(int j=i+1; j<m; j++) {
				searching:
				for(int k=j+1; k<m; k++) {
					
					spot = new HashSet<String>();
					plain = new HashSet<String>();
					
					for(int cow=0; cow<n*2; cow++) {
						
						String s = Character.toString(a[cow][i])
								+Character.toString(a[cow][j])
								+Character.toString(a[cow][k]);
						
						if(cow<n) {
							if(plain.contains(s)) continue searching;
							spot.add(s);
						}
						else {
							if(spot.contains(s)) continue searching;
							plain.add(s);
						}
						
					}
					ans++;
				}
			}
		}
		
		out.println(ans);
		
		in.close();
		out.close();
		
	}
	
}
