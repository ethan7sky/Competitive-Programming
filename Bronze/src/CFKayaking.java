import java.util.*; import java.io.*;
public class CFKayaking {
	
	static Scanner in;
	static int n, min, a[];
	
	public static void main(String[] args) throws IOException{
		
		in = new Scanner(System.in);
		n = in.nextInt();
		
		a = new int[n*2];
		for(int i = 0; i < n*2; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n*2; i++) {
			for(int j = i+1; j < n*2; j++) {
				
				int instability = 0;

				int[] pairs = new int[n*2-2];
				int idx = 0;
				for(int k = 0; k < n*2; k++) {
					if(k!=i && k!=j) {
						pairs[idx] = a[k];
						idx++;
					}
				}
				
				for(int k = 0; k<n*2-2; k++) {
					instability += pairs[k+1]-pairs[k];
					k++;
				}
				min = Math.min(instability, min);
			}
		}
		System.out.println(min);
	}
}
