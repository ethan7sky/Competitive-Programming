import java.util.*; import java.io.*;
 
public class USACOfencepainting {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("paint.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("paint.out"));
		boolean[] fence = new boolean[101];
		
		int a = in.nextInt();
		int b = in.nextInt();
		for(int i = a; i < b; i++) {
			fence[i] = true;
		}
		
		int c = in.nextInt();
		int d = in.nextInt();
		for(int i = c; i < d; i++) {
			fence[i] = true;
		}
		
		int res= 0;
		for(int i = 0; i < fence.length; i++) {
			if(fence[i]) res++;
		}
		
		pw.print(res);
		pw.close();
	}
}
