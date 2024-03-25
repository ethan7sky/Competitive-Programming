import java.util.*;
import java.io.*;

public class Prob15 {

    static String file = "Prob15";    //local    
    static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t;
    static String s;
    
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
    
        s = in.next();
    }
    
    static void solve() {
    	
    	String ans="";
    	for(int i=0; i<s.length(); i++) {
    		
    		char curr = s.charAt(i);
    		
    		int val = curr-'A'+1;
    		
    		if(curr<='E') {
    			val += 6;
    		}
    		else if(curr <= 'J') {
    			val = (int)Math.pow(val, 2);
    		}
    		else if(curr <= 'O') {
    			val = (val%3)*5+1;
    		}
    		else if(curr <= 'T') {
    			val = ((val/10)+val%10)*8;
    		}
    		else if(curr <= 'Z') {
    			val = largestfactor(val)*2;
    		}
    		val = val%26;
    		
    		if(val==0) ans += curr;
    		else {
        		val += 'A'-1;
    			ans += Character.toString((char)val);
    		}
    	}
    	System.out.println(ans);
        
    }
    static int largestfactor(int i) {
    	
    	for(int f=i/2; f>=1; f--) {
    		if(i%f==0) return f;
    	}
    	return 1;
    	
    }
}