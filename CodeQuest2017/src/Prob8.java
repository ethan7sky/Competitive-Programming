import java.util.*;
import java.io.*;

public class Prob8 {

    static String file = "Prob08";    //local    
    static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t;
    static double dist, mph;
    
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
    
        dist = in.nextDouble();
        mph = in.nextDouble();
    
    }
    
    static void solve() {
        
    	dist *= 1000000;
    	
    	double hours = dist/mph;
    	
    	double daycnt = Math.floor(hours/24);
    	double hourcnt = Math.floor(hours%24);
    	double minutecnt = Math.floor((hours*60.0)%60);
    	double secondcnt = Math.round((hours*60.0*60.0)%60);
    	if(secondcnt==60.0) {
    		minutecnt++;
    		secondcnt=0.0;
    	}
    	System.out.println("Time to Mars: " + (int)daycnt+" days, "+(int)hourcnt+" hours, "+(int)minutecnt+" minutes, "+(int)secondcnt+" seconds");
    	
    }
}