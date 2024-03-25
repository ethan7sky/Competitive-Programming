import java.util.*;
import java.io.*;

public class Prob12 {

    static String file = "Prob12";    //local    
    static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t;
    static double balancesum;
    static double metasum;
    static int days, periods;
    static double ANNUAL_INTEREST_RATE = 0.18;
    
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
    
        days = in.nextInt(); in.nextLine();
        //periods = (int)Math.floor(365/days);
        periods=12;
        metasum = 0.0;
        balancesum = 0.0;
        
        //System.out.println(periods);
    }
    
    static void solve() {
        
    	for(int i=0; i<days; i++) {
    		String input = in.nextLine();
    		if(input.endsWith(",,")) {
    			metasum += balancesum;
    			continue;        	
    		}
        	String[] split = input.split(",");
        	if(split[1] != "")
        		balancesum += Double.parseDouble(split[1]);
        	if(split.length==3) {
        		balancesum -= Double.parseDouble(split[2]);
        	}
        	metasum += balancesum;
    	}
    	
    	Double ans = (metasum/days)*(ANNUAL_INTEREST_RATE/periods);
    	ans = Math.round(ans*100)/100.0;
    	System.out.printf("$%.2f\n", ans);
    }
}