import java.io.*;

public class CSES1069 {
	
	static int max;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		
		max = 0;
		
		int sum = 0;
		char cur = line.charAt(0);
		
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == cur) sum++;
			else {
				max = Math.max(sum,  max);
				cur = line.charAt(i);
				sum = 1;
			}
		}
		max = Math.max(sum, max);
		System.out.println(max);
	}
}
