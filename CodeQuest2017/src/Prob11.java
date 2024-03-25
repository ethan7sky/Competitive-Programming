import java.util.*;
import java.io.*;

public class Prob11 {

    static String file = "Prob11";    //local    
    static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t, n;
    static String line;
    static char[] letters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVNM".toCharArray();
    static HashSet<Character> alphabet;
    
    public static void main(String[] args)throws IOException{        
        
        //in = new Scanner(new File(file+".in"));            //local
        //out = new PrintWriter(new File("out.txt"));        //local        
        in = new Scanner(System.in);                    //submit
        
        int t = in.nextInt(); in.nextLine();
        
        alphabet = new HashSet<Character>();
        for(char c: letters) alphabet.add(c);
        
        while(t-->0) {
            init();
            solve();
        }
        
        in.close();        
        //out.close(); //local
        
        //Check.check("out.txt", file+".out");    //local
    }
    
    
    static void init() {        
	    
    	line = in.nextLine();
    }
    
    static void solve() {
        
    	StringTokenizer st = new StringTokenizer(line);
    	String ans = "";
    	while(st.hasMoreTokens()) {
    		String word = st.nextToken();
    		String reversed = reverse(word);
    		ans += reversed+" ";
    	}
    	System.out.println(ans.trim());
    }
    static String reverse(String word) {
    	
    	int s = 0;
    	int e = word.length()-1;
    	while(s<e) {
    		if(!alphabet.contains(word.charAt(e))){
    			e--;
    			continue;
    		}
    		if(!alphabet.contains(word.charAt(s))) {
    			s++;
    			continue;
    		}
    		
    		boolean firstIsUpper = Character.isUpperCase(word.charAt(s));
    		boolean secondIsUpper = Character.isUpperCase(word.charAt(e));
    		
    		char letter1 = word.charAt(s);
    		char letter2 = word.charAt(e);
    		
    		if(secondIsUpper) letter1 = Character.toUpperCase(letter1);
    		else letter1 = Character.toLowerCase(letter1);
    		if(firstIsUpper) letter2 = Character.toUpperCase(letter2);
    		else letter2 = Character.toLowerCase(letter2);
    		
    		word = word.substring(0,s)+letter2+word.substring(s+1,e)+letter1+word.substring(e+1);
    		s++;
    		e--;
    	}
    	return word;
    	
    }
}