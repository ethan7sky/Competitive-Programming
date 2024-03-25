import java.util.*;
import java.io.*;

public class Prob9 {

    static String file = "Prob09";    //local    
    static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t;
    static String s, key;
    
    public static void main(String[] args)throws IOException{        
        
        //in = new Scanner(new File(file+".in"));            //local
        //out = new PrintWriter(new File("out.txt"));        //local        
        in = new Scanner(System.in);                    //submit
        
        int t = in.nextInt(); in.nextLine();
        
        while(t-->0) {
            init();
            solve();
        }
        
        in.close();        
        //out.close(); //local
        
        //Check.check("out.txt", file+".out");    //local
    }
    
    
    static void init() {        
    	
    	s = in.nextLine();
    	key = in.nextLine();
        
    }
    
    static void solve() {
        
    	int curridx=0;
    	
    	String ans = "";
    	for(int i=0; i<s.length(); i++) {
    		
    		if(s.charAt(i)==' ') {
    			ans += " ";
    			continue;
    		}
    		
    		char curr = s.charAt(i);
    		char currkey = key.charAt(curridx);
    		
    		int toadd = curr-'A';
    		int newletter = (currkey+toadd);
    		if(newletter > 'Z') newletter -= 26;
    		
    		char res = (char) newletter;
    		ans += res;
    		
    		curridx = (curridx+1)%key.length();
    	}
    	System.out.println(ans);
    }
}