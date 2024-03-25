import java.util.*;
import java.io.*;

public class ProbB {

    static String file = "1";    //local    
    static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t, n;
    static double a, b;
    
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
    
        String[] s = in.nextLine().split(":");
        a = Double.parseDouble(s[0]);
        b = Double.parseDouble(s[1]);
        
    }
    
    static void solve() {
        
    	if(a>=b) System.out.println("SWERVE");
    	else if(a*5>=b) System.out.println("BRAKE");
    	else System.out.println("SAFE");
    	
    }
}