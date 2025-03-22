import java.util.*;
import java.io.*;

public class test {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int cnt=0;
		while(true) {
			line = in.readLine();
			if(line.equals("")) break;
			String[] temp = line.split(" ");
			if(temp.length==1) cnt++;
		}
		System.out.println(cnt);
	}
}
