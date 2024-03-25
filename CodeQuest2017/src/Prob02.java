import java.util.*;
import java.io.*;

public class Prob02 {

    static String file = "Prob02";    //local    
    static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t, n;
    
    public static void main(String[] args)throws IOException{        
        
        in = new Scanner(new File(file+".in"));            //local
        out = new PrintWriter(new File("out.txt"));        //local        
        //in = new Scanner(System.in);                    //submit
        
        int t = in.nextInt(); in.nextLine();
        
        while(t-->0) {
            init();
            solve();
        }
        
        in.close();        
        out.close(); //local
        
        Check.check("out.txt", file+".out");    //local
    }
    
    
    static void init() {        
    
        n = in.nextInt(); in.nextLine();
        
        for(int i=0; i<n; i++) {
            
        }
    }
    
    static void solve() {
        
    }
}