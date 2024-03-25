import java.util.*;
import java.io.*;

public class Prob13 {

    static String file = "Prob13";    //local    
    static PrintWriter out;        //local    
    static Scanner in;            //submit
    static int t, n;
    static final double TARGET_FRAME_TIME = (double)1000/90;
	static final double LOW_THRESHOLD = TARGET_FRAME_TIME*0.7,
			EXTRAPOLATE_THRESHOLD = TARGET_FRAME_TIME*0.85,
			HIGH_THRESHOLD = TARGET_FRAME_TIME*0.9;
	static double f1, f2, f3;
	static int q;
    
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
    
    	f1 = in.nextDouble();
		f2 = in.nextDouble();
		f3 = in.nextDouble();
		q = in.nextInt();
    }
    
    static void solve() {

		if(f3>HIGH_THRESHOLD) q-=2;
		else if(f3>EXTRAPOLATE_THRESHOLD) {
			double val1 = f3+(f3-f2);
			double val2 = f3+(f3-f1)/2;
			if(Math.max(val1, val2)>HIGH_THRESHOLD) q-=2;
		}
		else if(f1<LOW_THRESHOLD&&f2<LOW_THRESHOLD&&f3<LOW_THRESHOLD) {
			q++;
		}
		q = guaranteeInRange(1, 10, q);
		System.out.println(q);
    }
    static int guaranteeInRange(int min, int max, int val) {
		val = Math.max(min, val);
		val = Math.min(max, val);
		return val;
	}
}
