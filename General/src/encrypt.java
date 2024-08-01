import java.util.*;
import java.io.*;

public class encrypt {
	static String msg;
	static int[] key;
	
	public static void main(String[] args) {
		System.out.println("message:");
		Scanner in = new Scanner(System.in);
		String message = in.nextLine();
		
		ArrayList<Integer> offSet = new ArrayList<Integer>();
		
		char[] characters = message.toCharArray();
		Random rand = new Random();
		
		for(int i=0; i<characters.length; i++) {
			char c = characters[i];
			int asciiVal = c;
			int diff = rand.nextInt(40);
			
			if(asciiVal>=73) {
				offSet.add(diff);
				asciiVal -= diff;
			}
			else {
				offSet.add(-diff);
				asciiVal += diff;
			}
			characters[i] = (char)asciiVal;
		}
		int[] offset = new int[offSet.size()];
		for(int i=0; i<offSet.size(); i++) {
			offset[i] = offSet.get(i);
		}
		System.out.println(Arrays.toString(characters));
		System.out.println(Arrays.toString(offset));
		
		decrypt(characters, offset);
	}
	
	static void decrypt(char[] a, int[] b) {
		
		char[] encoded = a.clone(); //copy over 3rd line in std
		int[] values = b.clone(); //copy over 4th line in std
		
		String res = "";
		for(int i=0; i<values.length; i++) {
			res += (char)(encoded[i]+values[i]);      
		}
		System.out.println(res);
	}
	static void msg() {
		//hi souffle :) i really hope this works! btw ily
	}
	
	//[b, c, +, q, g, d, `, F, b, D, :, P, :, ,, K, ', k, b, T, P, Z, f, G, e, Y, m, Y, -, o, ^, M, Y, /, r, Z, n, V, p, 5, ,, L, _, [, 4, M, H, U]
	//[6, 6, -11, 2, 8, 17, 6, 32, 10, 33, -26, -22, -17, -12, 30, -7, 7, 3, 13, 28, 18, 19, -39, 3, 22, 3, 12, -13, 5, 10, 28, 26, -15, 5, 21, 4, 21, 3, -20, -12, 22, 21, 28, -20, 28, 36, 36]

			
}
