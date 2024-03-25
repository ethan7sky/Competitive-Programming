import java.util.*;
import java.io.*;

public class AnimalFarm {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); in.nextLine();
		while(n-->0) {
			System.out.println(in.nextInt()*2+in.nextInt()*4+in.nextInt()*4);
		}
	}
}
