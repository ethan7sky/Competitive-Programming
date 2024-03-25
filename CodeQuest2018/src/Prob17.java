import java.util.*;
import java.io.*;

public class Prob17 {

    static String file = "17";    //local    
    static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t;
    static char[] s;
    static String line;
    
    public static void main(String[] args)throws IOException{        
        
        //in = new Scanner(new File(file+".in"));            //local
        //out = new PrintWriter(new File("out.txt"));        //local        
        in = new Scanner(System.in);                    //submit
        
        int t = in.nextInt();
        
        while(t-->0) {
            init();
            solve();
        }
        
        in.close();        
        //out.close(); //local
        
        //Check.check("out.txt", file+".out");    //local
    }
    
    
    static void init() {        
    	
    	line = in.next();
        s = line.toCharArray();
    }
    
    static void solve() {
        
    	char curr = 'O';
    	if( (s[0]==curr && s[3]==curr && s[6]==curr) 
    		|| (s[1]==curr && s[4]==curr && s[7]==curr)
    		|| (s[2]==curr && s[5]==curr && s[8]==curr)
    		|| (s[0]==curr && s[1]==curr && s[2]==curr)
    		|| (s[3]==curr && s[4]==curr && s[5]==curr)
    		|| (s[6]==curr && s[7]==curr && s[8]==curr)
    		|| (s[0]==curr && s[4]==curr && s[8]==curr)
    		|| (s[6]==curr && s[4]==curr && s[2]==curr)){
    		System.out.println(line+" = O WINS");
    		return;
    	}
    	curr='X';
    	if( (s[0]==curr && s[3]==curr && s[6]==curr) 
        		|| (s[1]==curr && s[4]==curr && s[7]==curr)
        		|| (s[2]==curr && s[5]==curr && s[8]==curr)
        		|| (s[0]==curr && s[1]==curr && s[2]==curr)
        		|| (s[3]==curr && s[4]==curr && s[5]==curr)
        		|| (s[6]==curr && s[7]==curr && s[8]==curr)
        		|| (s[0]==curr && s[4]==curr && s[8]==curr)
        		|| (s[6]==curr && s[4]==curr && s[2]==curr)){
        		System.out.println(line+" = X WINS");
        		return;
        }
    	else {
    		System.out.println(line+" = TIE");
    	}
    	
    }
}