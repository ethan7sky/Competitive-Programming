import java.util.*;
import java.io.*;

public class Pareidolia {
 //abcdefghssijebessie

    public static void main(String[] args) throws IOException {
    	
		
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String string = in.readLine();
        long answer = 0;
        long[] waiting = new long[7];
        long rem = string.length();
        for (char letter : string.toCharArray()) {
            waiting[0]++;
            for (int d = 5; d >= 0; d--) {
                if (letter == "bessie".charAt(d)) {
                    waiting[d + 1] += waiting[d];
                    waiting[d] = 0;
                }
            }
            System.out.println(letter);
            System.out.println(Arrays.toString(waiting));
            answer += waiting[6] * rem;
            waiting[0] += waiting[6];
            waiting[6] = 0;
            rem--;
            System.out.println(Arrays.toString(waiting));
            System.out.println(answer);
        }
        System.out.println(answer);
    }
}