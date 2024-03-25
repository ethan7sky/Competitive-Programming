import java.util.*;
import java.io.*;

public class Prob10 {

    static String file = "Prob10";    //local    
    static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t, n;
    static String[] lines;
    static String original, translated;
    static HashMap<Character, Character> translate;
    
    public static void main(String[] args)throws IOException{        
        
        //in = new Scanner(new File(file+".in"));            //local
        //out = new PrintWriter(new File("out.txt"));        //local        
        in = new Scanner(System.in);                    //submit
        
        int t = in.nextInt();
        
        original =   "qwertyuiopasdfghjklzxcvbnm,.QWERTYUIOPASDFGHJKLZXCVBNM ";
        translated = "!qwertyuio@asdfghjk#zxcvbnm,!QWERTYUIO@ASDFGHJK#ZXCVBN ";
        translate = new HashMap<Character, Character>();
        for(int i=0; i<original.length(); i++) {
        	translate.put(original.charAt(i), translated.charAt(i));
        }
        
        while(t-->0) {
            init();
            solve();
        }
        
        in.close();        
        //out.close(); //local
        
        //Check.check("out.txt", file+".out");    //local
    }
    
    
    static void init() {        
    
        n = in.nextInt(); in.nextLine();
        
        lines = new String[n];
        
        for(int i=0; i<n; i++) {
            lines[i] = in.nextLine();
        }
    }
    
    static void solve() {
        
    	boolean capsLock = false; //turn on if 'A' or 'a'
    	
    	/*
    	 *  ! is equal to a tab
    	 *  @ is equal to a capslock
    	 *  # is equal to a shift
    	 */
    	
    	for(String line: lines) {
    		
    		String res = "";
    		for(int i=0; i<line.length(); i++) {
    			char curr = line.charAt(i);
    			char newletter = translate.get(curr);
    			
    			if(newletter=='!') {
    				res += "    ";
    				continue;
    			}
    			else if(newletter=='@') {
    				capsLock = !capsLock;
    				continue;
    			}
    			else if(newletter=='#') continue;
    			
    			if(capsLock) newletter = shift(newletter);
    			
    			res += newletter;
    		}
    		System.out.println(res);
    		
    	}
    	
    }
    static char shift(char c) {
    	if(c==',' || c=='.') return c;
    	else if(Character.isUpperCase(c)) return Character.toLowerCase(c);
    	return Character.toUpperCase(c);
    }
}