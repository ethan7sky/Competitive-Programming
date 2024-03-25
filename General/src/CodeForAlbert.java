import java.util.*;
import java.io.*;

public class CodeForAlbert {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		Random rand = new Random();
		int gamecnt=0;
		ArrayList<Integer> guesses = new ArrayList<Integer>();
		
		while(true) {
			
			int ans = rand.nextInt(101);
			int guesscnt=0;
			
			System.out.println("I'm thinking of a number between 1 and 100...");
			
			int guess = -1;
			while(guess != ans) {
				System.out.println("Your guess?");
				guess = in.nextInt();
				if(guess>ans) System.out.println("It's lower.");
				else if(guess<ans) System.out.println("It's higher.");
				guesscnt++;
			}
			System.out.println("You guessed it in "+guesscnt+" guesses!");
			
			guesses.add(guesscnt);
			gamecnt++;
			
			System.out.println("Do you want to play again?");
			if(in.next().toLowerCase().charAt(0) != 'y') break;
		}
	}
}
