import java.util.*;
import java.io.*;

public class Prob14 {

    static String file = "Prob14";    //local    
    static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t, n;
    static HashMap<String, String> tree;
    
    public static void main(String[] args)throws IOException{        
        
        in = new Scanner(new File(file+".in"));            //local
        out = new PrintWriter(new File("out.txt"));        //local        
        //in = new Scanner(System.in);                    //submit
        
        int t = in.nextInt(); in.nextLine();
        
        tree = new HashMap<String, String>();
        while(t-->0) {
            init();
        }
        solve();
        
        in.close();        
        //out.close(); //local
        
        //Check.check("out.txt", file+".out");    //local
    }
    
    
    static void init() {        
    
        String[] input = in.nextLine().split(",");
        
        
    }
    
    static void solve() {
        
    }
}