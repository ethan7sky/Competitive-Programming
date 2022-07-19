import java.util.*; import java.io.*;
public class USACOTheBovineShuffle {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringBuilder sb;
	
	public static void main(String[] args)throws IOException {
		
		in = new BufferedReader(new FileReader("shuffle.in"));
		out = new PrintWriter(new File ("shuffle.out"));
		//in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		

		int n = Integer.valueOf(in.readLine());
		
		String[] a = new String[n];
		String[] a2 = new String[n];
		
		String order = in.readLine();
		StringTokenizer ids = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < n; i++) {
			a[i] = ids.nextToken();
		}
		
		
		for(int j = 0; j < 3; j++) {
			
			StringTokenizer st = new StringTokenizer(order);
			
			for(int i = 0; i < n; i++) {
				a2[i] = a[Integer.valueOf(st.nextToken())-1];
			}
			a = a2;
			a2 = new String[n];
			
		}
		for(int i = 0; i < n; i++) {
			sb.append(a[i]);
			sb.append("\n");
		}
		
		
		out.println(sb.toString().substring(0, sb.length()-1));
		
		in.close();
		out.close();
		
		
	}
}
