import java.util.*;
import java.io.*;

public class Prob16 {

    static String file = "Prob16";    //local    
    static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t;
    static int x, y, p, r1, r2;
    
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
    	
    	x = in.nextInt();
    	y = in.nextInt();
    	p = in.nextInt();
    	r1 = in.nextInt();
    	r2 = in.nextInt();
        
    }
    
    static void solve() {
    	
    	double angle = Math.toRadians(90);
    	double offset = Math.toRadians(360.0/(p*2));
    	boolean outer = true;
        
    	for(int i=0; i<2*p; i++) {
    		
    		int radius = r2;
    		if(outer) radius = r1;
    		outer = !outer;
    		
    		double cx = x+Math.cos(angle)*radius;
    		double cy = y+Math.sin(angle)*radius;
    		
    		String rx = String.format("%.2f", cx);
    		String ry = String.format("%.2f", cy);
    		
    		if(rx.equals("-0.00")) rx="0.00";
    		if(ry.equals("-0.00")) ry="0.00";
    		
    		System.out.print(rx+","+ry);
    		if(i!=2*p-1) System.out.print(" ");
    		else System.out.println();
    		angle += offset;
    		
    	}
    	
    }
}